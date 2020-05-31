# Câu 2----------------------------------------------------------------------------------------------------E
SELECT * FROM employees WHERE (employee_name LIKE 'H%' or employee_name LIKE 'T%' OR employee_name LIKE 'K%') AND length(employee_name) <= 15;

# Câu 3----------------------------------------------------------------------------------------------------E
SELECT * , TIMESTAMPDIFF(year, customer_birthday, curdate()) AS Age FROM customers
HAVING (Age BETWEEN 18 AND 50) AND (customer_address IN ("Đà Nẵng", "Quảng Trị"));

SELECT * , TIMESTAMPDIFF(year, customer_birthday, curdate()) AS Age FROM customers
HAVING (Age BETWEEN 18 AND 50) AND (customer_address IN ("Đà Nẵng", "Quảng Trị"));

# Câu 4----------------------------------------------------------------------------------------------------E
SELECT customer_id, customer_name, count(*) AS amount_of_order
	FROM customers
		JOIN contracts USING(customer_id)
	WHERE customer_type_id = 1
	GROUP BY customer_id
ORDER BY amount_of_order;

#Câu 5---------------------------------------------------------------------------------------------------- D
CREATE VIEW customerpercontract_VIEW AS
	SELECT customer_id, customer_name, customer_type_name,
	contract_id, service_name, contract_start_date, contract_end_date,
	( contract_price + sum(attach_service_price * quantity) ) AS total_pay
		FROM contracts
			JOIN customers USING(customer_id)
			JOIN customertypes USING(customer_type_id)
			JOIN services USING(service_id)
			JOIN contractdetails USING(contract_id)
			JOIN attachservices USING(attach_service_id)
		GROUP BY contract_id
	ORDER BY total_pay DESC
;

SELECT customer_id, customers.customer_name, customertypes.customer_type_name,
customerpercontract_VIEW.contract_id, customerpercontract_VIEW.service_name, 
customerpercontract_VIEW.contract_start_date, customerpercontract_VIEW.contract_end_date, customerpercontract_VIEW.total_pay
	FROM customers
		JOIN customertypes USING(customer_type_id)
		LEFT JOIN customerpercontract_VIEW USING (customer_id)
ORDER BY total_pay DESC;

#Câu 6---------------------------------------------------------------------------------------------------- E
SELECT service_id, service_name, service_area, service_price, service_type_name
FROM services
	JOIN servicetypes USING (service_type_id)
WHERE service_id NOT IN (	
	SELECT service_id 
	FROM contracts
	WHERE contract_start_date BETWEEN '2019-1-1' AND '2019-3-31'
);

#Câu 7---------------------------------------------------------------------------------------------------- D-UL
SELECT service_id, service_name, service_area, service_max_people, service_price, service_type_name
FROM contracts
	JOIN services USING (service_id)
	JOIN servicetypes USING (service_type_id)
WHERE YEAR(contract_start_date) = 2018 AND contracts.service_id NOT IN (
	SELECT service_id
	FROM contracts
	WHERE YEAR(contract_start_date) = 2019
);

#Câu 8---------------------------------------------------------------------------------------------------- 
SELECT DISTINCT customer_name
FROM customers;
SELECT customer_name
FROM customers
GROUP BY customer_name;
SELECT customer_name
FROM customers
UNION
SELECT customer_name
FROM customers;

#Câu 9---------------------------------------------------------------------------------------------------- M-L
CREATE VIEW revenue_on_contract_in2019_VIEW AS
    SELECT contract_id, MONTH(contract_start_date) AS month, YEAR(contract_start_date) AS year,
    (contract_price + SUM(attach_service_price * quantity)) AS total_pay
    FROM contracts
		JOIN contractdetails USING (contract_id)
		JOIN attachservices USING (attach_service_id)
    GROUP BY contract_id
    HAVING year = 2019
;

DROP TEMPORARY TABLE months_in_year2019;
CREATE TEMPORARY TABLE months_in_year2019 (
	month INT PRIMARY KEY,
    year INT NOT NULL DEFAULT 2019,
    CHECK (month <= 12),
    CHECK (year = 2019)
);
INSERT INTO months_in_year2019(month) values (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);
#SELECT * FROM months_in_year2019;
SELECT months_in_year2019.* , ifnull(temp.revenue_in_month,0) AS revenue , ifnull(temp.amount_contract,0) AS amount_contract
FROM months_in_year2019
	LEFT JOIN (
		SELECT month, year, SUM(total_pay) AS revenue_in_month, COUNT(*) AS amount_contract
		FROM revenue_on_contract_in2019_VIEW
		GROUP BY month
	) AS temp USING(month);

#Câu 10---------------------------------------------------------------------------------------------------- E
SELECT contract_id, contract_start_date, contract_end_date, contract_deposit, COUNT(*) AS amount_attach_service
FROM contractdetails
	JOIN contracts USING (contract_id)
