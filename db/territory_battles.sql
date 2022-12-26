create table swgoh.territory_battles (
	id SERIAL primary key,
	name VARCHAR,
	code VARCHAR unique );
	
insert into swgoh.territory_battles (name, code)
values ('Rise Of The Empire', 'ROTE');

insert into swgoh.territory_battles (name, code)
values ('Geonosis: Republic Offensive', 'GEOLS');

insert into swgoh.territory_battles (name, code)
values ('Geonosis: Separatist Might', 'GEODS');

insert into swgoh.territory_battles (name, code)
values ('Hoth: Rebel Assault', 'HOTHLS');

insert into swgoh.territory_battles (name, code)
values ('Hoth: imperial Retaliation', 'HOTHDS');

commit;