package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cyberleagues.cyberleaguesmodule.models.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findAuthorityByAuthorityIgnoreCase(String name);
}
