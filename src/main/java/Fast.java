import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel.Pontryagin on 13.03.2015.
 */
public class Fast {
    public static void main(String[] args) {

        setupScreen();

        // read in the input
        String filename = args[0];
        Point[] points = getData(filename);
        Set<String> linesSet = new HashSet<String>();

        int n = points.length;
        Stack<Point> stack;

        for (int i = 0; i < n - 3; i++) {

            double prevSlope = points[i].slopeTo(points[i + 1]);
            stack = new Stack<Point>();

            Arrays.sort(points, i, n);

            stack.push(points[i]);

            Arrays.sort(points, i + 1, n, points[i].SLOPE_ORDER);

            for (int j = i + 1; j < n; j++) {
                double currSlope = points[i].slopeTo(points[j]);

                if (prevSlope == currSlope) {
                    stack.push(points[j]);

                    if (stack.size() > 3 && j == n - 1) {
                        drawStack(stack, linesSet);
                    }
                    continue;
                }
                if (prevSlope != currSlope) {
                    if (stack.size() > 3) {
                        drawStack(stack, linesSet);
                    }
                    prevSlope = currSlope;
                    clearStack(stack);
                    stack.push(points[i]);
                    stack.push(points[j]);
                }
            }
        }

        // display to screen all at once
        StdDraw.show(0);

        // reset the pen radius
        StdDraw.setPenRadius();
    }

    private static Point[] getData(String filename) {
        In in = new In(filename);
        int n = in.readInt();

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }

        return points;
    }

    private static void setupScreen() {
        // Set graphics
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.015); // make the points a bit larger
    }

    private static void drawStack(Stack<Point> stack, Set linesSet) {

        int stackSize = stack.size();

        Point to = stack.pop();
        String result = to.toString();
        Point from = null;

        while (!stack.isEmpty()) {
            from = stack.pop();
            result = from + " -> " + result;
        }

        if (stackSize > 4) {
            linesSet.add(result.substring(result.indexOf(" (") + 1).hashCode());
            from.drawTo(to);
            StdOut.println(result);
        } else if (!linesSet.contains(result.hashCode())) {
            from.drawTo(to);
            StdOut.println(result);
        }
    }

    private static void clearStack(Stack<Point> stack) {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }
}
