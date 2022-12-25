CREATE TABLE swgoh.players (
    id SERIAL primary KEY,
    swgoh_id VARCHAR not null,
    player_name VARCHAR not null,
    level INTEGER,
    ally_code bigint,
    guild_id SERIAL
    CONSTRAINT fk_guild
      FOREIGN KEY(guild_id) 
	  REFERENCES guilds(id)
);
