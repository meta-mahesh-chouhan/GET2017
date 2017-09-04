/* Create database */
CREATE DATABASE IF NOT EXISTS library;
USE library;

/* Create tables */
CREATE TABLE IF NOT EXISTS members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    member_name VARCHAR(20) NOT NULL,
    addressline1 VARCHAR(100) NOT NULL,
    addressline2 VARCHAR(100),
    category VARCHAR(1) CHECK( category IN ("F" , "M"))
);

CREATE TABLE IF NOT EXISTS publishers (
    publisher_id INT PRIMARY KEY AUTO_INCREMENT,
    publisher_name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS subjects (
    subject_id INT PRIMARY KEY AUTO_INCREMENT,
    subject_name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS titles (
    title_id INT PRIMARY KEY AUTO_INCREMENT,
    title_name VARCHAR(30) NOT NULL,
    subject_id INT,
    publisher_id INT ,
    FOREIGN KEY (subject_id) references subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (publisher_id) references publishers(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS book (
    accession_no INT PRIMARY KEY AUTO_INCREMENT,
    title_id INT ,
    purchase_date TIMESTAMP NOT NULL,
    price FLOAT UNSIGNED NOT NULL,
    status VARCHAR(11) CHECK( status IN ("avaliable" , "unavaliable")),
    FOREIGN KEY(title_id) references titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE
    
);

CREATE TABLE IF NOT EXISTS authors (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    author_name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS title_author (
    author_id INT,
    title_id INT,
    FOREIGN KEY (author_id) references authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (title_id) references titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (author_id ,title_id)
);

CREATE TABLE IF NOT EXISTS has_subject (
    title_id INT,
    subject_id INT ,
    FOREIGN KEY (title_id) references titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (subject_id) references subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (title_id ,subject_id )
);

CREATE TABLE IF NOT EXISTS book_issue (
    issue_date TIMESTAMP,
    member_id INT,
    accession_no INT,
    due_date TIMESTAMP,
    FOREIGN KEY (member_id) references members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (accession_no) references book(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (member_id ,accession_no , issue_date)
);

CREATE TABLE IF NOT EXISTS book_return (
    member_id INT ,
    return_date TIMESTAMP ,
    accession_no INT ,
    issue_date TIMESTAMP,
    FOREIGN KEY (member_id) references members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (accession_no) references book(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (member_id , return_date , accession_no)
);

/* display list of tables */
show tables;

/* Provide default constraints */
ALTER TABLE book_issue MODIFY COLUMN issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

/* Create trigger for insertion in book_issue table */
DELIMITER $$
CREATE TRIGGER add_15days
BEFORE INSERT ON book_issue FOR EACH ROW
BEGIN
  SET NEW.due_date = now() + INTERVAL 15 DAY;
END;
$$
DELIMITER ;

/* Delete foreign key before deleting members table */
ALTER TABLE book_issue DROP FOREIGN KEY book_issue_ibfk_1;
ALTER TABLE book_return DROP FOREIGN KEY book_return_ibfk_1;
DROP TABLE members;

/* Create members table again */
CREATE TABLE IF NOT EXISTS members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    member_name VARCHAR(20) NOT NULL,
    addressline1 VARCHAR(100) NOT NULL,
    addressline2 VARCHAR(100),
    category VARCHAR(1) CHECK( status IN ("F" , "M"))
);