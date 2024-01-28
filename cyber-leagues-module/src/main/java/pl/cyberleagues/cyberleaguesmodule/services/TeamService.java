package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.listobjectfolder.ListHolderContainer;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.repositories.TeamRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team getTeamById(Long id) {
       Optional<Team> team = teamRepository.findById(id);
       if (team.isPresent()){
           return team.get();
       }
       return null;
    }

    public List<Team> getAll(){
        return teamRepository.findAll();
    }

}
