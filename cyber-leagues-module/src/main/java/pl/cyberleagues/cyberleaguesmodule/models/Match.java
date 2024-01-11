package pl.cyberleagues.cyberleaguesmodule.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "maches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo: delete later for test
    @ManyToOne
    private League league;

    @ManyToOne
    private Team teamA;

    @ManyToOne
    private Team teamB;

    private LocalDateTime starts;

    private Integer scoreA;

    private Integer scoreB;
}
