CREATE TABLE swgoh.player_toons (
    id SERIAL primary KEY,
    swgoh_id VARCHAR not null,
    player_id SERIAL not null,
    toon_id SERIAL not null,
    rarity INTEGER,
    level INTEGER,
    gear INTEGER,
    gp INTEGER,
    relic_tier INTEGER,
    CONSTRAINT fk_player
      FOREIGN KEY(player_id) 
	  REFERENCES swgoh.players(id),
	CONSTRAINT fk_caracter
      FOREIGN KEY(caracter_id) 
	  REFERENCES swgoh.caracters(id)
	  
);