/* *****************************************************************************
 *  Name:    Noah Bereketab
 *  NetID:   noahkb
 *  Precept: P06
 *
 *  Description:  Compute Percolation stats
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    // instance variable to count the number of experiments
    private int experimentCount;
    // Array to store percolation threshold
    private double[] threshold;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        experimentCount = trials;
        threshold = new double[experimentCount];
        for (int i = 0; i < experimentCount; i++) {
            int row = 0;
            int col = 0;
            int openSites = 0;
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                row = StdRandom.uniform(0, n);
                col = StdRandom.uniform(0, n);
                if (!percolation.isOpen(row, col))
                    openSites++;
                percolation.open(row, col);
            }
            threshold[i] = openSites / (double) (n * n);
        }

    }


    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(threshold);

    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(threshold);

    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(experimentCount));

    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(experimentCount));

    }

    // test client (see below)
    public static void main(String[] args) {
        Stopwatch time = new Stopwatch();
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats p1 = new PercolationStats(n, t);
        StdOut.printf("mean()         = %f\n", p1.mean());
        StdOut.printf("stddev()         = %f\n", p1.stddev());
        StdOut.printf("confidenceLow()  = %f\n", p1.confidenceLow());
        StdOut.printf("confidenceHigh()  = %f\n", p1.confidenceHigh());
        StdOut.printf("elapsed time     = %f\n", time.elapsedTime());
    }

}
