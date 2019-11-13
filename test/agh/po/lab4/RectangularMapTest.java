package agh.po.lab4;

import agh.po.lab2.MapDirection;
import agh.po.lab2.MoveDirection;
import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import agh.po.lab3.OptionsParser;
import org.junit.Before;
import org.junit.Test;

import static agh.po.lab2.MoveDirection.FORWARD;
import static agh.po.lab2.MoveDirection.RIGHT;
import static agh.po.lab2.MoveDirection.LEFT;
import static agh.po.lab2.MoveDirection.BACKWARD;
import static org.junit.Assert.*;

public class RectangularMapTest {
    RectangularMap map;
    Animal testSubject1;
    Animal testSubject2;
    Animal testSubject3;

    @Before
    public void init() {
        map = new RectangularMap(10,10);
        testSubject1 = new Animal(map, new Vector2d(2,2));
        testSubject2 = new Animal(map, new Vector2d(2, 4));
        testSubject3 = new Animal(map, new Vector2d(8,4));

        map.place(testSubject1);
        map.place(testSubject2);
        map.place(testSubject3);
    }

    @Test
    public void canMoveTo() {
        assertFalse(map.canMoveTo(new Vector2d(11,4)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.canMoveTo(new Vector2d(0, 5)));
    }

    @Test
    public void place() {
        map.place(new Animal(map, new Vector2d(0,5)));
        assertTrue(map.isOccupied(new Vector2d(0,5)));
    }

    @Test
    public void run() {
        map.run(
                new MoveDirection[]{
                        FORWARD, RIGHT, RIGHT,
                        FORWARD, RIGHT, FORWARD,
                        FORWARD, RIGHT, FORWARD,
                        FORWARD, FORWARD, FORWARD,
                        LEFT, FORWARD
                }
        );
        assertEquals(new Vector2d(2,3), testSubject1.getPosition());
        assertEquals(new Vector2d(0,4), testSubject2.getPosition());
        assertEquals(new Vector2d(9,4), testSubject3.getPosition());

        assertEquals(MapDirection.WEST, testSubject1.getDirection());
        assertEquals(MapDirection.WEST, testSubject2.getDirection());
        assertEquals(MapDirection.EAST, testSubject3.getDirection());
    }

    @Test
    public void isOccupied() {
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(4,1)));
        assertFalse(map.isOccupied(new Vector2d(-2,1)));
    }

    @Test
    public void objectAt() {
        assertEquals(testSubject1, map.objectAt(new Vector2d(2,2)));
        assertNull(map.objectAt(new Vector2d(4,1)));
        assertNull(map.objectAt(new Vector2d(-1,1)));
    }
}