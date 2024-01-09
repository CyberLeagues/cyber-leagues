package pl.cyberleagues.cyberleaguesmodule.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class User implements UserDetails {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "Name")
//    private String name;
//
//    @Column(name = "Email")
//    private String email;
//
//    @Column(name = "Password")
//    private String password;
//
//    @ManyToOne
//    @JoinColumn(name = "Team_Id", nullable = false)
//    private Team team;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<Authority> authorities;

    private String password;

    private String name;

    private String picture;

    @Column(unique = true)
    private String username;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private String provider;

    private String providerId;

    private boolean enabled;

}
