use cloud;

drop table cloud_name_and_password;

create table cloud_name_and_password
(
    Id LONG,
    username varchar(255),
    password varchar(255)
);

insert into cloud_name_and_password(Id, username, password) VALUES ('1', 'Andrei', '111111');
insert into cloud_name_and_password(Id, username, password) VALUES ('2', 'Ivan', '000000');
