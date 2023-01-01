create table swgoh.territories (
	id SERIAL primary key,
	battle_id SERIAL not null,
	zone_no INTEGER not null,
	name VARCHAR,
	alignment VARCHAR check (alignment in ('L', 'D', 'N', 'M')),
	relic INTEGER,
	first_star BIGINT,
	second_star BIGINT,
	third_star BIGINT,
	constraint fk_battles
      foreign key(battle_id) 
	  references battles(id));
	
insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 1, 'Coruscent', 'L');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 1, 'Corelia', 'M');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 1, 'Mustafar', 'D');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 2, 'Bracca', 'L');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 2, 'Felucia', 'M');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 2, 'Geonosis', 'D');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 3, 'Kashyyyk', 'L');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 3, 'Tatooine', 'M');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 3, 'Dathomir', 'D');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 4, 'Lothal', 'L');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 4, 'Kessel', 'M');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 4, 'Haven-class Medical Station', 'D');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 5, 'Ring of Kafrene', 'L');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 5, 'Vandor', 'M');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 5, 'Malachor', 'D');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 6, 'Scarif', 'L');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 6, 'Hoth', 'M');

insert into swgoh.territories (battle_id, zone_no, name, alignment)
values (1, 6, 'Death Star', 'D');

