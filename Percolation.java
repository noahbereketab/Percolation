/* *****************************************************************************
 *  Name:    Noah Bereketab
 *  NetID:   noahkb
 *  Precept: P06
 *
 *  Description:  Uses WeightedQuickUnionUF to simulate a Percolation system
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // instance variable grind array
    private int[][] grid;
    // instance variable WeightedQuickUnionUF object
    private WeightedQuickUnionUF path;
    // instance variable size of the grid
    private int size;
    // instance variable top of the grid
    private int top;
    // instance variable top of the bottom
    private int bottom;
    // instance variable open sites count
    private int openSitesCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Out of bounds");

        grid = new int[n][n];
        path = new WeightedQuickUnionUF(n * n + 2);
        size = n;
        top = (size * size) + 1;
        bottom = (size * size);
        openSitesCount = 0;

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
            throw new IllegalArgumentException("Out of bounds");


        if (!isOpen(row, col)) {
            grid[row][col] = 1;
            openSitesCount++;
        }
        if (row == 0) {
            path.union(getIndex(0, col), top);
        }

        if (row == size - 1) path.union((row) * size + (col), bottom);


        if (row > 0 && isOpen(row - 1, col)) {
            path.union(getIndex(row, col), getIndex(row - 1, col));
        }

        if (row < size - 1 && isOpen(row + 1, col)) {
            path.union(getIndex(row, col), getIndex(row + 1, col));
        }

        if (col > 0 && isOpen(row, col - 1)) {
            path.union(getIndex(row, col), getIndex(row, col - 1));
        }

        if (col < size - 1 && isOpen(row, col + 1)) {
            path.union(getIndex(row, col), getIndex(row, col + 1));
        }

    }

    // Method to get the index of given row and column
    private int getIndex(int row, int col) {
        return (row) * size + (col);
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
            throw new IllegalArgumentException("Out of bounds");

        if (grid[row][col] == 1) return true;
        else return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
            throw new IllegalArgumentException("Out of bounds");
        if (isOpen(row, col) && path.find(top) == path.find(getIndex(row, col))) {
            return true;
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSitesCount;

    }

    // does the system percolate?
    public boolean percolates() {
        if (path.find(top) == path.find(bottom)) return true;
        return false;
    }

    // unit testing (required)
    public static void main(String[] args) {
        int n = 10;
        Percolation p1 = new Percolation(n);
        p1.open(n - 1, n - 1);
        StdOut.println(p1.isOpen(n - 1, n - 1));
        StdOut.println(p1.isFull(n - 1, n - 1));
        StdOut.println(p1.numberOfOpenSites());
        StdOut.println(p1.percolates());
    }

}
