drop database if exists furama;
create database furama;
use furama;

create table positions (
postion_id int auto_increment primary key,
position_name enum('Lễ Tân', 'Phục Vụ', 'Chuyên Viên', 'Giám Sát', 'Quản Lý', 'Giám Đốc')
);
insert into positions values (1, 'Lễ Tân'), (2, 'Phục Vụ'), (3, 'Chuyên Viên'), (4, 'Giám Sát'), (5, 'Quản Lý'), (6, 'Giám Đốc');
create table eduBackgrounds (
edu_bg_id int auto_increment primary key,
edu_degree enum('Trung Cấp', 'Đại Học', 'Cao Đẳng', 'Sau Đại Học')
);
insert into eduBackgrounds values (1, 'Trung Cấp'), (2, 'Cao Đẳng'), (3, 'Đại Học'), (4, 'Sau Đại Học');
create table divisions (
division_id int auto_increment primary key,
division_name enum('Sale-marketing', 'Hành Chính', 'Phục vụ', 'Quản Lý')
);
insert into divisions values (1, 'Sale-marketing'), (2, 'Hành Chính'), (3, 'Phục vụ'), (4, 'Quản Lý');

create table employees (
employee_id int auto_increment primary key,
employee_name nvarchar(45) not null,
employee_birthday date not null,
employee_idcard nvarchar(45) not null,
employee_salary nvarchar(45) not null,
employee_phone nvarchar(45) not null,
employee_email nvarchar(45),
employee_address nvarchar(45),
position_id int not null,
edu_bg_id int not null,
division_id int not null,
foreign key (position_id) references positions(postion_id),
foreign key (edu_bg_id) references eduBackgrounds(edu_bg_id),
foreign key (division_id) references divisions(division_id)
);

insert into employees values (1, 'Margalo', '1982-08-29', '337-201-659', '2500', '8216852520', 'Margalo@yahoo.com', 'Quảng Trị', 5, 1, 2);
insert into employees values (2, 'Wells', '1990-06-07', '776-176-401', '1200', '2163152417', 'Wells@yahoo.com', 'Quảng Trị', 1, 1, 3);
insert into employees values (3, 'Libbie', '1984-09-25', '075-092-098', '1200', '2983300613', 'Libbie@facebook.com', 'Huế', 5, 3, 4);
insert into employees values (4, 'Merla', '1979-04-26', '267-895-910', '1200', '4680526140', 'Merla@yahoo.com', 'Quảng Bình', 3, 3, 4);
insert into employees values (5, 'Everard', '1980-05-30', '509-784-356', '1200', '1049308370', 'Everard@facebook.com', 'Quảng Nam', 5, 3, 3);
insert into employees values (6, 'Barbette', '1972-03-10', '785-906-613', '400', '9143938663', 'Barbette@gmail.com', 'Sài Gòn', 5, 3, 4);
insert into employees values (7, 'Tori', '1991-06-09', '578-152-094', '1200', '2682913418', 'Tori@gmail.com', 'Sài Gòn', 2, 1, 2);
insert into employees values (8, 'Angie', '1982-11-10', '309-677-185', '2000', '3574363341', 'Angie@facebook.com', 'Quảng Nam', 2, 1, 3);
insert into employees values (9, 'Almire', '1987-01-03', '676-621-239', '400', '9875037494', 'Almire@facebook.com', 'Quảng Trị', 4, 2, 4);
insert into employees values (10, 'Lion', '1984-09-19', '218-461-559', '1200', '2124703839', 'Lion@facebook.com', 'Quảng Trị', 1, 3, 1);
insert into employees values (11, 'Barty', '1986-01-12', '296-385-742', '400', '8944142139', 'Barty@yahoo.com', 'Quảng Bình', 3, 2, 3);
insert into employees values (12, 'Lindon', '1975-01-20', '491-953-059', '2500', '2507081348', 'Lindon@yahoo.com', 'Quảng Bình', 1, 3, 3);
insert into employees values (13, 'Theresita', '1974-02-28', '462-592-452', '1200', '3498856146', 'Theresita@facebook.com', 'Đà Nẵng', 4, 4, 3);
insert into employees values (14, 'Persis', '1997-03-25', '291-543-720', '1200', '6577700115', 'Persis@yahoo.com', 'Sài Gòn', 5, 3, 4);
insert into employees values (15, 'Zitella', '1972-11-09', '239-064-036', '1200', '6491368164', 'Zitella@facebook.com', 'Đà Nẵng', 3, 3, 3);
insert into employees values (16, 'Hanny', '1983-12-16', '997-896-341', '1200', '5127073194', 'Hanny@yahoo.com', 'Sài Gòn', 1, 1, 4);
insert into employees values (17, 'Libby', '2000-09-21', '451-865-562', '400', '1917111389', 'Libby@yahoo.com', 'Quảng Bình', 5, 3, 4);
insert into employees values (18, 'Lezley', '1997-01-07', '187-178-345', '1200', '3447169372', 'Lezley@yahoo.com', 'Huế', 2, 1, 2);
insert into employees values (19, 'Ase', '1992-05-10', '233-906-204', '400', '2089284381', 'Ase@facebook.com', 'Sài Gòn', 4, 4, 1);
insert into employees values (20, 'Jeffry', '1997-01-29', '492-519-500', '1200', '9529551056', 'Jeffry@yahoo.com', 'Quảng Nam', 5, 2, 2);
insert into employees values (21, 'Duy', '1996-04-15', '312-277-832', '5000', '9529551056', 'nguyenduy@yahoo.com', 'Sài Gòn', 6, 4, 4);

