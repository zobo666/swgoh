create table swgoh.operations (
	id SERIAL primary key,
	territory_id SERIAL,
	operation_no INTEGER,
	territory_points BIGINT,
	constraint fk_territories
      foreign key(territory_id) 
	  references territories(id)
);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (1, 1, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (1, 2, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (1, 3, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (1, 4, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (1, 5, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (1, 6, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (2, 1, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (2, 2, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (2, 3, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (2, 4, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (2, 5, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (2, 6, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (3, 1, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (3, 2, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (3, 3, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (3, 4, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (3, 5, 100000000);

insert into swgoh.operations (territory_id, operation_no, territory_points)
values (3, 6, 100000000);

