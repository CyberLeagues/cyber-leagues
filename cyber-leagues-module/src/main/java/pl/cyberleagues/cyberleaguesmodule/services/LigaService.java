package pl.cyberleagues.cyberleaguesmodule.services;

import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.Liga;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LigaService {

    //to potem zamienimy na funkcje gdzie bedziesz mogl dodawac ligi...
    private final List<Liga> ligaList = new ArrayList<>(List.of(
            new Liga("Aram Turniej w League Of Legends!","LeagueOfLegends"),
            new Liga("Aram Turniej2 w League Of Legends!","LeagueOfLegends"),
            new Liga("Turniej Dota2!","Dota2"),
            new Liga("Turniej Valorant!","Valorant"),
            new Liga("Turniej RocketLeague!","RocketLeague"),
            new Liga("Turniej CSGO2!","CSGO"),
            new Liga("Turniej CSGO2!","CSGO"),
            new Liga("Turniej CSGO2!","CSGO")
    ));

    public List<Liga> getLigaList()
    {
        return ligaList;
    }

    public List<Liga> getLigaByGame(String gameName)
    {

        return ligaList.stream().filter(liga -> liga.getGame().equals(gameName)).collect(Collectors.toList());
    }

}
