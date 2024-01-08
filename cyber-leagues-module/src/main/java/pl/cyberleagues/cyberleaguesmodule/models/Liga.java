package pl.cyberleagues.cyberleaguesmodule.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Liga")
@Getter
@Setter
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Game")
    private String game;

    public Liga() {}

    public Liga(String name, String game) {
        this.name = name;
        this.game = game;
    }
}