create table customerTypes (
customer_type_id int auto_increment primary key,
customer_type_name enum('Diamond', 'Platinium', 'Gold', 'Silver', 'Member')
);

insert into customerTypes values (1, 'Diamond'), (2, 'Platinium'), (3, 'Gold'), (4, 'Silver'), (5, 'Member');

create table customers (
customer_id int auto_increment primary key,
customer_type_id int not null,
foreign key(customer_type_id) references customerTypes(customer_type_id),
customer_name nvarchar(45) not null,
customer_birthday date not null,
customer_idcard nvarchar(45) not null,
customer_phone nvarchar(45) not null,
customer_email nvarchar(45),
customer_address nvarchar(45)
);

insert into customers values (1, 5, 'Ulysses', '1979-09-17', '123-456-987', '5576786287', 'Ulysses@gmail.com.vn', 'Vinh');
insert into customers values (2, 2, 'Lemuel', '1972-01-27', '333-444-333', '8153115769', 'Lemuel@gmail.com.vn', 'Đà Nẵng');
insert into customers values (3, 4, 'Alwyn', '1997-12-10', '888-666-444', '0009725571', 'Alwyn@fb.com.vn', 'Đà Nẵng');
insert into customers values (4, 1, 'Kathrine', '1974-11-18', '123-555-757', '0286460721', 'Kathrine@fb.com.vn', 'Vinh');
insert into customers values (5, 3, 'Hasty', '1996-10-08', '356-756-888', '0121392590', 'Hasty@codegym.com.vn', 'Đà Nẵng');
insert into customers values (6, 2, 'Sigismundo', '1988-02-17', '111-888-123', '2089432337', 'Sigismundo@codegym.com.vn', 'Quảng Ngãi');
insert into customers values (7, 1, 'Shannon', '1970-04-30', '222-777-123', '1304598628', 'Shannon@codegym.com.vn', 'Quảng Nam');
insert into customers values (8, 5, 'Anica', '1995-01-27', '666-666-123', '8624729054', 'Anica@fb.com.vn', 'Quảng Ngãi');
insert into customers values (9, 2, 'Rita', '1994-12-02', '777-555-123', '0035377505', 'Rita@gmail.com.vn', 'Quảng Bình');
insert into customers values (10, 5, 'Florence', '1982-09-26', '888-455-111', '5842276839', 'Florence@gmail.com.vn', 'Vinh');
insert into customers values (11, 1, 'Van', '1992-01-23', '234-111-167', '9272198917', 'Van@fb.com.vn', 'Quảng Trị');
insert into customers values (12, 1, 'Martelle', '1991-01-28', '345-111-767', '0713312304', 'Martelle@codegym.com.vn', 'Quảng Ngãi');
insert into customers values (13, 4, 'Laurie', '1971-02-19', '456-222-634', '6495947446', 'Laurie@codegym.com.vn', 'Vinh');
insert into customers values (14, 5, 'Pearla', '1975-03-09', '567-222-452', '1223517090', 'Pearla@codegym.com.vn', 'Quảng Trị');
insert into customers values (15, 3, 'Christy', '1986-03-05', '678-333-521', '9156344226', 'Christy@codegym.com.vn', 'Quảng Nam');
insert into customers values (16, 5, 'Sterne', '1980-06-15', '098-456-111', '2923972935', 'Sterne@gmail.com.vn', 'Đà Nẵng');
insert into customers values (17, 1, 'Markos', '2000-08-12', '000-456-657', '8774327558', 'Markos@fb.com.vn', 'Quảng Ngãi');
insert into customers values (18, 4, 'Etta', '1992-04-29', '120-362-946', '3594759386', 'Etta@codegym.com.vn', 'Quảng Nam');
insert into customers values (19, 4, 'Mag', '1990-01-04', '140-625-783', '7638896098', 'Mag@gmail.com.vn', 'Vinh');
insert into customers values (20, 4, 'Cam', '1971-06-04', '340-652-853', '6978254789', 'Cam@fb.com.vn', 'Quảng Ngãi');
insert into customers values (21, 3, 'Queenie', '1970-02-14', '740-345-673', '5825912773', 'Queenie@codegym.com.vn', 'Quảng Ngãi');
insert into customers values (22, 5, 'Carena', '1997-08-13', '970-783-682', '2912678636', 'Carena@fb.com.vn', 'Vinh');
insert into customers values (23, 2, 'Betty', '1970-11-24', '988-456-112', '4966468821', 'Betty@gmail.com.vn', 'Đà Nẵng');
insert into customers values (24, 5, 'Karoly', '1974-12-10', '250-222-346', '1066860689', 'Karoly@codegym.com.vn', 'Quảng Ngãi');
insert into customers values (25, 5, 'Marsh', '1986-03-02', '290-111-068', '2400293966', 'Marsh@fb.com.vn', 'Huế');
insert into customers values (26, 5, 'Clarinda', '1974-04-28', '100-095-000', '8076709705', 'Clarinda@gmail.com.vn', 'Quảng Nam');
insert into customers values (27, 2, 'Paulie', '1977-09-14', '900-648-008', '9525119915', 'Paulie@fb.com.vn', 'Quảng Trị');
insert into customers values (28, 5, 'Doralia', '1976-04-03', '950-735-088', '9239912774', 'Doralia@fb.com.vn', 'Vinh');
insert into customers values (29, 1, 'Sybil', '1988-10-07', '450-726-976', '8400714804', 'Sybil@gmail.com.vn', 'Quảng Bình');
insert into customers values (30, 5, 'Raleigh', '1993-03-29', '330-562-456', '1785140910', 'Raleigh@fb.com.vn', 'Huế');
insert into customers values (31, 1, 'Sybil', '1990-09-17', '423-726-999', '4562794678', 'Sybil1990@gmail.com.vn', 'Quảng Ngãi');
insert into customers values (32, 3, 'Raleigh', '1980-07-29', '330-762-006', '0987234516', 'Raleigh1980@fb.com.vn', 'Đà Nẵng');



