/* 1. Write a SELECT command to display name of those members who belong to the category as to which member
    “Jon Snow” belongs.
    Note: Solve the problem using subquery. */
SELECT member_name
FROM members
WHERE member_name != "Jon Snow" AND members.category IN ( 
                                                    SELECT category 
                                                    FROM members 
                                                    WHERE member_name = "Jon Snow" ) ;

/* 2. Write a SELECT command to display information on the books
    that have not been returned till date. The information should
    include book issue date, title, member name and due date.
    Note: Use Correlated Subquery. */
SELECT bi.issue_date, title_name, member_name, bi.due_date
FROM book_issue bi JOIN members USING(member_id) JOIN book USING(accession_no) JOIN titles ON book.title_id = titles.title_id 
WHERE EXISTS ( SELECT member_id, accession_no
                FROM book_return br WHERE return_date IS NULL AND bi.accession_no = br.accession_no AND bi.member_id = br.member_id);



/* 3. SELECT command to display information on the books
    that have been returned after their due dates. The information
    should include book issue date, title, member name and due date.
    Note: Use Correlated Subquery.
*/                
SELECT bi.issue_date, title_name, member_name, bi.due_date
FROM book_issue bi JOIN members USING(member_id) JOIN book USING(accession_no) JOIN titles ON book.title_id = titles.title_id 
WHERE EXISTS ( SELECT member_id, accession_no
               FROM book_return br
                WHERE bi.accession_no = br.accession_no AND bi.member_id = br.member_id AND bi.issue_date = br.issue_date AND br.return_date > bi.due_date
                );
                    
                
/*4. SELECT command to display information of those books
    whose price is equal to the most expensive book purchase so far.*/
    
SELECT accession_no, title_name, price
FROM book JOIN titles ON book.title_id = titles.title_id 
WHERE book.price = ( SELECT MAX(price) FROM book );

/*5. SELECT command to display the second maximum price of a book. */
SELECT accession_no, titles.title_name AS 'Title Name', purchase_date, price 
FROM book JOIN titles USING(title_id) 
GROUP BY price 
ORDER BY price DESC 
LIMIT 1 OFFSET 1;
