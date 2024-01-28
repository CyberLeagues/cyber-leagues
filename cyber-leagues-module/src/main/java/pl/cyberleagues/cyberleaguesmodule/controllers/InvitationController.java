package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cyberleagues.cyberleaguesmodule.models.Invitation;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.InvitationService;
import pl.cyberleagues.cyberleaguesmodule.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invitation")
public class InvitationController {
    private final InvitationService invitationService;
    private final UserService userService;

    @GetMapping("/invteam")
    public String getInvitation(){
        return "/teamTemplate/invitation";
    }

    @PostMapping("/create")
    public String createInvitation(@ModelAttribute("invitation") Invitation invitation, Model model, Principal principal) {

        invitationService.addInvitation(invitation);

        User user = userService.getUserByProviderId(principal.getName());
        List<User> users = userService.getAllUsers();

        model.addAttribute("user", user);
        model.addAttribute("invitation", new Invitation());
        model.addAttribute("users", users);

        return "teamTemplate/manageTeam";
    }
}

