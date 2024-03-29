package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cyberleagues.cyberleaguesmodule.models.Game;
import pl.cyberleagues.cyberleaguesmodule.models.League;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

    List<League> getLeagueByGame(Game game);

    List<League> findByStartsAfter(LocalDateTime localDateTime);

}
