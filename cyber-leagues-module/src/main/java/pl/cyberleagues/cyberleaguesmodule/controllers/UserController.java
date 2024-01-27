package pl.cyberleagues.cyberleaguesmodule.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping("/ownedLeagues")
    public String getOwnedLeagues(Principal principal, Model model){
        User user = service.getUserByProviderId(principal.getName());
        model.addAttribute("ownedLeagues", user.getOwnedLeagues());

        return "leagueTemplates/manager";
    }
}
