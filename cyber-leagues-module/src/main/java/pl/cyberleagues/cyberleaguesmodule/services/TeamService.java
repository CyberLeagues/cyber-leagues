package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.repositories.TeamRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public Team getTeamById(Long id) {
       Optional<Team> team = teamRepository.findById(id);
        return team.orElse(null);
    }

    public void createTeam(Team team, User user) {
        team.setOwner(user);

        List<User> players = new ArrayList<>();
        players.add(user);

        team.setPlayers(players);
        user.setTeam(team);
        teamRepository.save(team);
        userRepository.save(user);
    }
    public List<Team> getAll(){
        return teamRepository.findAll();
    }


    public void deletePlayer(User user){
        Team team = user.getTeam();

        List<User> players = team.getPlayers();
        players.remove(user);

        team.setPlayers(players);
        user.setTeam(null);
        teamRepository.save(team);
        userRepository.save(user);

    }
}
