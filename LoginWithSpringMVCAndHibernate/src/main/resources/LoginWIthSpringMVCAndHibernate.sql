CREATE DATABASE LoginWithSpringMVCAndHibernate;

CREATE TABLE `user` (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  PRIMARY KEY (user_id)
);

INSERT INTO `user` (user_id, email, password) VALUES (1, 'admin@gmail.com', '123456');
INSERT INTO `user` (user_id, email, password) VALUES (2, 'user@gmail.com', '123456');