create table rentTypes (
rent_type_id int auto_increment primary key,
rent_type_name enum('year', 'month', 'day', 'hour'),
rent_type_price int
);
insert into rentTypes values (1, 'year', 399000), (2, 'month', 29000), (3, 'day', 1000), (4, 'hour', 50);

create table serviceTypes (
service_type_id int auto_increment primary key,
service_type_name enum('Villa', 'House', 'Room')
);

insert into serviceTypes values (1, 'Villa'), (2, 'House'), (3, 'Room');

create table services (
service_id int auto_increment primary key,
service_name varchar(45) not null,
service_area int,
check(service_area > 30),
service_floor int,
check(service_floor > 0),
service_max_people int,
check(service_max_people between 1 and 20),
rent_type_id int not null,
service_type_id int not null,
service_status enum ('available', 'unavailable') default 'available',
foreign key (rent_type_id) references rentTypes(rent_type_id),
foreign key (service_type_id) references serviceTypes(service_type_id)
);

insert into services values (1, 'Room11', 81, 4, 9, 4, 3, 'available');
insert into services values (2, 'Villa06', 72, 2, 14, 4, 1, 'available');
insert into services values (3, 'Room98', 74, 1, 8, 1, 3, 'available');
insert into services values (4, 'Room12', 84, 3, 19, 2, 3, 'unavailable');
insert into services values (5, 'Villa57', 50, 4, 8, 3, 1, 'available');
insert into services values (6, 'House87', 81, 3, 4, 2, 2, 'unavailable');
insert into services values (7, 'Villa07', 49, 1, 11, 1, 1, 'unavailable');
insert into services values (8, 'House49', 57, 4, 19, 4, 2, 'available');
insert into services values (9, 'Room68', 93, 1, 9, 1, 3, 'available');
insert into services values (10, 'Villa24', 51, 2, 3, 2, 1, 'unavailable');
insert into services values (11, 'Villa52', 41, 3, 6, 2, 1, 'available');
insert into services values (12, 'Room84', 87, 2, 8, 3, 3, 'available');
insert into services values (13, 'Room57', 89, 3, 5, 3, 3, 'available');
insert into services values (14, 'Villa99', 80, 2, 9, 4, 1, 'unavailable');
insert into services values (15, 'Room23', 77, 1, 11, 3, 3, 'unavailable');
insert into services values (16, 'Villa27', 71, 1, 12, 2, 1, 'available');
insert into services values (17, 'House17', 58, 4, 19, 1, 2, 'unavailable');
insert into services values (18, 'Villa63', 85, 2, 9, 4, 1, 'available');
insert into services values (19, 'Room09', 56, 2, 17, 4, 3, 'available');
insert into services values (20, 'House50', 62, 2, 11, 1, 2, 'available');



