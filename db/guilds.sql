CREATE TABLE swgoh.guilds (
    id SERIAL primary KEY,
    swgoh_id VARCHAR not null,
    guild_name VARCHAR,
    description VARCHAR,
    message varchar
);
