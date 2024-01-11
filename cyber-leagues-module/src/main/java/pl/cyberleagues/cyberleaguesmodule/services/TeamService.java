package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.listobjectfolder.ListHolderContainer;
import pl.cyberleagues.cyberleaguesmodule.models.Game;
import pl.cyberleagues.cyberleaguesmodule.models.Liga;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.repositories.GameRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {


    private final List<Team> teamList = ListHolderContainer.teamList;


    //zwraca team po nazwie?
//    public Team getTeamByName(String nameTeam)
//    {
//        teamList.stream().map(team -> {
//            if (team.getName().equals(nameTeam))
//            {
//                return team;
//            }
//            else return null;
//        });
//        return new Team();
//    }

}
