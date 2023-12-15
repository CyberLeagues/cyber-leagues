package pl.cyberleagues.cyberleaguesmodule.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/apes")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }
}
