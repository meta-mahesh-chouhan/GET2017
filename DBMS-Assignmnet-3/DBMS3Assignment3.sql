# Display total numbers of Students , Faculty and Other category in single row
SELECT COUNT( IF(category = "S",1,NULL)) as Student_Count,
COUNT( IF(category = "F",1,NULL)) as Faculty_Count,
COUNT( IF(category = "O",1,NULL)) as Other_Count
FROM Members;

# Information of books issued for more than 2 times
SELECT titles.title_id, title_name 
FROM (( book_issue JOIN book ON book_issue.accession_no = book.accession_no) JOIN titles ON titles.title_id = book.title_id)
GROUP BY book_issue.accession_no
HAVING COUNT(book_issue.accession_no) > 2;

# Information of books issued for category other than Faculty
SELECT book.accession_no, titles.title_name
FROM (((book_issue JOIN book ON book_issue.accession_no = book.accession_no) JOIN titles ON titles.title_id = book.title_id) JOIN members ON book_issue.member_id = members.member_id)
WHERE members.category != "F";

# Information of authors for which more than one book is purchased
SELECT title_author.author_id, author_name
FROM authors JOIN title_author ON authors.author_id = title_author.author_id; 
