package pl.cyberleagues.cyberleaguesmodule.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Data
@Entity
public class Authority implements GrantedAuthority {

    @Id
    private Long id;

    public String authority;
}
