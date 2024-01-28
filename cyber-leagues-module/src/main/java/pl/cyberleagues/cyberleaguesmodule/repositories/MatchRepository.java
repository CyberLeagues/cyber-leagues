package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cyberleagues.cyberleaguesmodule.models.Match;

import java.util.List;


@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {


    List<Match> findAllByLeagueId(Long leagueID);

}
