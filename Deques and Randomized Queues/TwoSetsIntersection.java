import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class TwoSetsIntersection {
    public static SET<Point> intersect(Point[]a, Point[]b){
        int N = a.length;
        Arrays.sort(a, Point.XY);
        Arrays.sort(b, Point.XY);
        SET<Point> intersection = new SET<Point>();

        int i = 0, j = 0;
        while (i < N && j < N){
            if (less(a[i], b[j])) i++;
            else if (less(b[j], a[i])) j++;
            else {
                intersection.add(a[i]);
                i++;
                j++;
            }
        }
        return intersection;
    }

    private static boolean less(Point a, Point b){
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        int N = 10;
        Point[] a = new Point[N];
        Point[] b = new Point[N];
        for (int i = 0; i < N; i++) {
            int x1 = StdRandom.uniform(0, 10);
            int y1 = StdRandom.uniform(0, 10);
            a[i] = new Point(x1, y1);
            int x2 = StdRandom.uniform(0, 10);
            int y2 = StdRandom.uniform(0, 10);
            b[i] = new Point(x2, y2);
        }
        StdOut.println("a:");
        for (Point p : a)
            StdOut.println("(" + p.x() + ", " + p.y() + ")");

        StdOut.println("b:");
        for (Point p : b)
            StdOut.println("(" + p.x() + ", " + p.y() + ")");

        SET<Point> intersected = TwoSetsIntersection.intersect(a, b);

        StdOut.println("intersection:");
        for (Point p : intersected)
            StdOut.println("(" + p.x() + ", " + p.y() + ")");
    }
}