GROUP BY contract_id;

#Câu 11---------------------------------------------------------------------------------------------------- E
SELECT attachservices.*, customer_type_name, customer_address
FROM contractdetails 
	JOIN attachservices USING (attach_service_id)
	JOIN contracts USING (contract_id)
	JOIN customers USING (customer_id)
	JOIN customertypes USING (customer_type_id)
WHERE customer_type_name = 'Diamond' AND customer_address IN ('Vinh' , 'Quảng Ngãi') AND attach_service_id <> 1;
        
#Câu 12---------------------------------------------------------------------------------------------------- E-L
SELECT contract_id,employee_name,customer_name,customer_phone,service_name, count(*) as amount_attach_service,contract_deposit
FROM contracts
	JOIN employees using(employee_id)
	JOIN customers using(customer_id)
	JOIN services using(service_id)
	JOIN contractdetails using(contract_id)
WHERE (contract_start_date BETWEEN '2019-10-1' AND '2019-12-31') AND service_id NOT IN (
	SELECT service_id
	FROM contracts
	WHERE contract_start_date BETWEEN '2019-1-1' AND '2019-6-30'
)
GROUP BY contract_id;

#Câu 13---------------------------------------------------------------------------------------------------- M
SELECT attachservices.*, count(*) AS amount_order
FROM contractdetails
	JOIN attachservices USING(attach_service_id)
GROUP BY attach_service_id 
HAVING amount_order IN (
	SELECT max(amount_order)
	FROM (
		SELECT attachservices.*, count(*) AS amount_order
		FROM contractdetails
			JOIN attachservices USING(attach_service_id)
		GROUP BY attach_service_id 
	) AS temp 
);

#Câu 14---------------------------------------------------------------------------------------------------- E
SELECT contract_id, service_type_name, attach_service_name, count(*) as amount
FROM contractdetails
	JOIN attachservices USING(attach_service_id)
    JOIN contracts USING(contract_id)
    JOIN services USING(service_id)
    JOIN servicetypes USING(service_type_id) 
GROUP BY attach_service_id
HAVING amount = 1 and attach_service_id <> 1;

#Câu 15---------------------------------------------------------------------------------------------------- E-L
SELECT employee_id,employee_name,edu_degree,position_name,employee_phone,employee_address, count(*) AS amount_contract
FROM contracts
	JOIN employees USING(employee_id)
	JOIN edubackgrounds USING(edu_bg_id)
	JOIN positions USING(position_id)
WHERE YEAR(contract_start_date) BETWEEN 2018 AND 2019
GROUP BY employee_id
HAVING amount_contract <= 3;

#Câu 16---------------------------------------------------------------------------------------------------- M
#SET sql_safe_updates = 0;
#ALTER TABLE contracts DROP FOREIGN KEY contracts_ibfk_1;
#DELETE FROM employees WHERE employee_id NOT IN (
	#SELECT employee_id
	#FROM contracts
	#WHERE YEAR(contract_start_date) BETWEEN 2017 AND 2020
#);
#ALTER TABLE contracts ADD FOREIGN KEY(employee_id) REFERENCES employees(employee_id);

#Câu 17---------------------------------------------------------------------------------------------------- M
UPDATE customers SET customer_type_id = 1 WHERE customer_id IN (
	SELECT customer_id 
    FROM (
		SELECT customer_id ,( contract_price + sum(attach_service_price * quantity) ) AS total_pay
		FROM contractdetails
			JOIN contracts USING(contract_id)
			JOIN customers USING(customer_id)
			JOIN attachservices USING(attach_service_id)
		WHERE customer_type_id = 2 AND YEAR(contract_start_date) = 2019
		GROUP BY customer_id
		HAVING total_pay > 500
	) AS temp
);

#Câu 18---------------------------------------------------------------------------------------------------- 

#Câu 19---------------------------------------------------------------------------------------------------- 
SET sql_safe_updates = 0;
UPDATE attachservices SET attach_service_price = (attach_service_price*2) WHERE attach_service_id IN (
	SELECT attach_service_id 
	FROM (
		SELECT attach_service_id, count(*) AS amount_order
		FROM contractdetails
			JOIN contracts USING (contract_id)
		WHERE YEAR(contract_start_date) = 2019
        GROUP BY attach_service_id
		HAVING amount_order > 10
	) AS temp
);

#Câu 20----------------------------------------------------------------------------------------------------
SELECT customer_id AS ID, customer_name AS NAME, customer_email AS EMAIL, 
customer_phone AS PHONE,customer_birthday AS BIRTHDAY,customer_address AS ADDRESS
FROM customers
UNION ALL
SELECT employee_id, employee_name, employee_email, employee_phone, employee_birthday, employee_address
FROM employees
