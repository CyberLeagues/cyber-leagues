package pl.cyberleagues.cyberleaguesmodule.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "league")
    @JsonIgnoreProperties("league")
    private List<Match> matches;
//    Todo: implement after others models will be implemented
//    private Score scores;

}

