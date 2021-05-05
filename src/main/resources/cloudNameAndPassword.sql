use cloud;

drop table cloud_name_and_password;

create table cloud_name_and_password
(
    file_path varchar(255),
    user_name varchar(255),
    password varchar(255)
);

insert into cloud_name_and_password(file_path, user_name, password) VALUES ('userData/data1', 'Andrei', '111111');
insert into cloud_name_and_password(file_path, user_name, password) VALUES ('userData/data2', 'Ivan', '000000');
