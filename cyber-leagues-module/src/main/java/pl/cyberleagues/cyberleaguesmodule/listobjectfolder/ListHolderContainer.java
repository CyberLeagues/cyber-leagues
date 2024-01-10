package pl.cyberleagues.cyberleaguesmodule.listobjectfolder;

import pl.cyberleagues.cyberleaguesmodule.models.Game;
import pl.cyberleagues.cyberleaguesmodule.models.Liga;
import pl.cyberleagues.cyberleaguesmodule.models.Team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListHolderContainer {

    public static final List<Game> gameList= new ArrayList<>(List.of(
            new Game(new Liga(1L,"Super Turniej","CSGO"),
               new Team("KutasTeam1")
               ,new Team("KutasTeam2")
               ,new Date(),
               1,
                       0),
                       new Game(new Liga(1L,"Super Turniej","CSGO"),
                    new Team("KutasTeam3")
                    ,new Team("KutasTeam4")
                    ,new Date(),
                    0,
                            1),
                            new Game(new Liga(2L,"NieSuper Turniej","CSGO"),
                    new Team("KutasTeam5")
                    ,new Team("KutasTeam6")
                    ,new Date(),
                    0,
                            0),
                            new Game(new Liga(4L,"NieSuper Ligi","LeagueOfLegends"),
                    new Team("KutasTeamLiga1")
                    ,new Team("KutasTeamLiga2")
                    ,new Date(),
                    1,
                            0)

    ));


    public static final List<Liga> ligaList = new ArrayList<>(List.of(
            new Liga(4L,"Aram Turniej w League Of Legends!","LeagueOfLegends"),
            new Liga(4L,"Aram Turniej2 w League Of Legends!","LeagueOfLegends"),
            new Liga(5L,"Turniej Dota2!","Dota2"),
            new Liga(6L,"Turniej Valorant!","Valorant"),
            new Liga(7L,"Turniej RocketLeague!","RocketLeague"),
            new Liga(2L,"Turniej CSGO2!","CSGO"),
            new Liga(1L,"Turniej CSGO2!","CSGO"),
            new Liga("Turniej CSGO2!","CSGO")
    ));




















}
