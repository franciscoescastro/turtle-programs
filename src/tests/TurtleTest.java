package tests;

import edu.sdsu.Point;
import edu.sdsu.program.Turtle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurtleTest {
    private Turtle turtle;

    @Before
    public void setUp() {
        turtle = new Turtle();
    }

    @Test
    public void testMove() {
        turtle.move(10);
        Point expectedLocation = new Point(10.0, 0.0);
        assertEquals(expectedLocation.getX(), turtle.location().getX());
        assertEquals(expectedLocation.getY(), turtle.location().getY());
    }

    @Test
    public void testTurn() {
        turtle.turn(90);
        assertEquals(90, turtle.direction());

        turtle.turn(-30);
        assertEquals(60, turtle.direction());

        turtle.turn(75);
        assertEquals(135, turtle.direction());
    }

    @Test
    public void testPenUp() {
        turtle.penUp();
        assertTrue(turtle.isPenUp());
    }

    @Test
    public void testPenDown() {
        turtle.penDown();
        assertFalse(turtle.isPenUp());
    }

    @Test
    public void testIsPenUp() {
        turtle.penDown();
        assertFalse(turtle.isPenUp());

        turtle.penUp();
        assertTrue(turtle.isPenUp());
    }

    @Test
    public void testDirection() {
        assertEquals(0, turtle.direction());

        turtle.turn(-270);
        assertEquals(-270, turtle.direction());
    }

    @Test
    public void testLocation() {
        Point expectedLocation = new Point(0.0, 0.0);
        assertEquals(expectedLocation.getX(), turtle.location().getX());
        assertEquals(expectedLocation.getY(), turtle.location().getY());

        turtle.move(15);
        turtle.turn(-90);
        turtle.move(20);
        expectedLocation = new Point(15.0, -20.0);
        assertEquals(expectedLocation.getX(), turtle.location().getX());
        assertEquals(expectedLocation.getY(), turtle.location().getY());
    }
}
