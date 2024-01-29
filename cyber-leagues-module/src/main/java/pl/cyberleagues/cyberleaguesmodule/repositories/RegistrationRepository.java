package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.Registration;
import pl.cyberleagues.cyberleaguesmodule.models.Team;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>{
   List<Registration> findByLeagueEquals(League league);

   Registration findFirstByLeagueEqualsAndTeamEquals(League league, Team team);
}
