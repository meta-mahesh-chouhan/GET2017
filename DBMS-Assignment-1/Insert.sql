USE library;

/* Insert values into members table */
INSERT INTO members(member_id ,member_name ,addressline1 ,addressline2 ,category) VALUES (1001,"Mahesh","Pratap Nagar","Udaipur","M");
INSERT INTO members(member_name ,addressline1 ,addressline2 ,category) VALUES ("Udit","Pratap Nagar","Udaipur","M");
INSERT INTO members(member_name ,addressline1 ,addressline2 ,category) VALUES ("Prateek","Choti Peepli","Udaipur","M");
INSERT INTO members(member_name ,addressline1 ,addressline2 ,category) VALUES ("Rajat","Gopalpura","Udaipur","M");
INSERT INTO members(member_name ,addressline1 ,addressline2 ,category) VALUES ("Anushtha","Bhopalpura","Udaipur","F");

SELECT * FROM members;

/* Insert values into author table */
INSERT INTO authors(author_id, author_name) VALUES(101, "H.C.Verma");
INSERT INTO authors(author_name) VALUES("Dennis Ritchie");
INSERT INTO authors(author_name) VALUES("Herbert Schildt");
INSERT INTO authors(author_name) VALUES("John Green");
INSERT INTO authors(author_name) VALUES("Balaguruswami");

SELECT * FROM authors;

/* Insert values into publishers table */

INSERT INTO publishers(publisher_id, publisher_name) VALUES(1, "NotionPress");
INSERT INTO publishers(publisher_name) VALUES("Tata McGraw Hill");
INSERT INTO publishers(publisher_name) VALUES("Arihant Publications");
INSERT INTO publishers(publisher_name) VALUES("Taxmann Publications");
INSERT INTO publishers(publisher_name) VALUES("Genius Publications");
INSERT INTO publishers(publisher_name) VALUES("Ashirwad Publications");

SELECT * FROM publishers;

/* Insert values into subjects table */
INSERT INTO subjects(subject_id, subject_name) VALUES(1, "Physics");
INSERT INTO subjects(subject_name) VALUES("Programming");
INSERT INTO subjects(subject_name) VALUES("Chemistry");
INSERT INTO subjects(subject_name) VALUES("JAVA");
INSERT INTO subjects(subject_name) VALUES("Mathematics");

SELECT * FROM subjects;

/* Insert values into titles table */
INSERT INTO titles(title_id ,title_name ,subject_id ,publisher_id) VALUES(10000 ,"Concepts Of Physics" ,1,1);
INSERT INTO titles(title_name ,subject_id ,publisher_id) VALUES("Concepts Of Programming" ,2 ,2);
INSERT INTO titles(title_name ,subject_id ,publisher_id) VALUES("Concepts Of Chemistry" ,3 ,3);
INSERT INTO titles(title_name ,subject_id ,publisher_id) VALUES("Concepts Of C++" ,2 ,4);
INSERT INTO titles(title_name ,subject_id ,publisher_id) VALUES("Concepts Of Java" ,4 ,5);

SELECT * FROM titles;

/* Insert values into book table */
INSERT INTO book(accession_no ,title_id ,price ,status) VALUES(2000 ,10000 ,250.00 ,"avaliable");
INSERT INTO book(title_id ,price ,status) VALUES(10001 ,350.00 ,"unavaliable");
INSERT INTO book(title_id ,price ,status) VALUES(10002 ,150.00 ,"avaliable");
INSERT INTO book(title_id ,price ,status) VALUES(10003 ,450.00 ,"unavaliable");
INSERT INTO book(title_id ,price ,status) VALUES(10004 ,1250.00 ,"avaliable");

SELECT * FROM book;

