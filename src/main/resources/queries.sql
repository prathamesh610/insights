CREATE DATABASE insights;
USE insights;

CREATE TABLE categories (
  id INT NOT NULL AUTO_INCREMENT,
   category_name VARCHAR(255) NULL,
   CONSTRAINT pk_categories PRIMARY KEY (id)
);



CREATE TABLE transactions (
  id INT NOT NULL AUTO_INCREMENT,
   transaction_date date NOT NULL,
   category_id INT NOT NULL,
   amount DOUBLE NULL,
   `description` VARCHAR(255) NULL,
   CONSTRAINT pk_transactions PRIMARY KEY (id),
   FOREIGN KEY (category_id) REFERENCES categories(id)
);



show tables;
select * from categories;
INSERT INTO categories VALUES(1, "Food");
INSERT INTO categories VALUES(2, "Games");
INSERT INTO categories VALUES(3, "Travel");
INSERT INTO categories VALUES(4, "Shopping");
INSERT INTO categories VALUES(5, "Fuel");

select * from transactions;
INSERT INTO transactions VALUES(1, "2024-04-12",1,100.0,"Lunch");
INSERT INTO transactions VALUES(2, "2024-04-12",1,50.5,"Breakfast");
INSERT INTO transactions VALUES(3, "2024-04-12",1,350.0,"Dinner");
INSERT INTO transactions VALUES(4, "2024-04-11",1,120.0,"Lunch");
INSERT INTO transactions VALUES(5, "2024-04-11",1,65.0,"Breakfast");
INSERT INTO transactions VALUES(6, "2024-04-11",1,700.0,"Dinner");
INSERT INTO transactions VALUES(7, "2024-04-12",2,50.0,"Valorant");
INSERT INTO transactions VALUES(8, "2024-04-12",2,100.0,"Cricket");
INSERT INTO transactions VALUES(9, "2024-04-12",2,150.0,"CS-2");
INSERT INTO transactions VALUES(10, "2024-04-11",2,5.0,"Valorant");
INSERT INTO transactions VALUES(11, "2024-04-11",2,100.0,"Cricket");
INSERT INTO transactions VALUES(12, "2024-04-12",3,10.0,"Bus");
INSERT INTO transactions VALUES(13, "2024-04-12",3,10.0,"Bus");
INSERT INTO transactions VALUES(14, "2024-04-12",3,200.0,"Taxi");
INSERT INTO transactions VALUES(15, "2024-04-11",3,50.0,"Bus");
INSERT INTO transactions VALUES(16, "2024-04-11",3,10.0,"Bus");
INSERT INTO transactions VALUES(17, "2024-04-12",4,1250.0,"T-shirt");
INSERT INTO transactions VALUES(18, "2024-04-12",4,2050.0,"Jenas");
INSERT INTO transactions VALUES(19, "2024-04-11",4,1549.0,"Shirts");
INSERT INTO transactions VALUES(20, "2024-04-11",4,4250.0,"Jacket");
INSERT INTO transactions VALUES(21, "2024-04-12",5,1000.0,"Fuel");
INSERT INTO transactions VALUES(22, "2024-04-11",5,1000.0,"Fuel");
INSERT INTO transactions VALUES(23, "2024-04-10",5,1000.0,"Fuel");