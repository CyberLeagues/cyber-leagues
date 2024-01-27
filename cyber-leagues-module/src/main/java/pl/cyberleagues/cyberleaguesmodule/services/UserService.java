package pl.cyberleagues.cyberleaguesmodule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public List<User> getAllUsers()
    {
        return repository.findAll();
    }
    public  User getUserById(long id){
        Optional<User> user = repository.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }


}
