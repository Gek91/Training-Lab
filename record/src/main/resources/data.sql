INSERT INTO `users` (id, firstname, lastname, password) values
('1',	'us1', 'last1', '$2a$10$mIj7rv/YKpUStQHJx1raEOnQzydYLylDfzUetzJfrpTpIXK7myWoi'), -- psw: ciao
('2',	'us2', 'last2', '$2a$10$mIj7rv/YKpUStQHJx1raEOnQzydYLylDfzUetzJfrpTpIXK7myWoi'),
('3',	'us3', 'last3', '$2a$10$mIj7rv/YKpUStQHJx1raEOnQzydYLylDfzUetzJfrpTpIXK7myWoi');

INSERT INTO user_role (user_id, role) values
('1', 'USER'),
('2', 'USER'),
('3', 'ADMIN');

INSERT INTO exercise (id, name) values
('1',	'ex1'),
('2',	'ex2'),
('3',	'ex3'),
('4',	'ex4'),
('5',	'ex5')