use cloud;

drop table cloud_name_and_password;

create table cloud_name_and_password
(
    Id LONG,
    username varchar(255),
    password varchar(1000) NOT NULL
);

insert into cloud_name_and_password(Id, username, password) VALUES ('1', 'Andrei', '{noop}111111');
insert into cloud_name_and_password(Id, username, password) VALUES ('2', 'Ivan', '{noop}000000');
