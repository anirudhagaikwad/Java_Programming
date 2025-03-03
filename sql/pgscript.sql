-- https://www.postgresql.org/docs/online-resources/
-- https://www.postgresql.org/docs/current/tutorial.html

-- Enter to psql
psql -U postgres

-- Create Database
CREATE DATABASE my_database;

-- List Databases
\l

SELECT datname FROM pg_database;

-- Connect to Database
\c my_database;

-- Create Table with Primary Key
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Create Table with Foreign Key
CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    amount DECIMAL(10,2) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Additional Table with Primary Key
CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

-- Create Additional Table with Foreign Key
CREATE TABLE order_items (
    item_id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(order_id),
    product_id INT REFERENCES products(product_id),
    quantity INT NOT NULL
);

-- Remove Foreign Keys
ALTER TABLE orders DROP CONSTRAINT orders_user_id_fkey;
ALTER TABLE order_items DROP CONSTRAINT order_items_order_id_fkey;
ALTER TABLE order_items DROP CONSTRAINT order_items_product_id_fkey;

-- Remove Primary Keys
ALTER TABLE users DROP CONSTRAINT users_pkey;
ALTER TABLE orders DROP CONSTRAINT orders_pkey;
ALTER TABLE products DROP CONSTRAINT products_pkey;
ALTER TABLE order_items DROP CONSTRAINT order_items_pkey;

-- Add Primary Keys Again
ALTER TABLE users ADD CONSTRAINT users_pkey PRIMARY KEY (id);
ALTER TABLE orders ADD CONSTRAINT orders_pkey PRIMARY KEY (order_id);
ALTER TABLE products ADD CONSTRAINT products_pkey PRIMARY KEY (product_id);
ALTER TABLE order_items ADD CONSTRAINT order_items_pkey PRIMARY KEY (item_id);

-- Add Foreign Keys Again
ALTER TABLE orders ADD CONSTRAINT orders_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE order_items ADD CONSTRAINT order_items_order_id_fkey FOREIGN KEY (order_id) REFERENCES orders(order_id);
ALTER TABLE order_items ADD CONSTRAINT order_items_product_id_fkey FOREIGN KEY (product_id) REFERENCES products(product_id);

-- List Tables in Database
\dt

SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';

-- Describe Table Structure
\d table_name;

SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'users';


--  Insert Data
INSERT INTO users (name, email) VALUES ('Alice', 'alice@example.com');
INSERT INTO users (name, email) VALUES ('Bob', 'bob@example.com');

--  Insert Multiple Rows
INSERT INTO orders (user_id, amount) VALUES (1, 99.99), (2, 49.50);
INSERT INTO products (product_name, price) VALUES ('Laptop', 800.00), ('Mouse', 25.00);
INSERT INTO order_items (order_id, product_id, quantity) VALUES (1, 1, 1), (2, 2, 2);

--  Show Table Values
SELECT * FROM users;
SELECT * FROM orders;
SELECT * FROM products;
SELECT * FROM order_items;

--  Add Column into Table
ALTER TABLE users ADD COLUMN phone VARCHAR(15);

--  Update Value from Table
UPDATE users SET phone = '1234567890' WHERE id = 1;

--  Update Multiple Values in One Column
UPDATE users SET phone = '9876543210' WHERE id IN (1,2);

--  Delete Row from Table
DELETE FROM users WHERE id = 2;

--  Delete Multiple Rows
DELETE FROM orders WHERE amount < 50;

--  Delete Table
DROP TABLE orders;
DROP TABLE products;
DROP TABLE order_items;

--  Delete Database
DROP DATABASE my_database;


--  View Table Definition and Metadata
SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'users';

--  Import Data (Run in Terminal)
-- psql -U username -d my_database -f data.sql

--  Export Data (Run in Terminal)
-- pg_dump -U username -d my_database -f backup.sql

--  Querying Data with the SELECT Statement
SELECT * FROM users;

-- The SELECT List
SELECT name, email FROM users;

--  SELECT List Wildcard (*)
SELECT * FROM users;

-- The FROM Clause
SELECT * FROM users;

-- Filtering Results with WHERE Clause
SELECT * FROM users WHERE name = 'Alice';

-- Boolean Operators
SELECT * FROM users WHERE id = 1 AND name = 'Alice';

-- The OR Keyword
SELECT * FROM users WHERE id = 1 OR name = 'Bob';

-- Other Boolean Operators (BETWEEN, LIKE, IN, IS, IS NOT)
SELECT * FROM orders WHERE amount BETWEEN 50 AND 100;
SELECT * FROM users WHERE email LIKE '%@example.com';
SELECT * FROM users WHERE id IN (1,2,3);
SELECT * FROM users WHERE phone IS NOT NULL;

--  ORDER BY and GROUP BY
SELECT * FROM users ORDER BY name ASC;
SELECT user_id, COUNT(*) FROM orders GROUP BY user_id;

--  HAVING Clause
SELECT user_id, COUNT(*) FROM orders GROUP BY user_id HAVING COUNT(*) > 1;

--  JOINs
-- CROSS JOIN
SELECT * FROM users CROSS JOIN orders;

-- INNER JOIN
SELECT users.name, orders.amount FROM users INNER JOIN orders ON users.id = orders.user_id;

-- LEFT OUTER JOIN
SELECT users.name, orders.amount FROM users LEFT JOIN orders ON users.id = orders.user_id;

-- RIGHT OUTER JOIN
SELECT users.name, orders.amount FROM users RIGHT JOIN orders ON users.id = orders.user_id;

-- FULL OUTER JOIN
SELECT users.name, orders.amount FROM users FULL JOIN orders ON users.id = orders.user_id;

-- SELF JOIN
SELECT u1.name AS user1, u2.name AS user2 FROM users u1, users u2 WHERE u1.id <> u2.id;
