package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.dto.UserInfo;
import pl.cyberleagues.cyberleaguesmodule.models.Authority;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.repositories.AuthorityRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.UserRepository;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OAuth2UserService extends OidcUserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);

        return processOidcUser(userRequest, oidcUser);
    }

    private OidcUser processOidcUser(OidcUserRequest userRequest, OidcUser oidcUser) {
        Map<String, Object> attributes = oidcUser.getAttributes();

        UserInfo userInfo = UserInfo
                .builder()
                .name(attributes.get("name").toString())
                .id(attributes.get("sub").toString())
                .email(attributes.get("email").toString())
                .picture(attributes.get("picture").toString())
                .build();


        Optional<User> userOptional = userRepository.findByUsername(userInfo.email());

        if (userOptional.isPresent()) {
            updateExistingUser(userOptional.get(), userInfo);
        } else {
            registerNewUser(userRequest, userInfo);
        }

        return oidcUser;
    }

    private void registerNewUser(OidcUserRequest userRequest, UserInfo userInfo) {
        Authority authority = authorityRepository.findAuthorityByAuthorityIgnoreCase("USER");
        Set<Authority> authorities = Set.of(authority);

        User user = new User();
        user.setProvider(userRequest.getClientRegistration().getRegistrationId());
        user.setProviderId(userInfo.id());
        user.setName(userInfo.name());
        user.setUsername(userInfo.email());
        user.setPicture(userInfo.picture());
        user.setAuthorities(authorities);
        userRepository.save(user);
    }

    private void updateExistingUser(User existingUser, UserInfo userInfoDto) {
        existingUser.setName(userInfoDto.name());
        existingUser.setPicture(userInfoDto.picture());
        userRepository.save(existingUser);
    }

}
