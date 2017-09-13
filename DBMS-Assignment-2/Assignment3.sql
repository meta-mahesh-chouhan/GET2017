DROP DATABASE IF EXISTS ecommerce;
CREATE DATABASE ecommerce;

USE ecommerce;

CREATE TABLE IF NOT EXISTS category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    parent_id INT NULL,
    CONSTRAINT category_parent_idfk FOREIGN KEY(parent_id) REFERENCES category(id) 
);

ALTER TABLE category AUTO_INCREMENT = 1001;

# Inserting top category data
INSERT INTO category(name) VALUES("Mobiles & Tablets");
INSERT INTO category(name) VALUES("Computers");
INSERT INTO category(name) VALUES("Home Appliances");

# Inserting sub category data
INSERT INTO category(name, parent_id) VALUES ("Mobiles", 1001);
INSERT INTO category(name, parent_id) VALUES ("Tablets", 1001);
INSERT INTO category(name, parent_id) VALUES ("Accessories", 1001);
INSERT INTO category(name, parent_id) VALUES ("Cases & Covers", 1001);

INSERT INTO category(name, parent_id) VALUES ("Desktop", 1002);
INSERT INTO category(name, parent_id) VALUES ("Laptop", 1002);
INSERT INTO category(name, parent_id) VALUES ("Laptop Accessories", 1002);
INSERT INTO category(name, parent_id) VALUES ("Printers", 1002);

INSERT INTO category(name, parent_id) VALUES ("TVs", 1003);
INSERT INTO category(name, parent_id) VALUES ("Air Conditioners", 1003);
INSERT INTO category(name, parent_id) VALUES ("Washing Machines", 1003);

-- Inserting last category data
INSERT INTO category(name, parent_id) VALUES ("Smart Phones", 1004);
INSERT INTO category(name, parent_id) VALUES ("Features Phones", 1004);
 
INSERT INTO category(name, parent_id) VALUES ("2G", 1005);
INSERT INTO category(name, parent_id) VALUES ("3G", 1005);

INSERT INTO category(name, parent_id) VALUES ("Keyboard", 1010);
INSERT INTO category(name, parent_id) VALUES ("Mouse", 1010);
INSERT INTO category(name, parent_id) VALUES ("Headphones", 1010);

INSERT INTO category(name, parent_id) VALUES ("Inkjet", 1011);
INSERT INTO category(name, parent_id) VALUES ("Laser", 1011);
 
INSERT INTO category(name, parent_id) VALUES ("LED", 1012);
INSERT INTO category(name, parent_id) VALUES ("LCD", 1012);
INSERT INTO category(name, parent_id) VALUES ("Plasma", 1012);
 
INSERT INTO category(name, parent_id) VALUES ("Full Automatic", 1014);
INSERT INTO category(name, parent_id) VALUES ("Semi Automatic", 1014);
 
INSERT INTO category(name, parent_id) VALUES ("Top Load", 1027);
INSERT INTO category(name, parent_id) VALUES ("Front Load", 1027);

# Display all categories with parent category (displaying null)
SELECT a.name as name, b.name as parent_name 
FROM category a LEFT JOIN category b
ON a.parent_id = b.id;

# Display all categories with parent category (not displaying null)
SELECT a.name as name, IFNULL(b.name, "Top Category") as parent_name 
FROM category a LEFT JOIN category b
ON a.parent_id = b.id
ORDER BY parent_name;

# Display only top categories
SELECT name as top_categories  FROM category WHERE parent_id is NULL;





