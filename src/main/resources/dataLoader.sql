USE business;
-- password: welcome123
INSERT INTO `business`.`user` (`userId`, `firstName`, `lastName`, `pass`) VALUES ('navjagat@gmail.com', 'Navneet', 'Prabhakar', '$2a$06$D.TCwqfnjR0K.kbEcHQPUOZVwnwviZSzeB2olZG7QVlxuwSUjeGjC');


INSERT INTO `business`.`role` (`id`, `roleName`) VALUES ('1', 'ROLE_USER');
INSERT INTO `business`.`user_role` (`User_userId`, `roles_id`) VALUES ('navjagat@gmail.com', '1');

UPDATE `business`.`user` SET `avatar`='/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAIBAQIBAQICAgICAgICA…ufyg25lwV3fd9TisOaAb2IffuOduMYoJIp5hJu5I28cjFULhsSHn9asyM0R/xqlPN5r5xQB//Z' WHERE `userId`='navjagat@gmail.com';



INSERT INTO `business` VALUES 
(1,'FOOD','PunkFoods'),
(2,'APPARELL',"Levi's"),
(3,'ELECTRONICS','Sony'),
(4,'GROCERIES','Reliance Fresh');

INSERT INTO `address` VALUES 
(1,'Noida','India',28.6080857, 77.3643119,'UP','Sec 62',1), -- 28.6080857,77.3643119
(2,'Noida','India',28.5902338,77.3535046,'UP','Sec 23',1), -- 28.5902338,77.3535046
(3,'Noida','India',28.6087152,77.3722648,'UP','Sec 59',1),-- 28.6087152,77.3722648
(4,'NNoida','India',28.567659,77.3240437,'UP','Sec 18',2), -- 28.567659,77.3240437
(5,'Delhi','India',28.6289332,77.2065322,'Delhi','Delhi',2),-- 28.6289332,77.2065322
(6,'Delhi','India',28.6289222,77.2065322,'Delhi','Delhi',3), -- 28.6289222,77.2065322
(7,'Gudgaon','India',28.4591916,77.070357,'Haryana','Huda City Center',4); -- 28.4591916,77.070357

INSERT INTO `business`.`user` (`userId`, `firstName`, `lastName`, `pass`) VALUES ('navjagat@gmail.com', 'Navneet', 'Prabhakar', '$2a$06$D.TCwqfnjR0K.kbEcHQPUOZVwnwviZSzeB2olZG7QVlxuwSUjeGjC');


