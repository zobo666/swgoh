create table swgoh.battles (
	id SERIAL primary key,
	name VARCHAR,
	code VARCHAR unique );
	
insert into swgoh.battles (name, code)
values ('Rise Of The Empire', 'ROTE');

insert into swgoh.battles (name, code)
values ('Geonosis: Republic Offensive', 'GEOLS');

insert into swgoh.battles (name, code)
values ('Geonosis: Separatist Might', 'GEODS');

insert into swgoh.battles (name, code)
values ('Hoth: Rebel Assault', 'HOTHLS');

insert into swgoh.battles (name, code)
values ('Hoth: imperial Retaliation', 'HOTHDS');

commit;