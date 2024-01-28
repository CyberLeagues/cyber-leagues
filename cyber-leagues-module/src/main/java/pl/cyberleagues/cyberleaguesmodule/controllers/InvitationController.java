package pl.cyberleagues.cyberleaguesmodule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvitationController {
    @GetMapping("/invteam")
    public String getInvitation(){
        return "/teamTemplate/invitation";
    }

}
