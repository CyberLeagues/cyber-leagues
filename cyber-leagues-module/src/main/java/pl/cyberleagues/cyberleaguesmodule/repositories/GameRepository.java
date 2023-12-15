package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cyberleagues.cyberleaguesmodule.models.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
