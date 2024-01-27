package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.Match;
import pl.cyberleagues.cyberleaguesmodule.repositories.MatchRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MatchService {


    private final MatchRepository matchRepository;


    public List<Match> getMatchesByLeagueId(Long leagueID)
    {
        return matchRepository.findAllByLeagueId(leagueID);
    }


}
