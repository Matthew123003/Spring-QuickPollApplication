create database poll;
use poll;
create table poll(
poll_id Long PRIMARY KEY NOT NULL AUTO_INCREMENT,
question VARCHAR(255) NOT NULL
);
create table option(
option_id Long PRIMARY KEY NOT NULL AUTO_INCREMENT,
option_value varchar(255) NOT NULL,
poll_id Long,
);

insert into poll (poll_id, question) values (1, 'What is your favorite color?');
insert into poll (poll_id, question) values (2, 'What is your favorite movie?');
insert into poll (poll_id, question) values (3, 'What is your favorite day?');
insert into poll (poll_id, question) values (4, 'What is your favorite month?');
insert into poll (poll_id, question) values (5, 'What is your favorite year?');
insert into poll (poll_id, question) values (6, 'What is your favorite band?');
insert into poll (poll_id, question) values (7, 'What is your favorite person?');
insert into poll (poll_id, question) values (8, 'What is your favorite icecream?');
insert into poll (poll_id, question) values (9, 'What is your favorite food?');
insert into poll (poll_id, question) values (10, 'What is your favorite drink?');
insert into poll (poll_id, question) values (11, 'What is your favorite meal of the day?');
insert into poll (poll_id, question) values (12, 'How tall are you?');
insert into poll (poll_id, question) values (13, 'How much do you weigh?');
insert into poll (poll_id, question) values (14, 'What is your hair color?');
insert into poll (poll_id, question) values (15, 'What is your eye color?');

insert into option (option_id, option_value, poll_id) values (1, 'Red', 1);
insert into option (option_id, option_value, poll_id) values (2, 'Blue', 1);
insert into option (option_id, option_value, poll_id) values (3, 'Green', 1);
insert into option (option_id, option_value, poll_id) values (1, 'The Matrix', 2);
insert into option (option_id, option_value, poll_id) values (2, 'Fight Club', 2);
insert into option (option_id, option_value, poll_id) values (3, 'Princess Mononoke', 2);
insert into option (option_id, option_value, poll_id) values (1, 'Monday', 3);
insert into option (option_id, option_value, poll_id) values (2, 'Tuesday', 3);
insert into option (option_id, option_value, poll_id) values (3, 'Wednesday', 3);
insert into option (option_id, option_value, poll_id) values (1, 'Jan', 4);
insert into option (option_id, option_value, poll_id) values (2, 'Feb', 4);
insert into option (option_id, option_value, poll_id) values (3, 'Mar', 4);
insert into option (option_id, option_value, poll_id) values (1, '1945', 5);
insert into option (option_id, option_value, poll_id) values (2, '1999', 5);
insert into option (option_id, option_value, poll_id) values (3, '2024', 5);
insert into option (option_id, option_value, poll_id) values (1, 'RHCP', 6);
insert into option (option_id, option_value, poll_id) values (2, '311', 6);
insert into option (option_id, option_value, poll_id) values (3, '3EB', 6);
insert into option (option_id, option_value, poll_id) values (1, 'Mike Tyson', 7);
insert into option (option_id, option_value, poll_id) values (2, 'Me', 7);
insert into option (option_id, option_value, poll_id) values (3, 'You', 7);
insert into option (option_id, option_value, poll_id) values (1, 'Choc PB', 8);
insert into option (option_id, option_value, poll_id) values (2, 'Mint CC', 8);
insert into option (option_id, option_value, poll_id) values (3, 'Rocky Road', 8);
insert into option (option_id, option_value, poll_id) values (1, 'Burgers', 9);
insert into option (option_id, option_value, poll_id) values (2, 'Chicken', 9);
insert into option (option_id, option_value, poll_id) values (3, 'Pasta', 9);
insert into option (option_id, option_value, poll_id) values (1, 'Milk', 10);
insert into option (option_id, option_value, poll_id) values (2, 'Water', 10);
insert into option (option_id, option_value, poll_id) values (3, 'Gatorade', 10);
insert into option (option_id, option_value, poll_id) values (1, 'Breakfast', 11);
insert into option (option_id, option_value, poll_id) values (2, 'Lunch', 11);
insert into option (option_id, option_value, poll_id) values (3, 'Dinner', 11);
insert into option (option_id, option_value, poll_id) values (1, '6 Foot or more', 12);
insert into option (option_id, option_value, poll_id) values (2, '5 1/2 foot to 6 Foot', 12);
insert into option (option_id, option_value, poll_id) values (3, '5 Foot to 5 1/2 Foot', 12);
insert into option (option_id, option_value, poll_id) values (1, '100 - 150', 13);
insert into option (option_id, option_value, poll_id) values (2, '150 -200', 13);
insert into option (option_id, option_value, poll_id) values (3, '200+', 13);
insert into option (option_id, option_value, poll_id) values (1, 'Red', 14);
insert into option (option_id, option_value, poll_id) values (2, 'Brown', 14);
insert into option (option_id, option_value, poll_id) values (3, 'Blonde', 14);
insert into option (option_id, option_value, poll_id) values (1, 'Brown', 15);
insert into option (option_id, option_value, poll_id) values (2, 'Green', 15);
insert into option (option_id, option_value, poll_id) values (3, 'Blue', 15);

drop database poll;
