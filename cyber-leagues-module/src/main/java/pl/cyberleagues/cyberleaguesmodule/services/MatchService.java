package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.dto.MatchFormDto;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.Match;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.repositories.LeagueRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.MatchRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MatchService {


    private final MatchRepository matchRepository;
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;


    public List<Match> getMatchesByLeagueId(Long leagueID)
    {
        return matchRepository.findAllByLeagueId(leagueID);
    }

    public Match getMatchById(Long id){
        Optional<Match> byId = matchRepository.findById(id);
        return byId.orElseThrow();
    }

    public void createMatch(Match match, League league, MatchFormDto matchFormDto) {
        Optional<Team> TeamA = teamRepository.findById(matchFormDto.getTeamAId());
        Optional<Team> TeamB = teamRepository.findById(matchFormDto.getTeamBId());

        match.setTeamA(TeamA.orElse(null));
        match.setTeamB(TeamB.orElse(null));
        match.setLeague(league);
        match.setScoreA(0);
        match.setScoreB(0);

//todo: do wyświetlania histori gier
//        TeamA.get().getMatches().add(match);
//        TeamB.get().getMatches().add(match);

        league.getMatches().add(match);

        matchRepository.save(match);
        leagueRepository.save(league);
//        teamRepository.save(TeamA.get());
//        teamRepository.save(TeamB.get());
    }

    public Match save(Match match, Match newScores) {
        match.setScoreA(newScores.getScoreA());
        match.setScoreB(newScores.getScoreB());
        return matchRepository.save(match);
    }
}
