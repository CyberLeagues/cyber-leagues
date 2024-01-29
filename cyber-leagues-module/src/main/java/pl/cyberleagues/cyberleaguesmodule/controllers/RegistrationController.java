package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cyberleagues.cyberleaguesmodule.models.Invitation;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.Registration;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.RegistrationService;
import pl.cyberleagues.cyberleaguesmodule.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final UserService userService;

    @PostMapping("/registrationManager")
    public String getRegistrations(@ModelAttribute("registration") Registration registration, Model model){
       List<Registration> registrations =  registrationService.getRegistrations(registration);

       model.addAttribute("registrations", registrations);
       model.addAttribute("registration",new Registration());
       return "registrationTemplate/registrations";
    }
    
    @PostMapping("/apply")
    public String createRegistration(@ModelAttribute("registration") Registration registration, Model model, Principal principal) {

        registrationService.addRegistration(registration);

        User user = userService.getUserByProviderId(principal.getName());
        List<User> users = userService.getAllUsers();

        model.addAttribute("team", user.getTeam());
        model.addAttribute("user",user);

        return "teamTemplate/team";
    }

    @PostMapping("/accept")
    public String acceptRegistration(@ModelAttribute("registration") Registration incompleteRegistration, Model model) {
        Registration registration = registrationService.getRegistrationById(incompleteRegistration.getId());
        registrationService.acceptRegistration(registration);
        List<Registration> registrations =  registrationService.getRegistrations(registration);

        model.addAttribute("registrations", registrations);
        model.addAttribute("registration",new Registration());
        return "registrationTemplate/registrations";
    }

    @PostMapping("/decline")
    public String declineRegistration(@ModelAttribute("registration") Registration incompleteRegistration, Model model) {
        Registration registration = registrationService.getRegistrationById(incompleteRegistration.getId());
        registrationService.declineRegistration(registration);
        List<Registration> registrations =  registrationService.getRegistrations(registration);

        model.addAttribute("registrations", registrations);
        model.addAttribute("registration",new Registration());
        return "registrationTemplate/registrations";
    }
}
