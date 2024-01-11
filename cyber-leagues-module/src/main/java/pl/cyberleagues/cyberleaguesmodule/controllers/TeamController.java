package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.services.TeamService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/team")
    public String getTeamViewByTeamID(Model model, @RequestParam(value = "teamId") Long teamId)
    {
        Team team = teamService.findTeamById(teamId);
        if(team!=null)
        {
            System.out.println(teamId);
            System.out.println(team.getName());
            model.addAttribute("team",team);
        }

        return "teamTemplate/team";
    }

}
