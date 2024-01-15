package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cyberleagues.cyberleaguesmodule.models.Invitation;
@Repository
public interface InvitationRepository extends JpaRepository<Invitation,Long>{
}
