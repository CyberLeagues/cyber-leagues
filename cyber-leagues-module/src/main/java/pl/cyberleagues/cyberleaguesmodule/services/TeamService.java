package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.Game;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.repositories.GameRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository repository;

    public List<Team> getTeams(){
        return repository.findAll();
    }
}
