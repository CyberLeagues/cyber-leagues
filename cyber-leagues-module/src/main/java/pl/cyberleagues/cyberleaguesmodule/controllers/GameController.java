package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.cyberleagues.cyberleaguesmodule.models.Game;
import pl.cyberleagues.cyberleaguesmodule.services.GameService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final GameService service;

    @GetMapping("/game")
    public String getGameByLigaId(Model model, @RequestParam(value = "ligaId") Long ligaId)
    {
        model.addAttribute("games",service.findGameByLigaId(ligaId));
        return "gameTemplates/games";
    }


}
