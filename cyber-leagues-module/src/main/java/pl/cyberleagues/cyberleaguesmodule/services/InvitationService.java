package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.Invitation;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.repositories.InvitationRepository;


@Service
@RequiredArgsConstructor
public class InvitationService {
    private final InvitationRepository invitationRepository;
    private final UserService userService;
    private final TeamService teamService;
    public void addInvitation(Invitation notCompleteInvitaion) {
        User user = userService.getUserByProviderId(notCompleteInvitaion.getUser().getProviderId());
        Team team = teamService.getTeamById(notCompleteInvitaion.getTeam().getId());
        Invitation invitation= new Invitation();

        invitation.setTeam(team);
        invitation.setUser(user);
        Invitation invitationCheck = invitationRepository.findFirstByUserEqualsAndTeamEquals(user,team);
        if ( !(invitationCheck.getUser().getId() == invitation.getUser().getId() && invitationCheck.getTeam().getId() == invitation.getTeam().getId())){
            invitationRepository.save(invitation);
        }
    }
}
