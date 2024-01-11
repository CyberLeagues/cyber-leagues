package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cyberleagues.cyberleaguesmodule.services.GameService;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final GameService service;

//    @GetMapping("/game")
//    public String getGameByLigaId(Model model, @RequestParam(value = "ligaId") Long ligaId)
//    {
//        model.addAttribute("games",service.findGameByLigaId(ligaId));
//        return "gameTemplates/games";
//    }


}
