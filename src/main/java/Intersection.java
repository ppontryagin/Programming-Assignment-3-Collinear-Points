import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pavel.Pontryagin on 14.03.2015.
 */
public class Intersection {

    public class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point that) {
            if (this.x > that.x) return 1;
            if (this.x < that.x) return -1;
            if (this.y > that.y) return 1;
            if (this.y < that.y) return -1;
            return 0;
        }
    }

    public Point[] intersect(Point[] a, Point[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        List<Point> duples = new ArrayList<Point>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    duples.add(a[i]);
                    break;
                }
            }
        }
        return (Point[]) duples.toArray();
    }
}

