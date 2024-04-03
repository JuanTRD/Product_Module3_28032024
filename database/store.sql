create database ProjectModule3;
use ProjectModule3;
create table Product(
                        ID int not null primary key auto_increment,
                        NAME varchar(30) not null,
                        PRICE double not null,
                        QUANTITY int not null,
                        IMAGE varchar(50) not null,
                        IDCATEGORY int,
                        foreign key (IDCATEGORY) references Category(ID)
);
create table Category(
                         ID int not null primary key auto_increment,
                         NAME varchar(60) not null
);

create table Customer(
                         ID int not null primary key auto_increment,
                         NAME varchar(20) not null,
                         AGE int not null
);
create table ORDERS(
                       ID int not null primary key auto_increment,
                       TIME varchar(20) not null,
                       TOTAL double not null,
                       IDCustomer int,
                       foreign key(IDCustomer)references Customer(ID)
);
create table ORDERDETAILS(
                             id int not null primary key,
                             IdOrder int not null,
                             foreign key(IdOrder)references ORDERS(ID),
                             IdProduct int not null,
                             foreign key(IdProduct)references Product(ID),
                             QUANTITY int not null
);
CREATE table USER(
                     ID int not null auto_increment primary key,
                     USERNAME varchar(255) not null,
                     PASSWORD varchar(255) not null,
                     IDRole int,
                     foreign key (IDRole) references Role(ID)
);
Create table ROLE(
                     ID int not null primary key,
                     NAME varchar(10) not null
);
alter table USER add column username varchar(255) not null;
alter table user add column password varchar(255) not null;

select * from user;
insert into user (username, password, IDRole) values (?,?,?);

select * from product;
insert into product(name, price , quantity, image) values (?,?,?,?);

select * from product where id=?;
UPDATE product
SET name = ?, price = ?, quantity=?, image =?
WHERE id=?;
DELETE FROM product WHERE id = ?;