create table attachServices (
attach_service_id int auto_increment primary key,
attach_service_name nvarchar(45) not null,
attach_service_price int not null,
attach_service_unit int not null,
attach_service_status nvarchar(45)
);
insert into attachServices values (1, 'No service', 0, 0,'unavailable');
insert into attachServices values (2, 'Karaoke01', 100, 0,'unavailable');
insert into attachServices values (3, 'Karaoke02', 150, 0,'available');
insert into attachServices values (4, 'Massage01', 200, 0,'available');
insert into attachServices values (5, 'Massage02', 250, 0,'unavailable');
insert into attachServices values (6, 'Massage03', 299, 0,'available');
insert into attachServices values (7, 'Car01', 50, 0,'available');
insert into attachServices values (8, 'Car02', 100, 0,'available');
insert into attachServices values (9, 'Car03', 150, 0,'unavailable');
insert into attachServices values (10, 'Car04', 200, 0,'unavailable');


create table contracts (
contract_id int auto_increment primary key,
contract_start_date date not null,
contract_end_date date not null,
contract_deposit int not null,
contract_price int not null,
employee_id int not null,
customer_id int not null,
service_id int not null,
foreign key (employee_id) references employees(employee_id),
foreign key (customer_id) references customers(customer_id),
foreign key (service_id) references services(service_id)
);

insert into contracts values (1, '2018-06-01', '2019-06-01', 100000, 399000, 19, 21, 20);
insert into contracts values (2, '2018-12-01', '2018-12-4', 500, 4000, 1, 30, 13);
insert into contracts values (3, '2018-09-10', '2018-09-12', 800, 2000, 12, 14, 15);
insert into contracts values (4, '2018-02-01', '2018-03-01', 29000, 87000, 18, 27, 2);
insert into contracts values (5, '2019-10-01', '2019-10-04', 2000, 4000, 8, 25, 12);
insert into contracts values (6, '2019-08-10', '2019-08-15', 3000, 5000, 8, 5, 13);
insert into contracts values (7, '2019-08-10', '2019-08-20', 2000, 10000, 11, 16, 5);
insert into contracts values (8, '2019-06-10', '2019-06-15', 1000, 5000, 15, 10, 15);
insert into contracts values (9, '2019-06-01', '2019-06-07', 2000, 7000, 11, 11, 5);
insert into contracts values (10, '2019-01-01', '2019-01-01', 29000, 58000, 1, 2, 6);
insert into contracts values (11, '2019-02-01', '2019-03-01', 29000, 87000, 15, 4, 2);
insert into contracts values (12, '2019-03-01', '2019-03-15', 2000, 15000, 11, 29, 5);
insert into contracts values (13, '2020-05-01', '2020-07-01', 29000, 58000, 1, 2, 6);
insert into contracts values (14, '2020-06-01', '2020-09-01', 29000, 87000, 2, 4, 10);
insert into contracts values (15, '2020-06-07', '2020-07-08', 200, 1200, 3, 7, 14);
insert into contracts values (16, '2020-06-09', '2020-06-10', 500, 1200, 4, 18, 4);
insert into contracts values (17, '2020-05-01', '2021-05-01', 100000, 399000, 5, 1, 7);
insert into contracts values (18, '2020-06-10', '2020-06-12', 500, 2000, 6, 15, 15);
insert into contracts values (19, '2020-01-01', '2021-01-01', 50000, 399000, 7, 20, 17);



create table contractDetails (
contract_detail_id int auto_increment primary key,
contract_id int not null,
attach_service_id int not null,
quantity int not null,
foreign key (contract_id) references contracts(contract_id),
foreign key (attach_service_id) references attachServices(attach_service_id)
);

insert into contractDetails values (1, 1, 10, 1);
insert into contractDetails values (2, 2, 4, 2);
insert into contractDetails values (3, 3, 5, 4);
insert into contractDetails values (4, 4, 2, 1);
insert into contractDetails values (5, 5, 8, 2);
insert into contractDetails values (6, 6, 1, 1);
insert into contractDetails values (7, 7, 1, 1);
insert into contractDetails values (8, 8, 4, 1);
insert into contractDetails values (9, 9, 1, 1);
insert into contractDetails values (10, 10, 8, 2);
insert into contractDetails values (11, 11, 1, 1);
insert into contractDetails values (12, 12, 9, 2);


