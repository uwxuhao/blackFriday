CREATE TABLE Product(
	`product_id` BIGINT AUTO_INCREMENT,
	`product_name` VARCHAR(64) NOT NULL,
	`start_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`end_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`inventory` INT NOT NULL,
	`price` DOUBLE NOT NULL,
	PRIMARY KEY (`product_id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8

INSERT INTO Product(product_name, start_time, end_time, inventory, price)
VALUES ('Iphone8', '2017-01-10 00:00:00', '2017-01-11 00:00:00', 100, 799),
('MacBook Air', '2017-01-10 00:00:00', '2017-01-11 00:00:00', 500, 999),
('MacBook Pro', '2017-01-10 00:00:00', '2017-01-11 00:00:00', 500, 1299),
('ThinkPad X1C', '2017-01-10 00:00:00', '2017-01-11 00:00:00', 500, 899),
('ThinkPad T460S', '2017-01-10 00:00:00', '2017-01-11 00:00:00', 500, 699);


CREATE TABLE ShoppingRecord(
  `record_id` BIGINT AUTO_INCREMENT,
  `user_id` VARCHAR (64) NOT NULL,
  `product_id` BIGINT NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shopping_number` INT NOT NULL,
  PRIMARY KEY (`record_id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8


INSERT INTO ShoppingRecord(user_name, product_id, create_time, shopping_number)
VALUES (1, 1, '2017-01-10 00:00:02', 10),
(1, 2, '2017-01-10 00:00:02', 10),
(1, 3, '2017-01-10 00:00:02', 10)



