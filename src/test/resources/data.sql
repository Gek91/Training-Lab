
INSERT INTO "user" (id, firstname, lastname) values
('1',	'us1', 'last1'),
('2',	'us2', 'last2'),
('3',	'us3', 'last3');

INSERT INTO exercise (id, name) values
('1',	'ex1'),
('2',	'ex2'),
('3',	'ex3'),
('4',	'ex4'),
('5',	'ex5');

INSERT INTO record_entry (id, user_id, exercise_id, record_date, "value", percentage) values
(1,	'1',	'1',	'2023-01-01',	100.00, 1.00),
(2,	'1',	'2',	'2023-01-02',	110.00, 1.00),
(3,	'1',	'3',	'2023-01-03',	120.00, 1.00);


