package pl.cyberleagues.cyberleaguesmodule.dto;

import lombok.*;
import pl.cyberleagues.cyberleaguesmodule.models.League;


import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatchFormDto {

    private Long teamAId;
    private Long teamBId;
}
