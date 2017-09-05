USE ecommerce;

CREATE TABLE IF NOT EXISTS state (
    state_id INT PRIMARY KEY AUTO_INCREMENT,
    state_name VARCHAR(20) NOT NULL
);

ALTER TABLE state AUTO_INCREMENT = 10;

CREATE TABLE IF NOT EXISTS city (
    city_id INT PRIMARY KEY AUTO_INCREMENT,
    city_name VARCHAR(20) NOT NULL,
    zipcode INT NOT NULL,
    state_id INT NOT NULL ,
    FOREIGN KEY (state_id) REFERENCES state(state_id)
);

ALTER TABLE city AUTO_INCREMENT = 100;


INSERT INTO state(state_name) VALUES ("Rajasthan");
INSERT INTO state(state_name) VALUES ("Maharashtra");
INSERT INTO state(state_name) VALUES ("Gujarat");
INSERT INTO state(state_name) VALUES ("Madhya Pradesh");
INSERT INTO state(state_name) VALUES ("Tamil Nadu");

INSERT INTO city(city_name, zipcode, state_id) VALUES ("Jaipur", 320339, 10);
INSERT INTO city(city_name, zipcode, state_id) VALUES ("Jodhpur", 342005, 10);
INSERT INTO city(city_name, zipcode, state_id) VALUES ("Udaipur", 313001, 10);

INSERT INTO city(city_name, zipcode, state_id) VALUES ("Pune", 411044, 11);
INSERT INTO city(city_name, zipcode, state_id) VALUES ("Mumbai", 40090, 11);

INSERT INTO city(city_name, zipcode, state_id) VALUES ("Indore", 453115, 13);
INSERT INTO city(city_name, zipcode, state_id) VALUES ("Bhopal", 463020,13);

INSERT INTO city(city_name, zipcode, state_id) VALUES ("Ahemdabad", 382120, 12);
INSERT INTO city(city_name, zipcode, state_id) VALUES ("Gandhi Nagar", 382424, 12);

INSERT INTO city(city_name, zipcode, state_id) VALUES ("Chennai", 600040, 14);
INSERT INTO city(city_name, zipcode, state_id) VALUES ("Ooty", 6643204, 14);

# Display zipcode , city name and state name sorted by state name and city name
SELECT zipcode , city_name , state_name
FROM city JOIN state
ON city.state_id = state.state_id
ORDER BY state_name , city_name;