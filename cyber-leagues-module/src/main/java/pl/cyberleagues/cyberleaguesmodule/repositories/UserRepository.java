package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cyberleagues.cyberleaguesmodule.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
