package agh.po.lab5;

import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import agh.po.lab3.OptionsParser;
import agh.po.lab4.IWorldMap;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class UnboundedMapTest {
    Animal[] testSubject;
    List<Rock> testObstacle;
    IWorldMap map;

    @Before
    public void init() {
        testObstacle = new LinkedList<>();
        testObstacle.add(new Rock(new Vector2d(2,2)));
        testObstacle.add(new Rock(new Vector2d(-1,-1)));

        map = new UnboundedMap(testObstacle);

        testSubject = new Animal[2];
        testSubject[0] = new Animal(map, new Vector2d(3,4));
        testSubject[1] = new Animal(map, new Vector2d(0,-2));

        map.place(testSubject[0]);
        map.place(testSubject[1]);
    }

    @Test
    public void objectAtTest() {
        assertEquals(testSubject[0], map.objectAt(new Vector2d(3,4)));
        assertEquals(testSubject[1], map.objectAt(new Vector2d(0,-2)));

        assertTrue(map.objectAt(new Vector2d(2,2)) instanceof Rock);
        assertTrue(map.objectAt(new Vector2d(-1,-1)) instanceof Rock);

        assertNull(map.objectAt(new Vector2d(5,6)));
    }

    @Test
    public void canMoveToTest() {
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(3,4)));
        assertTrue(map.canMoveTo(new Vector2d(0,4)));
    }

    @Test
    public void integrationTest() {
        assertEquals(new Vector2d(-1,-2), map.getMaxLowerLeft());
        assertEquals(new Vector2d(3,4), map.getMaxUpperRight());

        assertFalse(map.place(new Animal(map, new Vector2d(2,2))));

        map.run(OptionsParser.parse(new String[]{
                "f", "f",
                "r", "l",
                "f", "f"
        }));

        assertEquals(new Vector2d(4,5), map.getMaxUpperRight());
        assertEquals(new Vector2d(0,-1), testSubject[1].getPosition());

        map.run(OptionsParser.parse(new String[]{
                "r", "l",
                "f", "l",
                "f", "l",
                "f", "l",
                "f", "l",
                "f", "l",
                "f", "l",
                "r", "l",
                "f", "l",
                "f", "l",
                "f", "l",
                "f", "l",
                "f", "l",
        }));

        assertEquals(new Vector2d(2,2), map.getMaxUpperRight());
        assertEquals(new Vector2d(1,-1), testSubject[0].getPosition());
    }
}