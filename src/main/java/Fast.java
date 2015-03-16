import java.util.Arrays;

/**
 * Created by Pavel.Pontryagin on 13.03.2015.
 */
public class Fast {
    public static void main(String[] args) {

        setupScreen();

        // read in the input
        String filename = args[0];
        Point[] points = getData(filename);
        Arrays.sort(points);

        int n = points.length;
        Stack<Point> stack;

        for (int i = 0; i < n - 2; i++) {

            double prevSlope = points[i].slopeTo(points[i + 1]);
            stack = new Stack<Point>();
            stack.push(points[i]);
            Arrays.sort(points, i + 1, n, points[i].SLOPE_ORDER);

            for (int j = i + 1; j < n; j++) {
                double currSlope = points[i].slopeTo(points[j]);
                if (prevSlope == currSlope) {
                    stack.push(points[j]);
                    if (stack.size() > 3 && j == n - 1) {
                        drawStack(stack);
                    }
                    continue;
                }
                if (prevSlope != currSlope) {
                    if (stack.size() > 3) {
                        drawStack(stack);
                    }
                    prevSlope = currSlope;
                    clearStack(points[i], stack);
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
        String str = in.readLine();
        str = in.readLine();
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

    private static void drawStack(Stack<Point> stack) {

        Point from = stack.pop();
        String result = from.toString();
        Point to = null;

        while (!stack.isEmpty()) {
            to = stack.pop();
            result = result + " -> " + to;
        }

        from.drawTo(to);
//        StdDraw.show();
        StdOut.println(result);
    }

    private static void clearStack(Point point, Stack<Point> stack) {
        while (stack.peek() != point) {
            stack.pop();
        }
    }

}
