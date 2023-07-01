INSERT INTO `users` (`id`, `firstname`, `lastname`, `password`) values
('1',	'us1', 'last1', '$2a$10$mIj7rv/YKpUStQHJx1raEOnQzydYLylDfzUetzJfrpTpIXK7myWoi'), -- psw: ciao
('2',	'us2', 'last2', '$2a$10$mIj7rv/YKpUStQHJx1raEOnQzydYLylDfzUetzJfrpTpIXK7myWoi'),
('3',	'us3', 'last3', '$2a$10$mIj7rv/YKpUStQHJx1raEOnQzydYLylDfzUetzJfrpTpIXK7myWoi');

INSERT INTO `user_role` (`user_id`, `role`) values
('1', 'USER'),
('2', 'USER'),
('3', 'ADMIN');

INSERT INTO `exercise` (`id`, `name`) values
('1',	'ex1'),
('2',	'ex2'),
('3',	'ex3'),
('4',	'ex4'),
('5',	'ex5');

INSERT INTO `record_entry` (`id`, `user_id`, `exercise_id`, `record_date`, `value`, `percentage`, `creation_timestamp`, `last_modification_timestamp`) values
(1,	'1',	'1',	'2023-01-01',	100.00, 1.00, '2015-04-03 14:00:45', '2015-04-03 14:00:45'),
(2,	'1',	'2',	'2023-01-02',	110.00, 1.00, '2015-04-03 14:00:45', '2015-04-03 14:00:45'),
(3,	'1',	'3',	'2023-01-03',	120.00, 1.00, '2015-04-03 14:00:45', '2015-04-03 14:00:45'),
(4,	'2',	'1',	'2023-01-04',	120.00, 1.00, '2015-04-03 14:00:45', '2015-04-03 14:00:45'),
(5,	'3',	'2',	'2023-01-05',	100.00, 1.00, '2015-04-03 14:00:45', '2015-04-03 14:00:45');


