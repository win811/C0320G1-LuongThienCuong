SELECT * FROM shoppee.categories;
select customers.customerNumber, customerName, phone, paymentDate, amount from customers
inner join payments
on customers.customerNumber = payments.customerNumber
where city = 'Las Vegas';
select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers
left join orders
on customers.customerNumber = orders.customerNumber where orderNumber is null;