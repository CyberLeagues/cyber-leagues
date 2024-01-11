package pl.cyberleagues.cyberleaguesmodule.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime starts;

    @ManyToOne
    private User owner;

    private int maxNumberOfTeams;

    private boolean isOpen;

    private Game game;

    private String description;

    @OneToMany
    private List<Match> matches;
//    Todo: implement after others models will be implemented
//    private Score scores;

}

