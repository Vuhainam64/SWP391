SET NOCOUNT ON
USE master
GO

IF EXISTS (SELECT * FROM sysdatabases WHERE name='PetStore')
BEGIN
  RAISERROR('Dropping existing PetStore database ....',0,1)
  DROP DATABASE PetStore
END
GO

CHECKPOINT
GO

RAISERROR('Creating PetStore database....',0,1)
GO
CREATE DATABASE PetStore
GO

CHECKPOINT
GO

USE PetStore
GO

-- Create PRODUCT table
RAISERROR('Creating Table PRODUCT....',0,1)
create table PRODUCT(
	productId int identity primary key,
	productName nvarchar(50) not null,
	category nvarchar(50) not null,
	tags nvarchar(50),
	productDescription nvarchar(MAX),
	productPrice decimal(10,2) not null,
	quantity int not null,
	isCoupon bit not null,
	imageMain nvarchar(100) not null,
	imageSub1 nvarchar(100),
	imageSub2 nvarchar(100),
	imageSub3 nvarchar(100),
	imageSub4 nvarchar(100),
	created_at datetime default current_timestamp,
	updated_at datetime default current_timestamp
);

-- Create USER_INFO table
RAISERROR('Creating Table USER_INFO....',0,1)
create table USER_INFO(
	userId int identity primary key,
	userName nvarchar(50) not null,
	userPassword nvarchar(50) not null,
	email nvarchar(50),
	phone nvarchar(50),
	userAddress nvarchar(50),
	dateOfBirth date,
	created_at datetime default current_timestamp,
	updated_at datetime default current_timestamp
);

-- Create ACCOUNT table
RAISERROR('Creating Table ACCOUNT....',0,1)
create table ACCOUNT(
	accountId int identity primary key,
	userName nvarchar(50) not null,
	accountPassword nvarchar(50) not null,
	email nvarchar(50),
	accountRole nvarchar(50),
    userId int not null,
	created_at datetime default current_timestamp,
	updated_at datetime default current_timestamp,
    foreign key (userId) references USER_INFO(userId)
);


-- Create USER_ORDER table
RAISERROR('Creating Table USER_ORDER....',0,1)
create table USER_ORDER(
	orderId int identity primary key,
	userID int not null,
	dateOrder datetime not null,
	cost decimal(10,2) not null,
	orderStatus bit not null,
	created_at datetime default current_timestamp,
	updated_at datetime default current_timestamp
);
alter table USER_ORDER add constraint FK_USERORDER foreign key(userID) references USER_INFO(userId);

-- Create FEEDBACK table
RAISERROR('Creating Table FEEDBACK....',0,1)
create table FEEDBACK(
	feedbackId int identity primary key,
	userID int not null,
	productID int not null,
	feedbackDate datetime,
	rating int,
	comment nvarchar(MAX),
	created_at datetime default current_timestamp,
	updated_at datetime default current_timestamp
);
alter table FEEDBACK add constraint FK_FEEDBACKUSER foreign key(userID) references USER_INFO(userId);
alter table FEEDBACK add constraint FK_FEEDBACKPRODUCT foreign key(productID) references PRODUCT(productId);

-- Create ORDERITEM table
RAISERROR('Creating Table ORDERITEM....',0,1)
create table ORDERITEM(
	itemID int identity primary key,
	orderID int not null,
	productID int not null,
	quantity int not null,
	created_at datetime default current_timestamp,
	updated_at datetime default current_timestamp
);
alter table ORDERITEM add constraint FK_ITEM foreign key(orderID) references USER_ORDER(orderId);
alter table ORDERITEM add constraint FK_PRODUCT foreign key(productID) references PRODUCT(productId);

-- Create COUPON table
RAISERROR('Creating Table COUPON....',0,1)
create table COUPON(
	couponId int identity primary key,
	productID int not null,
	dateExpire date,
	dateCreate date default current_timestamp,
	percentOff decimal(5,2) not null,
	created_at datetime default current_timestamp,
	updated_at datetime default current_timestamp,
	foreign key (productID) references PRODUCT(productId)
);

alter table COUPON add constraint FK_COUPON foreign key(productID) references PRODUCT(productId);

