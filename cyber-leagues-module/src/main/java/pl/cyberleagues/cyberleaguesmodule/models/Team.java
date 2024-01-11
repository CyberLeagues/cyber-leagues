package pl.cyberleagues.cyberleaguesmodule.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Team")
@Setter
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;


    //team powinien miec liste userow ktore sa zapisane do niego i by potem moc ich wyswietlic

    public Team() {}

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team(String name) {
        this.name = name;
    }
}
