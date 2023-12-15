package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cyberleagues.cyberleaguesmodule.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
