Programming fundamental - Assignments
Session 4 (Recursion)
Duration (6 Hours) 

Assignment 1: 
Tower of Hanoi
List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk)
Write JUnit for the above program:
towerOfHanoi(“A”, “B”, “C”, 1);
Expected: Returns List of movements of discs.
Move Disk 1 from A to B 

towerOfHanoi(“A”, “B”, “C”, 2);
Expected: Returns List of movements of discs.
Move Disk 2 from A to C 
Move Disk 1 from A to B 
Move Disk 2 from C to B

towerOfHanoi(“A”, “B”, “C”, 3);
Expected: Returns List of movements of discs.
Move Disk 3 from A to B 
Move Disk 2 from A to C 
Move Disk 3 from B to C
Move Disk 1 from A to B 
Move Disk 3 from C to A 
Move Disk 2 from C to B
Move Disk 3 from A to B

Assignment 2: 
Write a Java program to generate all possible permutations of given letters in string.

Can you make it more generic so that it can generate permutations of any length of string.

List<String> generatePermutations(String input);

Write JUnit for the above program:
generatePermutations(“ABC”);
Expected: Return List of string containing following values:
ABC
ACB
BAC
BCA
CBA
CAB

2) generatePermutations(“ABCD”);
Expected: Return List of string containing 24 unique permutations.

Assignment 3:

N Queens Problem - The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. (Thus, a solution requires that no two queens share the same row, column, or diagonal)
Boolean  nQueen(int[][], int startRow, int dimensionOfMatrix);
int [][] board = new int [][] {
             { 0,  0,  0,  0},
              { 0,  0,  0,  0},
              { 0,  0,  0,  0},
              { 0,  0,  0,  0} };
Boolean result = nQueen(board , 0, 4);
Where result should be true and board should have following content. 

Following is a solution for 4 Queen problem.	

The expected output is a binary matrix which has 1s for the blocks where queens are placed. For example following is the output matrix for above 4 queen solution.
             { 0,  1,  0,  0}
              { 0,  0,  0,  1}
              { 1,  0,  0,  0}
              { 0,  0,  1,  0}
Write JUNIT Test Case for above problem



Challenging Problem

knights-tour-problem:A knight's tour is a sequence of moves of a knight on a chessboard such that the knight visits every square only once. If the knight ends on a square that is one knight's move from the beginning square (so that it could tour the board again immediately, following the same path), the tour is closed, otherwise it is open.

Implement knights-tour-problem for n*n matrix


