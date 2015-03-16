import java.util.Arrays;

/**
 * Created by Pavel.Pontryagin on 13.03.2015.
 */
public class Fast {
    public static void main(String[] args) {

        setupScreen();

        String filename = args[0];
        Point[] points = getData(filename);

        int n = points.length;
        Stack<Point> stack;

        for (int i = 0; i < n - 1; i++) {

            stack = new Stack<Point>();

            Arrays.sort(points);

            Arrays.sort(points, points[i].SLOPE_ORDER);
            stack.push(points[0]);
            double prevSlope = points[0].slopeTo(points[1]);
            stack.push(points[1]);

            for (int j = 2; j < n; j++) {
                double currSlope = points[0].slopeTo(points[j]);

                if (prevSlope == currSlope) {
                    stack.push(points[j]);

                    if (stack.size() > 3 && j == n - 1) {
                        drawStack(stack, points[0]);
                    }
                    continue;
                }
                if (prevSlope != currSlope) {
                    if (stack.size() > 3) {
                        drawStack(stack, points[0]);
                    }
                    prevSlope = currSlope;
                    clearStack(stack);
                    stack.push(points[0]);
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
        StdDraw.setPenRadius(0.001); // make the points a bit larger
    }

    private static void drawStack(Stack<Point> stack, Point sortPoint) {

        Point[] checkLine = new Point[stack.size()];
        int index = 0;

        while (!stack.isEmpty()) {
            checkLine[index++] = stack.pop();
        }
        Arrays.sort(checkLine);

        String result = checkLine[0].toString();

        for (int i = 1; i < index; i++) {
            result = result + " -> " + checkLine[i];
        }

//            from.drawTo(to);
        if (sortPoint == checkLine[0]) {
            StdOut.println(result);
            checkLine[0].drawTo(checkLine[index - 1]);
        }
//        StdOut.println(sortPoint);
    }

    private static void clearStack(Stack<Point> stack) {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }
}
