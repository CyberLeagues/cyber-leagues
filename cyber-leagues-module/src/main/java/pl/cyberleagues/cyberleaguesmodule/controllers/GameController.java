package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cyberleagues.cyberleaguesmodule.models.Game;
import pl.cyberleagues.cyberleaguesmodule.services.GameService;

import java.util.List;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService service;

    @GetMapping("/all")
    public List<Game> games(){
        return service.getGames();
    }
}
