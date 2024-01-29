package pl.cyberleagues.cyberleaguesmodule.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.Registration;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public String getUserById(Model model, @PathVariable Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userTemplates/user";
    }

    @GetMapping("/ownedLeagues")
    public String getOwnedLeagues(Principal principal, Model model) {
        User user = userService.getUserByProviderId(principal.getName());
        model.addAttribute("ownedLeagues", user.getOwnedLeagues());
        model.addAttribute("registration", new Registration());

        return "leagueTemplates/manager";
    }

    @GetMapping("/team")
    public String getOwnedTeam(Principal principal, Model model) {
        if (principal==null){
            return "/userTemplates/login";
        }
        User user = userService.getUserByProviderId(principal.getName());
        model.addAttribute("team", user.getTeam());
        model.addAttribute("user",user);

        return "teamTemplate/manager";
    }
}
