package pl.cyberleagues.cyberleaguesmodule.services;

import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.Liga;

import java.util.ArrayList;
import java.util.List;

@Service
public class LigaService {

    private final List<Liga> ligaList = new ArrayList<>(List.of(new Liga("Aram Turniej 3Cock","LeagueOfLegends"),new Liga("Cwel Gra 3D","Dota2")));

    public List<Liga> getLigaList()
    {
        return ligaList;
    }
}
