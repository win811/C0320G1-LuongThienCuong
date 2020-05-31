create table customers (
	customer_number int auto_increment primary key,
    fullname varchar (200),
    address varchar (200),
    email varchar (200),
    phone int
);
create table accounts (
	account_number int auto_increment primary key,
    customer_number int unique , foreign key (customer_number) references customers (customer_number),
	account_type varchar (200),
    date varchar (200),
    balance int
);
create table transactions (
	tran_number int auto_increment primary key,
    account_number int, foreign key (account_number) references accounts (account_number),
    date varchar (200),
    amounts int,
    descriptions varchar (200)
);

