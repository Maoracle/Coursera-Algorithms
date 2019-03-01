import java.util.Comparator;

public class Point implements Comparable<Point> {
    public static final Comparator<Point> XY = new XYComparator();

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    private static class XYComparator implements Comparator<Point> {

        public int compare(Point a, Point b) {
            if (a.x < b.x) return -1;
            else if (a.x > b.x) return 1;
            else if (a.y < b.y) return -1;
            else if (a.y > b.y) return 1;
            else return 0;
        }
    }

    public int compareTo(Point a) {
        if (this.x < a.x) return -1;
        else if (this.x > a.x) return 1;
        else if (this.x > a.x) return 1;
        else if (this.y < a.y) return -1;
        else return 0;
    }
}
