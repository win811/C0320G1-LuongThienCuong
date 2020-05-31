SELECT * FROM shoppee.products;
set sql_safe_updates = 0;
update products set price = price*1.1 where price <=1000;
update products set discount = discount + 5 where discount <=10;
select * from products where discount <= 10;
select * from products where stock <= 5;
select * from products where price*(1 - discount/100) <= 1000;
select * from customers where address = "Đà Nẵng";
alter table customers add column birthday date after name;
select * from customers where year(birthday) = 1990;
select * from customers where day(birthday) = day(now()) and month(birthday) = month(now());
select * from orders where status = "done";
alter table orders add column date_order date;
select * from orders where date_order = curdate() and status = "done"; 
select * from orders where status = "canceled"; 
select * from orders where status = "canceled" and date_order = curdate(); 
alter table orders add column address_receiver text;
select * from employee where day(birthday) = day(now()) and month(birthday) = month(now());
select * from suppliers where name in ('Yamaha', 'SAMSUNG', 'Nestle', 'APPLE');

#D - TRUY VẤN DỮ LIỆU: INNER JOIN, VIEW, STORED PROCEDURE
#1
select products.*, categories.name as categories from categories join products on products.category_id = categories.category_id; 
#2
select orders.*, customers.name,birthday,address,phone,address,email from orders join customers on orders.customer_id = customers.id; 
alter table products change imangeurl imageURL text;
#3
select products.product_id,products.name,price,imageURL,discount,stock ,categories.category_id,categories.name, 
suppliers.supplier_id ,suppliers.name ,suppliers.phone,suppliers.address 
from  products
join categories using (category_id)
join suppliers using (supplier_id);
#4a
select p.category_id, c.name  , count(*) as "Amount" 
from categories as c 
join products as p using (category_id) group by p.category_id;
#5a
select suppliers.* , count(*) as "Amount Supply" 
from suppliers join products on suppliers.id = products.supplier_id group by products.supplier_id; 
alter table orders modify date_order datetime check (date_order <= date_ship);
alter table orders modify date_ship datetime check (date_ship >= date_order) after date_order;
alter table categories rename column id to category_id;
alter table products rename column catogory_id to category_id;
alter table products rename column products_id to product_id;
alter table orders rename column orders_id to order_id;
alter table suppliers rename column id to supplier_id;
alter table customers rename column id to customer_id;
alter table employee rename column id to employee_id;
alter table orderdetail rename column quantify to quantity;
#6
select products.product_id, products.name, orders.order_id, orders.date_ship   
from products 
join orderdetail using(product_id)
join orders using(order_id)
where orders.date_ship between "2020-1-1" and "2020-5-15";
#7
select customers.* , orders.date_ship  
from customers 
join orders using(customer_id) 
where orders.date_ship between "2020-1-1" and "2020-5-15" order by orders.date_ship;
#8
select customers.customer_id, customers.name, sum(products.price * orderdetail.quantify) as "Tổng Tiền", orders.date_ship 
from customers
join orders using(customer_id)
join orderdetail using(order_id)
join products using(product_id)
where orders.date_ship between "2020-1-1" and "2020-6-1"
group by customers.name 
order by orders.date_ship;
#9
select orders.order_id , orders.status ,sum(products.price * orderdetail.quantify) as "Tổng tiền" 
from orders 
join orderdetail using(order_id)
join products using(product_id)
group by orders.order_id;

#10
select employees.employee_id, employees.name ,sum(products.price * orderdetail.quantify) as "Tổng tiền" 
from employees 
join orders using(employee_id)
join orderdetail using(order_id)
join products using(product_id)
group by employees.employee_id;

#11
SELECT 
    products.product_id, products.name, orderdetail.quantity
FROM
    products
        LEFT JOIN
    orderdetail USING (product_id)
WHERE
    orderdetail.quantity IS NULL;

#12
select suppliers.name
from suppliers
where supplier_id not in
(
	select distinct supplier_id
	from products
	join orderdetail using(product_id)
	join orders using(order_id)
	where orders.date_order between '2020-1-1' and '2020-1-3')
;
#13
select employees.employee_id,employees.name ,sum((products.price * products.discount)*orderdetail.quantity) as `Doanh Số`
from products
join orderdetail using(product_id)
join orders using(order_id)
join employees using(employee_id)
where orders.date_order between "2020-1-1" and "2020-2-20"
group by employees.employee_id
order by `Doanh Số` desc
limit 3;

#14
select customers.customer_id,customers.name ,sum((products.price * products.discount)*orderdetail.quantity) as `Đã Mua`
from products
join orderdetail using(product_id)
join orders using(order_id)
join customers using(customer_id)
where orders.date_order between "2020-1-1" and "2020-5-30"
group by customers.customer_id
order by `Đã Mua` desc
limit 5;

#15 
select distinct products.discount from products order by discount;

#16
select categories.* , sum((products.price * products.discount)*orderdetail.quantity) as `Doanh Số`
from categories 
left join products using (category_id)
left join orderdetail using(product_id)
group by categories.category_id
order by `Doanh Số` desc;

#17
select orders.order_id, orders.status, sum((products.price * products.discount)*orderdetail.quantity) as `Tổng Giá Tiền`
from orders 
join orderdetail using (order_id)
join products using(product_id)
where orders.status = "Done"
group by orders.order_id
order by `Tổng Giá Tiền`

 

