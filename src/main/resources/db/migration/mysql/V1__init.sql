create table message (
        id integer not null auto_increment,
        text varchar(255),
        user_id binary(255),
        primary key (id)
    );

create table user (
        id binary(255) not null,
        name varchar(255),
        primary key (id)
    );

alter table message
    add constraint FKb3y6etti1cfougkdr0qiiemgv
    foreign key (user_id)
    references user (id);