package pl.cyberleagues.cyberleaguesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cyberleagues.cyberleaguesmodule.models.Invitation;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.models.User;

import java.util.List;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation,Long>{
    Invitation findFirstByUserEqualsAndTeamEquals(User user, Team team);

    List<Invitation> findByUserEquals(User user);
}
