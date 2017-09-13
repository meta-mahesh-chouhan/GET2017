/* 1. Create a View which can be used to display member name and
   all issue details of the member using a simple SELECT command. */
   
CREATE OR REPLACE VIEW issue_details 
AS

SELECT member_name, issue_date, accession_no, due_date
FROM members JOIN book_issue USING(member_id);

SELECT * FROM issue_details;

/* 2. Create a View which contains three columns, member name,
    member id and full description of category, i.e., Faculty, Students
    and Others instead of F,S and O. */

CREATE OR REPLACE VIEW member_details
AS

SELECT member_name, member_id , CASE category
                            WHEN "F" THEN "Faculty"
                            WHEN "S" THEN "Student"
                            WHEN "O" THEN "OTHERS"
                            END as Category
FROM members;

SELECT * FROM member_details;

/* 3. Create a View which contains the information – subject name,
    title, member name, category, issue date, due date and return
    date. If the books have not been returned, NULL should be
    displayed instead of return date. */

CREATE OR REPLACE VIEW subject_details
AS
SELECT subject_name, title_name, md.member_name, category, bi.issue_date, due_date, return_date
FROM book_issue bi
JOIN book USING(accession_no) 
JOIN titles USING(title_id)
JOIN subjects USING(subject_id)
JOIN book_return br ON bi.accession_no = br.accession_no AND bi.member_id = br.member_id AND bi.issue_date = br.issue_date
JOIN members md ON bi.member_id = md.member_id;

SELECT * FROM subject_details;
