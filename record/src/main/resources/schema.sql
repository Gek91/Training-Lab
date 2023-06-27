
CREATE TABLE `users` (
	id VARCHAR(63) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    password VARCHAR(63) NOT NULL,
    enabled TINYINT(4) NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE user_role (
	user_id VARCHAR(63) NOT NULL,
	role VARCHAR(63) NOT NULL,
	PRIMARY KEY(user_id, role)
) ENGINE = InnoDB;

CREATE TABLE exercise (
	id VARCHAR(63) NOT NULL,
	name VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE record_entry (
	id BIGINT NOT NULL AUTO_INCREMENT ,
	user_id VARCHAR(63) NOT NULL,
	exercise_id VARCHAR(63) NOT NULL,
	record_date DATE NOT NULL,
	`value` DECIMAL(6,2) NOT NULL,
	percentage DECIMAL(3,2) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB;
