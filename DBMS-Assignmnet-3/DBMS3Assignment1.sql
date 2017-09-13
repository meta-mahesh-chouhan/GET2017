# Display information of books returned after more than 2 months 
SELECT member_name, members.member_id, title_name, book_return.accession_no, issue_date, return_date, TIMESTAMPDIFF(MONTH, issue_date, return_date) as issued_for_months
FROM (( book_return JOIN members ON members.member_id = book_return.member_id ) JOIN book ON book_return.accession_no = book.accession_no ) JOIN titles ON book.title_id = titles.title_id
WHERE TIMESTAMPDIFF(MONTH, issue_date, return_date) > 2;

# Display member_name with maximum length
SELECT member_name , LENGTH(member_name) as length
FROM members
WHERE LENGTH(member_name) = ( SELECT MAX(LENGTH(member_name)) FROM members);

# Total number of books issued
SELECT COUNT(*) Total_issued_books
FROM book_issue;
