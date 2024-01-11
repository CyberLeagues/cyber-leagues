package pl.cyberleagues.cyberleaguesmodule.services;

import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.listobjectfolder.ListHolderContainer;
import pl.cyberleagues.cyberleaguesmodule.models.Liga;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LigaService {

    //to potem zamienimy na funkcje gdzie bedziesz mogl dodawac ligi...
    private final List<Liga> ligaList = ListHolderContainer.ligaList;

    public List<Liga> getLigaList()
    {
        return ligaList;
    }

    public List<Liga> getLigaByGame(String gameName)
    {

        return ligaList.stream().filter(liga -> liga.getGame().equals(gameName)).collect(Collectors.toList());
    }

}