INSERT INTO PRODUCT (productName, category, tags, productDescription, productPrice, quantity, isCoupon, imageMain)
VALUES 
('Sunflower Seeds', 'Seed', 'sunflower, seed', 'High-quality sunflower seeds for birds', 6.99, 50, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/648327c422fd1.png'),
('Safflower Seeds', 'Seed', 'safflower, seed', 'Premium safflower seeds for birds', 8.99, 30, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/648327e39e43d.png'),
('Nyjer Seeds', 'Seed', 'nyjer, seed', 'Nutritious Nyjer seeds for birds', 12.99, 25, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/64832805ea2ce.png'),
('Peanuts', 'Wet Food', 'peanuts, wet food', 'Roasted peanuts in a savory broth for birds', 5.99, 80, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/6483281f3b996.png'),
('Fruit Blend', 'Dry Food', 'fruit blend, dry food', 'A delicious fruit blend for birds with natural ingredients', 9.99, 45, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/6483283bb6b88.png'),
('Insect Delight', 'Wet Food', 'insects, wet food', 'A protein-rich mix of insects and seeds for birds', 4.99, 60, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/6483286215b4a.png'),
('Honey Nut Mix', 'Dry Food', 'honey, nut mix', 'A sweet and nutty blend for birds with honey-coated pieces', 7.99, 35, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/6483288616b14.png'),
('Mealworms', 'Live Food', 'mealworms, live food', 'Live mealworms for birds to satisfy their protein requirements', 9.99, 25, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/6483289e45aed.png'),
('Suet Cakes', 'Wet Food', 'suet, cake', 'A nutritious suet cake for birds to provide them with energy and warmth', 2.99, 75, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/648328c114c1b.png'),
('Corn Kernels', 'Dry Food', 'corn kernels, dry food', 'Dried corn kernels for birds to serve as a healthy snack', 3.99, 100, 0, 'https://files.fullstack.edu.vn/f8-prod/public-images/648328db61d3c.png');

-- Inserting example data into USER_INFO table
RAISERROR('Inserting Example Data into USER_INFO Table....',0,1)
insert into USER_INFO (userName, userPassword, email, phone, userAddress, dateOfBirth)
values ('johndoe', 'password123', 'johndoe@example.com', '555-555-5555', '123 Main St', '1980-01-01'),
('janedoe', 'password456', 'janedoe@example.com', '555-555-5556', '456 Oak St', '1990-05-15'),
('bobsmith', 'password789', 'bobsmith@example.com', '555-555-5557', '789 Pine St', '1975-08-20')

-- Inserting example data into ACCOUNT table
RAISERROR('Inserting Example Data into ACCOUNT Table....',0,1)
insert into ACCOUNT (userName, accountPassword, email, accountRole, userId)
values ('johndoe', 'password123', 'johndoe@example.com', 'customer', 1),
('janedoe', 'password456', 'janedoe@example.com', 'customer', 2),
('admin', 'admin123', 'admin@example.com', 'admin', 3)

-- Inserting example data into USER_ORDER table
RAISERROR('Inserting Example Data into USER_ORDER Table....',0,1)
insert into USER_ORDER (userID, dateOrder, cost, orderStatus)
values (1, '2023-05-23 12:30:00', 25.99, 1),
(2, '2023-05-22 09:45:00', 18.99, 1),
(3, '2023-05-21 17:15:00', 40.50, 0)

-- Inserting example data into FEEDBACK table
RAISERROR('Inserting Example Data into FEEDBACK Table....',0,1)
insert into FEEDBACK (userID, productID, feedbackDate, rating, comment)
values (1, 1, '2023-05-23 14:00:00', 4, 'My cat loves this food!'),
(2, 2, '2023-05-22 10:00:00', 5, 'My dog can''t get enough of this food!'),
(3, 1, '2023-05-21 18:00:00', 3, 'This cat food is good, but my cat prefers another brand.')

-- Inserting example data into ORDERITEM table
RAISERROR('Inserting Example Data into ORDERITEM Table....',0,1)
insert into ORDERITEM (orderID, productID, quantity)
values (1, 1, 2),
(2, 2, 1),
(3, 1, 3)