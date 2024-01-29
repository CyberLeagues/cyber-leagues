package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.*;
import pl.cyberleagues.cyberleaguesmodule.repositories.LeagueRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.RegistrationRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final LeagueService leagueService;
    private final TeamService teamService;
    private final LeagueRepository leagueRepsitory;
    private TeamRepository teamRepository;


    public List<Registration> getRegistrations(Registration registration) {
        League league = leagueService.getLeagueByID(registration.getLeague().getId());
        return registrationRepository.findByLeagueEquals(league);
    }

    public void addRegistration(Registration incompleteRegistration) {
        League league = leagueService.getLeagueByID(incompleteRegistration.getLeague().getId());
        Team team = teamService.getTeamById(incompleteRegistration.getTeam().getId());
        Registration registration = new Registration();

        registration.setTeam(team);
        registration.setLeague(league);
        Registration registrationCheck = registrationRepository.findFirstByLeagueEqualsAndTeamEquals(league, team);
        if (registrationCheck == null) {
            registrationRepository.save(registration);
        }
    }

    public Registration getRegistrationById(Long id) {
        return registrationRepository.findById(id).get();
    }

    public void acceptRegistration(Registration registration) {
        Team team = registration.getTeam();
        League league = registration.getLeague();

        if (team.getLeague() != null) {
            team.getLeague().getTeams().remove(team);
            League previousLeague = team.getLeague();
            leagueRepsitory.save(previousLeague);
        }

        team.setLeague(league);
        league.getTeams().add(team);

        leagueRepsitory.save(league);
        teamRepository.save(team);

        registrationRepository.delete(registration);
    }


    public void declineRegistration(Registration registration) {
        registrationRepository.delete(registration);
    }
}
