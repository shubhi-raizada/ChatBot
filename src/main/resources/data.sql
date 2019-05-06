drop table if exists User;
create table User(id BIGINT primary key auto_increment, phone BIGINT Unique);

drop table if exists Message;
CREATE TABLE Message (
    ID int primary key auto_increment,
    To_USER BIGINT,
    FROM_USER BIGINT,
    msg_TExt varchar(500),
    time_stamp TIMESTAMP,
    PRIMARY KEY (ID),
    FOREIGN KEY (to_user) REFERENCES USER(phone),
    FOREIGN KEY (FROM_USER) REFERENCES USER(phone)
);


insert into user(phone) values(9807654321);
insert into user(phone) values(7890654322);
insert into user(phone) values(9807654373);
insert into user(phone) values(7899654324);
insert into user(phone) values(9007654325);
insert into user(phone) values(7890654326);
