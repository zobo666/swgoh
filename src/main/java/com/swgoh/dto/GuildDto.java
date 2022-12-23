package com.swgoh.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swgoh.entity.Guild;
import lombok.Data;

import java.util.List;

@Data
public class GuildDto {

    private String id;

    private String name;

    private String desc;

    private Long members;

    private Long status;

    private Long required;

    private String bannerColor;

    private String bannerLogo;

    private String message;

    private Long gp;

    @JsonIgnore
    private String raid;

    private List<GuildPlayerDto> roster;

    private long updated;

    public Guild toGuild() {
        Guild guild = new Guild();

        guild.setSwgohId(id);
        guild.setGuildName(name);
        guild.setDescription(desc);
        guild.setMessage(message);

        return guild;
    }
}
