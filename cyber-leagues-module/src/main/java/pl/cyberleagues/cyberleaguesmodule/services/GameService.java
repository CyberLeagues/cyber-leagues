package pl.cyberleagues.cyberleaguesmodule.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.listobjectfolder.ListHolderContainer;
import pl.cyberleagues.cyberleaguesmodule.models.Game;
import pl.cyberleagues.cyberleaguesmodule.models.Liga;
import pl.cyberleagues.cyberleaguesmodule.models.Team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {


    private final List<Game> ligaList = ListHolderContainer.gameList;


    public List<Game> getGameList()
    {
        return ligaList;
    }

    public List<Game> findGameByLigaId(Long ligaID)
    {
        return ligaList.stream().filter(game -> game.getLiga().getId()==ligaID).collect(Collectors.toList());
    }


}
