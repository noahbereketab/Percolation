/* *****************************************************************************
 *  Name: Noah Bereketab
 *  NetID: noahkb
 *  Precept:
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Operating system:
 *  Compiler:
 *  Text editor / IDE:
 *
 *  Have you taken (part of) this course before: No
 *  Have you taken (part of) the Coursera course Algorithms, Part I or II: No
 *
 *  Hours to complete assignment (optional):
 *
 **************************************************************************** */

Programming Assignment 1: Percolation


/* *****************************************************************************
 *  Describe the data structures (i.e., instance variables) you used to
 *  implement the Percolation API.
 **************************************************************************** */


/* *****************************************************************************
 *  Briefly describe the algorithms you used to implement each method in
 *  the Percolation API.
 **************************************************************************** */
open(): I had a condition that would check if a site wasn't open and if it wasn't
open I would open it by setting its place in the grid to 1. I had two conditions
if the row given was a top or bottom where I would make a path. I had four
conditions checking to the left, right, above, and below the given row/column that
when open would union with the given row/column.
isOpen(): I had a condition that would return true if the given row or col in the
grid array was set to 1 indicating that the site was open. Otherwise it returned
false.
isFull(): I had a condition that would return true if the given site was
 an open site and if the open site in the top row had the same leader as the
given site making there be a connection. If not then it is not full;
numberOfOpenSites(): I had a instance variable counter that would track the
number of open sites and would increment every time a site was opened in the
open() method which I simply returned in this method.
percolates(): I had a condition that would return true if there was a op site
in the top row, a full site in the bottom row, and they had the same leader
making there be a connection. If not then it does not percolate.

/* *****************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for various values of n and T when implementing
 *  Percolation.java with QuickFindUF.java (not QuickUnionUF.java). Use a
 *  "doubling" hypothesis, where you successively increase either n or T by
 *  a constant multiplicative factor (not necessarily 2).
 *
 *  To do so, fill in the two tables below. Each table must have 5-10
 *  data points, ranging in time from around 0.25 seconds for the smallest
 *  data point to around 30 seconds for the largest one. Do not include
 *  data points that take less than 0.25 seconds.
 **************************************************************************** */

(keep T constant)
 T = 100
 multiplicative factor (for n) = 1.5

 n          time (seconds)       ratio         log ratio
--------------------------------------------------------
120          0.251               n/a            n/a
180          0.550               2.2            1.944
270          1.495               2.718          2.466
405          5.141               3.439          3.046
608          17.720              3.447          3.052


(keep n constant)
 n = 100
 multiplicative factor (for T) = 2

 T          time (seconds)       ratio         log ratio
--------------------------------------------------------
200          0.283               n/a             n/a
400          0.519              1.834            0.875
800          0.986              1.9              0.926
1600         1.985              2.013            1.009
3200         3.862              1.945            0.96
6400         7.866              2.037            1.026
12800        15.320             1.948            0.962
25600        30.201             1.971            0.979


/* *****************************************************************************
 *  Using the empirical data from the above two tables, give a formula
 *  (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as function of both n and T, such as
 *
 *       ~ 5.3*10^-8 * n^5.0 * T^1.5
 *
 *  Briefly explain how you determined the formula for the running time.
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Use two significant figures for each coefficient and exponent
 *  (e.g., 5.3*10^-8 or 5.0).
 **************************************************************************** */

QuickFindUF running time (in seconds) as a function of n and T:

    ~
       6.6*10^-10 * n^3.04 * T^0.98



  The exponent for n was found by averaging the log ratio for repeated
       trials of n = 405, T = 100 and found to be 3.04

       The exponent was for T was found by averaging the log ratio for repeated
         trials of n = 405, T = 100 and found to be 0.98


/* *****************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 **************************************************************************** */

(keep T constant)
 T = 100

 n          time (seconds)       ratio         log ratio
--------------------------------------------------------
200          0.341               n/a            n/a
300          0.763               2.238          2.0
450          1.606               2.105          1.836
675         4.596                2.862          2.593
1012        14.029               3.052          2.752
1519        43.118               3.073          2.769

(keep n constant)
 n = 100

 T          time (seconds)       ratio         log ratio
--------------------------------------------------------
300          0.257               n/a             n/a
600          0.472              1.837            0.877
1200          0.86              1.822            0.866
2400         1.635              1.901            0.927
4800         3.169              1.938            0.955
9600          6.271             1.98             0.986
19200         12.488            1.991            0.993
38400         25.435            2.037            1.026


WeightedQuickUnionUF running time (in seconds) as a function of n and T:

    ~
       2.53*10^-9 * n^2.6 * T^.98

       The exponent for n was found by averaging the log ratio for repeated
       trials of n = 1519, T = 100 and found to be 2.6

       The exponent was for T was found by averaging the log ratio for repeated
         trials of n = 1519, T = 100 and found to be 0.98



/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
N/A



/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */
I got help from a Sunday Lab TA.

/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */
I was dealing with an array index out of bounds error in my PercolationStats,
that a LAB TA helped me realized was due to the fact that my for loop condition
 and array were set to different value.



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */
N/A
