USE library;

/*
to display all the columns of mmbers table
*/
SELECT * FROM members;

/*
to display member_name , member_id and category
*/
SELECT member_id, member_name, category FROM members;

/*
to display member_name , member_id and category from members table where category of member is Faculty('F').
*/
SELECT member_id, member_name, category FROM members WHERE category = "F";

/*
to display various categories of members
*/
SELECT DISTINCT category FROM members;

/*
to display member name and their category in the descending order of member name
*/
SELECT member_name, category FROM members ORDER BY member_name DESC;

/*
to display all the titles, their subject and publishers
*/
SELECT title_name, subject_name, publisher_name 
FROM (titles INNER JOIN subjects ON subjects.subject_id = titles.subject_id) INNER JOIN publishers ON titles.publisher_id = publishers.publisher_id;

/*
to display number of members present in each category. 
The result should include category and number of members belongs to that category
*/
SELECT category, COUNT(member_id)
FROM members
GROUP BY category;

/*
to display name of those members who belongs to the
category as to which member "Udit Saxena" belongs.
Solve the problem using join operation
*/
SELECT b.member_name 
FROM members a INNER JOIN members b
ON a.member_name = "Keshav Sharma" AND a.category = b.category;


/*
To display information on all the books issued. 
The result should include issue date, accession no, member id and return date.
If the book has not been returned, the column return date should be left blank. 
Give appropriate heading from the columns
*/
SELECT issue_date, accession_no, member_id, IFNULL(return_date, "") as return_date
FROM book_return;
