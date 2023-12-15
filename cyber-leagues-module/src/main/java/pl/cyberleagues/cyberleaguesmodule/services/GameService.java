package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.Game;
import pl.cyberleagues.cyberleaguesmodule.repositories.GameRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repository;

    public List<Game> getGames(){
        return repository.findAll();
    }
}
