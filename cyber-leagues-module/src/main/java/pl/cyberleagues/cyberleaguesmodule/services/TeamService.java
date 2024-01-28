package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.listobjectfolder.ListHolderContainer;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.repositories.TeamRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.UserRepository;

import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public Team getTeamById(Long id) {
       Optional<Team> team = teamRepository.findById(id);
       if (team.isPresent()){
           return team.get();
       }
       return null;
    }

    public void createTeam(Team team, User user) {
        team.setOwner(user);
        user.setTeam(team);
        teamRepository.save(team);
        userRepository.save(user);
    }
}
