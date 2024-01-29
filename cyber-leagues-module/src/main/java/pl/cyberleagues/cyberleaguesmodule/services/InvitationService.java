package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.Invitation;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.repositories.InvitationRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.TeamRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.UserRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class InvitationService {
    private final InvitationRepository invitationRepository;
    private final UserService userService;
    private final TeamService teamService;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public void addInvitation(Invitation incompleteInvitaion) {
        User user = userService.getUserByProviderId(incompleteInvitaion.getUser().getProviderId());
        Team team = teamService.getTeamById(incompleteInvitaion.getTeam().getId());
        Invitation invitation= new Invitation();

        invitation.setTeam(team);
        invitation.setUser(user);
        Invitation invitationCheck = invitationRepository.findFirstByUserEqualsAndTeamEquals(user,team);
        if (invitationCheck==null){
            invitationRepository.save(invitation);
        }
    }

    public List<Invitation> getAllInvitations(User user){
        return invitationRepository.findByUserEquals(user);
    }

    public Invitation getInvitationById(Long id){
        return invitationRepository.findById(id).get();
    }

    public void acceptInvitation(Invitation invitation) {
        Team team = teamService.getTeamById(invitation.getTeam().getId());
        User user = userService.getUserByProviderId(invitation.getUser().getProviderId());

        if (user.getTeam()!= null){
            user.getTeam().getPlayers().remove(user);
            Team previousTeam = user.getTeam();
            teamRepository.save(team);
        }

        user.setTeam(team);
        team.getPlayers().add(user);

        userRepository.save(user);
        teamRepository.save(team);

        invitationRepository.delete(invitation);
    }

    public void declineInvitation(Invitation invitation) {
        invitationRepository.delete(invitation);
    }
}
