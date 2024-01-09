package pl.cyberleagues.cyberleaguesmodule.dto;

import lombok.Builder;

@Builder
public record UserInfo(
        String name,
        String id,
        String email,
        String picture
) {}
