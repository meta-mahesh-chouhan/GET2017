/*
Modify the SELECT command written for above query 
to display results in ascending order of issue date 
and within issue date in ascending order of member's name.
*/
SELECT issue_date, accession_no, book_return.member_id, member_name, IFNULL(return_date, " ") as return_date
FROM book_return INNER JOIN members ON book_return.member_id = members.member_id
ORDER BY issue_date, member_name;