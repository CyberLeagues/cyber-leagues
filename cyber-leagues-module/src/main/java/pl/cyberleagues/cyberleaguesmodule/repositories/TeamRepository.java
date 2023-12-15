package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cyberleagues.cyberleaguesmodule.models.Team;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
