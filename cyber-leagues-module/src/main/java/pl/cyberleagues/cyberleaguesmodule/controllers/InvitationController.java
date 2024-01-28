package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cyberleagues.cyberleaguesmodule.models.Invitation;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invitaiton")
public class InvitaionController {
    private final InvitationService invitationService;
    @PostMapping("/create")
    public String createInvitation(Model model, @ModelAttribute("invitation")Invitation invitation, Principal principal){

        invitationService.addInvitation(invitation);

        return ""
    }
}
