package pl.cyberleagues.cyberleaguesmodule.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Game")
@Setter
@Getter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Liga_Id", nullable = false)
    private Liga liga;

    @ManyToOne
    @JoinColumn(name = "Team_1_Id", nullable = false)
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "Team_2_Id", nullable = false)
    private Team team2;

    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "Score_A")
    private Integer scoreA;

    @Column(name = "Score_B")
    private Integer scoreB;

    public Game() {}

    public Game(Long id, Liga liga, Team team1, Team team2, Date date, Integer scoreA, Integer scoreB) {
        this.id = id;
        this.liga = liga;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public Game(Liga liga, Team team1, Team team2, Date date, Integer scoreA, Integer scoreB) {
        this.liga = liga;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }
}