/* Insert values into book_issue table */
INSERT INTO book_issue(member_id ,accession_no) VALUES(1001 ,2000);
INSERT INTO book_issue(member_id ,accession_no) VALUES(1002 ,2001);
INSERT INTO book_issue(member_id ,accession_no) VALUES(1003 ,2002);
INSERT INTO book_issue(member_id ,accession_no) VALUES(1004 ,2003);
INSERT INTO book_issue(member_id ,accession_no) VALUES(1005 ,2004);

SELECT * FROM book_issue;

/* Insert values into book_return table */
INSERT INTO book_return(accession_no,member_id, issue_date) 
SELECT accession_no, member_id, issue_date
FROM book_issue 
WHERE member_id = '1001' AND accession_no = '2000';

INSERT INTO book_return(accession_no,member_id, issue_date)
SELECT accession_no, member_id, issue_date
FROM book_issue
WHERE member_id = '1002' AND accession_no = '2001';

INSERT INTO book_return(accession_no,member_id, issue_date)
SELECT accession_no, member_id, issue_date
FROM book_issue 
WHERE member_id = '1003' AND accession_no = '2002';

INSERT INTO book_return(accession_no,member_id, issue_date)
SELECT accession_no, member_id, issue_date
FROM book_issue
WHERE member_id = '1004' AND accession_no = '2003';

INSERT INTO book_return(accession_no,member_id, issue_date)
SELECT accession_no, member_id, issue_date
FROM book_issue 
WHERE member_id = '1005' AND accession_no = '2004';


SELECT * FROM book_return;

/* Insert values into title_author table */
INSERT INTO title_author(author_id,title_id) VALUES(101,10000);
INSERT INTO title_author(author_id,title_id) VALUES(102,10001);
INSERT INTO title_author(author_id,title_id) VALUES(104,10002);
INSERT INTO title_author(author_id,title_id) VALUES(105,10003);
INSERT INTO title_author(author_id,title_id) VALUES(103,10004);

SELECT * FROM title_author;

/* Insert values into has_subject table */
INSERT INTO has_subject(title_id ,subject_id) VALUES(10000,1);
INSERT INTO has_subject(title_id ,subject_id) VALUES(10001,2);
INSERT INTO has_subject(title_id ,subject_id) VALUES(10002,3);
INSERT INTO has_subject(title_id ,subject_id) VALUES(10003,2);
INSERT INTO has_subject(title_id ,subject_id) VALUES(10004,4);

SELECT * FROM has_subject;


SET SQL_SAFE_UPDATES = 0;
/* Update addressLine2 of members table */
UPDATE members SET addressLine2 = "Jaipur";

/* Update addressLine1 of members table */
UPDATE members SET addressLine1 = "EPIP,Sitapura" WHERE category = "F";

/* Delete rows from publishers table */

DELETE FROM publishers;
SET SQL_SAFE_UPDATES = 1;

/* Insert values into publisher table using substitution varaibles */
SET @publisher_name := "Penguin Publishers";
SET @publisher_id := 1;
INSERT INTO publishers(publisher_id ,publisher_name) VALUES (@publisher_id ,@publisher_name);

SET @publisher_name := "Kiwi Publishers";
SET @publisher_id := 2;
INSERT INTO publishers(publisher_id ,publisher_name) VALUES (@publisher_id ,@publisher_name);

SET @publisher_name := "Macmillian Publishers";
SET @publisher_id := 3;
INSERT INTO publishers(publisher_id ,publisher_name) VALUES (@publisher_id ,@publisher_name);

SET @publisher_name := "Motorola Publishers";
SET @publisher_id := 4;
INSERT INTO publishers(publisher_id ,publisher_name) VALUES (@publisher_id ,@publisher_name);

SET @publisher_name := "Preeti Publishers";
SET @publisher_id := 5;
INSERT INTO publishers(publisher_id ,publisher_name) VALUES (@publisher_id ,@publisher_name);

SELECT * FROM publishers;


/* Delete row from publishers */
DELETE FROM publishers WHERE publisher_id = 1;
