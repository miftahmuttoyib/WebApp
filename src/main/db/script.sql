create table facilities (
	id int not null primary key auto_increment,
    name varchar(150) not null,
    facilities_type varchar(1) not null
);
create table facilities_problem (
	facilities_id int not null,
    problem_id int not null,
    primary key (facilities_id, problem_id),
    foreign key (facilities_id) references facilities(id),
    foreign key (problem_id) references problem(id)
);

create table room (
	id int not null primary key auto_increment,
    name varchar(150) not null
);

create table room_facilities (
	room_id int not null,
    facilities_id int not null,
    primary key (room_id, facilities_id),
    foreign key (room_id) references room(id),
    foreign key (facilities_id) references facilities(id)
);

create table apartment (
	id int not null primary key,
    name varchar(150) not null
);

create table apartment_room (
	apartment_id int not null,
    room_id int not null,
    primary key (apartment_id, room_id),
    foreign key (apartment_id) references apartment(id),
    foreign key (room_id) references room(id)
);

create table floor (
	id int not null primary key auto_increment,
    name varchar(150) not null
);

create table floor_apartment (
	floor_id int not null,
    apartment_id int not null,
    primary key (floor_id, apartment_id),
    foreign key (floor_id) references floor(id),
    foreign key (apartment_id) references apartment(id)
);

create table building (
	id int not null primary key auto_increment,
    name varchar(150) not null
);

create table building_floor (
	building_id int not null,
    floor_id int not null,
    primary key (building_id, floor_id),
    foreign key (building_id) references building(id),
    foreign key (floor_id) references floor(id)
)