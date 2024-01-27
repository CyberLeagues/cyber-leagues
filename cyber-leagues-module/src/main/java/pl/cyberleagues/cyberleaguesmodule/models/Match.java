package pl.cyberleagues.cyberleaguesmodule.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "maches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo: delete later for test
    @ManyToOne
    @JoinColumn(name = "league_id")
    @JsonIgnoreProperties("matches")
    private League league;

    @ManyToOne
    private Team teamA;

    @ManyToOne
    private Team teamB;

    private LocalDateTime starts;

    private Integer scoreA;

    private Integer scoreB;
}
