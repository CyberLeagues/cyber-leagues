package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.repositories.LeagueRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LeagueService {


    private final LeagueRepository leagueRepository;



    public List<League> getAllAvailableLeagues()
    {
        return leagueRepository.findAll();
    }


    public League getLeagueByID(Long ID)
    {
        return leagueRepository.findById(ID).get();
    }


    public League createLeague(League league, User user) {
        league.setOwner(user);
        league.setOpen(true);
        return leagueRepository.save(league);
    }
}
