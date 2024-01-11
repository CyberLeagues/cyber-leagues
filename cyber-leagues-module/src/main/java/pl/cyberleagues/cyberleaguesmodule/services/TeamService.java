package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.listobjectfolder.ListHolderContainer;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import java.util.Set;


@Service
public class TeamService {


    private final Set<Team> teamSet = ListHolderContainer.setofTeam;

    /**
     *  ze strony z ktorej bedziemy przechodzic do team, znajduje sie obiekt Game
     *  ktory przechowuje tez id teamu, za pomoca tego id bedziemy przechodzic do strony z podanym teamem
     *  wieec: przeszukaj liste i znajdz taki team ktorego id jest rowne temu co przyszlo ze strony,
     *  jesli nie znajdzie to null,
     * @param teamID
     * @return
     */

    public Team findTeamById(Long teamID)
    {
        return teamSet.stream().filter(team -> team.getId().equals(teamID)).findFirst().orElse(null);
    }

}
