import org.junit.Test;
import agh.po.lab2.*;

import static org.junit.Assert.*;

public class Vector2dTest {

    private Vector2d upperLeft = new Vector2d(-1, 1);
    private Vector2d upperRight = new Vector2d(1, 1);
    private Vector2d lowerRight = new Vector2d(1, -1);
    private Vector2d lowerLeft = new Vector2d(-1, -1);

    @Test
    public void testPrecedes(){
        assertTrue(lowerLeft.precedes(upperRight));
        assertTrue(upperLeft.precedes(upperRight));
        assertTrue(lowerRight.precedes(upperRight));
        assertTrue(upperRight.precedes(upperRight));
        assertFalse(upperRight.precedes(lowerLeft));
        assertFalse(upperRight.precedes(upperLeft));
        assertFalse(upperRight.precedes(lowerRight));
    }

    @Test
    public void testFollows(){
        assertTrue(lowerRight.follows(lowerLeft));
        assertTrue(lowerRight.follows(lowerLeft));
        assertTrue(upperRight.follows(lowerLeft));
        assertTrue(upperRight.follows(upperRight));
        assertFalse(upperLeft.follows(upperRight));
        assertFalse(lowerLeft.follows(upperRight));
        assertFalse(lowerRight.follows(upperRight));
    }

    @Test
    public void testLowerLeft(){
        assertEquals(this.lowerLeft, lowerRight.lowerLeft(upperLeft));
        assertEquals(this.lowerLeft, lowerRight.lowerLeft(lowerLeft));
        assertEquals(this.lowerLeft, upperLeft.lowerLeft(lowerLeft));
    }

    @Test
    public void testUpperRight(){
        assertEquals(this.upperRight, lowerRight.upperRight(upperLeft));
        assertEquals(this.upperRight, upperRight.upperRight(upperLeft));
        assertEquals(this.upperRight, upperRight.upperRight(lowerRight));
    }

    @Test
    public void testAdd(){
        assertEquals(new Vector2d(0,0), lowerLeft.add(upperRight));
        assertEquals(new Vector2d(2,0), upperRight.add(lowerRight));
    }

    @Test
    public void testSubtract(){
        assertEquals(new Vector2d(-2,-2), lowerLeft.subtract(upperRight));
        assertEquals(new Vector2d(0,2), upperRight.subtract(lowerRight));
    }

    @Test
    public void testOpposite(){
        assertEquals(lowerLeft, upperRight.opposite());
        assertEquals(upperLeft, lowerRight.opposite());
    }

    @Test
    public void testToString() {
        assertEquals("(1,1)", upperRight.toString());
        assertEquals("(-1,1)", upperLeft.toString());
    }
}