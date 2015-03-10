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

}
