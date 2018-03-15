package tests;

import edu.sdsu.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {
    @Test
    public void testConstructorPoint() {
        Point point = new Point();
        Double expectedDouble = new Double(0);
        assertEquals(expectedDouble, point.getX());
        assertEquals(expectedDouble, point.getY());
    }

    @Test
    public void testConstructorPointDoubleDouble() {
        Point point = new Point(2.2, 1.25);
        assertEquals(new Double(2.2), point.getX());
        assertEquals(new Double(1.25), point.getY());
    }

    @Test
    public void testUpdate() {
        Point point = new Point(2.2, 1.25);
        point.update(2.3, 2.75);
        assertEquals(new Double(4.5), point.getX());
        assertEquals(new Double(4), point.getY());

        point.update(0.0, -1.0);
        assertEquals(new Double(4.5), point.getX());
        assertEquals(new Double(3), point.getY());
    }
}
