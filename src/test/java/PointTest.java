import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PointTest {
    
    @Test
    public void slopeIsCorrect() {
        
        // -45
        Point p0 = new Point(0, 0); 
        Point p1 = new Point(-1, 1); 
        
        double slope = p0.slopeTo(p1);  
        
        assertTrue(Double.compare(-1D, slope) == 0);
        
        // 45
        p1 = new Point(1, 1);
        slope = p0.slopeTo(p1);
        assertTrue(Double.compare(1D, slope) == 0);
        
        // horizontal - positive zero
        p1 = new Point(1, 0);
        slope = p0.slopeTo(p1);
        assertTrue(Double.compare(0, slope) == 0);


        // vertical - positive infinity
        p1 = new Point(0, 1);
        slope = p0.slopeTo(p1);
        assertTrue(Double.compare(Double.POSITIVE_INFINITY, slope) == 0);
        
        //between a point and itself) - negative infinity
        p1 = new Point(0, 0);
        slope = p0.slopeTo(p1);
        assertTrue(Double.compare(Double.NEGATIVE_INFINITY, slope) == 0);
    }
    
    @Test
    public void positiveNull() {
        Point p0 = new Point(0, 0); 
        Point p1 = new Point(-1, 0); 
        
        double slope = p0.slopeTo(p1);  
        
        assertTrue((1 / slope) > 0);
    }
    
    @Test
    public void comparesTo() {
        Point p0 = new Point(0, 0); 
        Point p1 = new Point(-1, 0); 
        
        assertTrue(p0.compareTo(p1) == 1);
        
        p1 = new Point(1, 0);
        
        assertTrue(p0.compareTo(p1) == -1);
        
        p1 = new Point(0, 0);
        
        assertTrue(p0.compareTo(p1) == 0);
    }
    
    @Test
    public void comparatorTest() {
        // p1 < p2
        Point p0 = new Point(0, 0); 
        Point p1 = new Point(-1, 0); 
        Point p2 = new Point(-1, 1); 
        
        assertEquals(-1, p0.SLOPE_ORDER.compare(p1, p2));
        
        // p1 > p2
        p1 = new Point(-1, 1); 
        p2 = new Point(-1, 0); 
        
        assertEquals(1, p0.SLOPE_ORDER.compare(p1, p2));
        
        // p0 < p2 = p1
        p1 = new Point(-1, 1); 
        p2 = new Point(-2, 2); 
        
        assertEquals(-1, p0.SLOPE_ORDER.compare(p1, p2));
    }
    
    @Test
    public void comparatorTwoHorizontalPoints() {
        // p1 < p2
        Point p0 = new Point(0, 0); 
        Point p1 = new Point(-1, 0); 
        Point p2 = new Point(-2, 0); 
        
        assertEquals(1, p0.SLOPE_ORDER.compare(p1, p2));
    }
    
    @Test
    public void comparatorTwoVerticalPoints() {
        // p1 < p2
        Point p0 = new Point(0, 0); 
        Point p1 = new Point(0, 1); 
        Point p2 = new Point(0, 2); 
        
        assertEquals(-1, p0.SLOPE_ORDER.compare(p1, p2));
    }
}
