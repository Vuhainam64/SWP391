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

GO

-- Create USER_INFO table
RAISERROR('Creating Table USER_INFO....',0,1)
create table USER_INFO(
	userId varchar(50) primary key,
	userName varchar(50),
	userPassword varchar(50),
	email varchar(50),
	phone int,
	userAddress varchar(50),
	dateOfBirth date
);
GO

-- Create ACCOUNT table
RAISERROR('Creating Table ACCOUNT....',0,1)
create table ACCOUNT(
	accountId varchar(50) primary key,
	userName varchar(50),
	accountPassword varchar(50),
	email varchar(50),
	accountRole varchar(50)
);
GO

-- Create USER_ORDER table
RAISERROR('Creating Table USER_ORDER....',0,1)
create table USER_ORDER(
	orderId varchar(50) primary key,
	userID varchar(50),
	dateOrder date,
	cost int,
	orderStatus bit
);
GO

-- Create FEEDBACK table
RAISERROR('Creating Table FEEDBACK....',0,1)
create table FEEDBACK(
	feedbackId varchar(50) primary key,
	userID varchar(50),
	productID varchar(50),
	feedbackDate date,
	rating int,
	comment varchar(50)
);
GO

-- Create ORDERITEM table
RAISERROR('Creating Table ORDERITEM....',0,1)
create table ORDERITEM(
	itemID varchar(50) primary key,
	orderID varchar(50),
	productID varchar(50),
	quantity int
);
GO

-- Create PRODUCT table
RAISERROR('Creating Table PRODUCT....',0,1)
create table PRODUCT(
	productID varchar(50) primary key,
	productName varchar(50),
	productDescription varchar(50),
	productPrice int,
	quantity int,
	isCoupon bit
);
GO

-- Create COUPON table
RAISERROR('Creating Table COUPON....',0,1)
create table COUPON(
	couponID varchar(50) primary key,
	productID varchar(50),
	dateExpire date,
	dateCreate date
);
GO

-- Create alter table table
RAISERROR('Creating alter table....',0,1)
alter table USER_ORDER add constraint FK_ORDER foreign key(userID) references USER_INFO(userID);
alter table FEEDBACK add constraint FK_FEEDBACKUSER foreign key(userID) references USER_INFO(userID);
alter table ORDERITEM add constraint FK_ITEM foreign key(orderID) references USER_ORDER(orderID);
alter table ORDERITEM add constraint FK_PRODUCT foreign key(productID) references PRODUCT(productID);
alter table ACCOUNT add constraint FK_ACCOUNT foreign key(accountID) references USER_INFO(userID);
alter table FEEDBACK add constraint FK_FEEDBACKPRODUCT foreign key(productID) references PRODUCT(productID);
alter table COUPON add constraint FK_COUPON foreign key(productID) references PRODUCT(productID);
