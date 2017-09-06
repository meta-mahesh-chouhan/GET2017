# Subjective wise information of books purchased
SELECT subjects.subject_name, subjects.subject_id , COUNT(accession_no)
FROM ( titles RIGHT JOIN subjects ON subjects.subject_id = titles.subject_id) LEFT JOIN book ON titles.title_id = book.title_id
GROUP BY subject_name;

# Display information of books issued for more than 2 months 
SELECT book_issue.accession_no, title_name
FROM (book_issue JOIN book ON book_issue.accession_no = book.accession_no) JOIN titles ON book.title_id = titles.title_id 
WHERE TIMESTAMPDIFF(MONTH, issue_date, due_date ) > 2;

# List of books having price greater than minimum price

SELECT accession_no, title_name, price
FROM book JOIN titles ON book.title_id = titles.title_id 
WHERE book.price > ( SELECT MIN(price) FROM book );