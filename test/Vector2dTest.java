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
        assertEquals(true, lowerLeft.precedes(upperRight));
        assertEquals(true, upperLeft.precedes(upperRight));
        assertEquals(true, lowerRight.precedes(upperRight));
        assertEquals(false, upperRight.precedes(lowerLeft));
        assertEquals(true, upperRight.precedes(upperRight));
    }

    @Test
    public void testFollows(){
        assertEquals(true, lowerRight.follows(lowerLeft));
        assertEquals(false, upperLeft.follows(upperRight));
        assertEquals(true, lowerRight.follows(lowerLeft));
        assertEquals(true, upperRight.follows(lowerLeft));
        assertEquals(true, upperRight.follows(upperRight));
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
        assertEquals("(1,2)", (new Vector2d(1,2)).toString());
    }
}