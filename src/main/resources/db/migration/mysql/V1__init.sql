create table message (
        id integer not null auto_increment,
        text varchar(255),
        primary key (id)
    );

create table user (
        id binary(255) not null,
        name varchar(255),
        primary key (id)
    );