
CREATE TABLE `users` (
	`id` VARCHAR(63) NOT NULL,
    `firstname` VARCHAR(255) NOT NULL,
    `lastname` VARCHAR(255) NOT NULL,
    `password` VARCHAR(63) NOT NULL,
    `enabled` TINYINT(4) NOT NULL DEFAULT 1,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `user_role` (
	`user_id` VARCHAR(63) NOT NULL,
	`role` VARCHAR(63) NOT NULL,
	PRIMARY KEY(`user_id`, `role`)
) ENGINE = InnoDB;

CREATE TABLE `exercise` (
	`id` VARCHAR(63) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`type` TINYINT(1) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `record_entry` (
	`id` BIGINT NOT NULL AUTO_INCREMENT ,
	`user_id` VARCHAR(63) NOT NULL,
	`exercise_id` VARCHAR(63) NOT NULL,
	`record_date` DATE NOT NULL,
	`value` DECIMAL(6,2) NOT NULL,
	`percentage` DECIMAL(3,2) NOT NULL,
	`creation_timestamp` DATETIME NOT NULL,
	`last_modification_timestamp` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE VIEW `exercise_rm` AS
-- TO CHECK, TWO INNER GROUP TO MANAGE MAX VALUE(InnerQuery) AND POSSIBLE DUPLICATE RECORD WITH SAME MAX VALUE AND DIFFERENT RECORD_DAT (outerQuery)
SELECT `id` as `record_entry_id`, record_entry.exercise_id, record_entry.user_id, (`percentage` * record_entry.`value`) as `value`
from record_entry JOIN (
	SELECT record_entry.exercise_id, record_entry.user_id, innerQuery.`value`, min(record_entry.record_date) as record_date
	FROM record_entry JOIN (
		SELECT exercise_id, user_id, max(`percentage` * `value`) as `value`
		FROM `record_entry`
		GROUP BY `user_id`, `exercise_id`
	) as innerQuery ON record_entry.user_id = innerQuery.user_id AND record_entry.exercise_id = innerQuery.exercise_id and innerQuery.`value` = (record_entry.`percentage` * record_entry.`value`)
	group by record_entry.exercise_id, record_entry.user_id, innerQuery.`value`
) as outerQuery ON record_entry.user_id = outerQuery.user_id AND record_entry.exercise_id = outerQuery.exercise_id and outerQuery.`value` = (record_entry.`percentage` * record_entry.`value`) and outerQuery.record_date = record_entry.record_date




