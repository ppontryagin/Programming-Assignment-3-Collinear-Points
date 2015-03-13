/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;
import edu.princeton.cs.introcs.StdDraw;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeComparator(); // YOUR DEFINITION HERE

    private final int x; // x coordinate
    private final int y; // y coordinate
    
    private class SlopeComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
//            double slope1 = slopeTo(p1);
//            double slope2 = slopeTo(p2);
//     
//            if (slope1 < slope2) {
//                return -1;
//            }
//            else if (slope1 > slope2) {
//                return 1;
//            }
//            else {
//                return 0;
//            }         
            
            return p1.compareTo(p2);            
        }        
    }

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {

        // check the same node
        if ((that.x == this.x) && (that.y == this.y)) {
            return Double.NEGATIVE_INFINITY;
        }

        // check vertical
        if (that.x == this.x) {
            return Double.POSITIVE_INFINITY;
        }

        // check horizontal
        if (that.y == this.y) {
            return +0D;
        }

        return (double) (that.y - this.y) / (that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {

        if ((that.y > this.y) || ((that.y == this.y) && (that.x > this.x))) {
            return -1;
        } else if ((that.y == this.y) && (that.x == this.x)) {
            return 0;
        } else {
            return 1;
        }
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}