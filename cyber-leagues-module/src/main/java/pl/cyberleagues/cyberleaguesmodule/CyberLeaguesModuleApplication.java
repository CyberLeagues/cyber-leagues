package pl.cyberleagues.cyberleaguesmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.repositories.TeamRepository;
import pl.cyberleagues.cyberleaguesmodule.repositories.UserRepository;

@SpringBootApplication
public class CyberLeaguesModuleApplication{



    public static void main(String[] args) {
        SpringApplication.run(CyberLeaguesModuleApplication.class, args);
    }

}
