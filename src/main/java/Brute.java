import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brute {
    public static void main(String[] args) {

        // Set graphics
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01); // make the points a bit larger

        List<Point> points = new ArrayList<Point>();

        // read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points.add(p);
            p.draw();
        }

        int n = points.size();

        List<Point> lines = new ArrayList<Point>(4);

//        findLines();
        for (int i = 0; i < n - 3; i++) {
            Point pI = points.get(i);
            for (int j = i + 1; j < n - 2; j++) {
                Point pJ = points.get(j);
                for (int k = j + 1; k < n - 1; k++) {
                    Point pK = points.get(k);
                    if (pI.slopeTo(pJ) != pJ.slopeTo(pK)) {
                        continue;
                    }
                    for (int l = k + 1; l < n; l++) {
                        Point pL = points.get(l);
                        if (pJ.slopeTo(pK) != pK.slopeTo(pL)) {
                            continue;
                        }

                        lines.add(pI);
                        lines.add(pJ);
                        lines.add(pK);
                        lines.add(pL);

                        Collections.sort(lines);

                        StdOut.println(lines.get(0) + " -> " + lines.get(1) + " -> "
                                + lines.get(2) + " -> " + lines.get(3));

                        lines.get(0).drawTo(lines.get(3));
                        lines.clear();
                    }
                }
            }
        }

        // display to screen all at once
        StdDraw.show(0);

        // reset the pen radius
        StdDraw.setPenRadius();

    }
}