package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.Match;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.repositories.LeagueRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.MatchRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MatchService {


    private final MatchRepository matchRepository;
    private final LeagueRepository leagueRepository;


    public List<Match> getMatchesByLeagueId(Long leagueID)
    {
        return matchRepository.findAllByLeagueId(leagueID);
    }


    public void createMatch(Match match, League league) {
        match.setLeague(league);
        league.getMatches().add(match);
        matchRepository.save(match);
        leagueRepository.save(league);
    }
}
