package agh.po.lab5;

import agh.po.lab2.MoveDirection;
import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GrassFieldTest {
    private GrassField testMap;
    private Animal[] testSubject;

    @Before
    public void init(){
        testMap = new GrassField(0);
        testSubject = new Animal[3];
        testSubject[0] = new Animal(testMap, new Vector2d(2,1));
        testSubject[1] = new Animal(testMap, new Vector2d(-10, 5));
        testSubject[2] = new Animal(testMap, new Vector2d(2, 3));
        testMap.place(testSubject[0]);
        testMap.place(testSubject[1]);
        testMap.place(testSubject[2]);
    }

    @Test
    public void canMoveTo() {
        assertTrue(testMap.canMoveTo(new Vector2d(2,-1)));
        assertTrue(testMap.canMoveTo(new Vector2d(0,0)));
        assertFalse(testMap.canMoveTo(new Vector2d(2,3)));
    }

    @Test
    public void getMaxLowerLeft() {
        assertEquals(new Vector2d(-10, 1), testMap.getMaxLowerLeft());
        testSubject[1].move(MoveDirection.LEFT);
        testSubject[1].move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(-11, 1), testMap.getMaxLowerLeft());
        testSubject[1].move(MoveDirection.LEFT);
        testSubject[1].move(MoveDirection.FORWARD);
        testSubject[1].move(MoveDirection.FORWARD);
        testSubject[1].move(MoveDirection.FORWARD);
        testSubject[1].move(MoveDirection.FORWARD);
        testSubject[1].move(MoveDirection.FORWARD);
        testSubject[1].move(MoveDirection.FORWARD);
        testSubject[1].move(MoveDirection.FORWARD);
        testSubject[1].move(MoveDirection.LEFT);
        testSubject[1].move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(-10, -2), testMap.getMaxLowerLeft());
    }

    @Test
    public void getMaxUpperRight() {
        assertEquals(new Vector2d(2,5), testMap.getMaxUpperRight());
        testSubject[2].move(MoveDirection.RIGHT);
        testSubject[2].move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3,5), testMap.getMaxUpperRight());
        testSubject[1].move(MoveDirection.BACKWARD);
        testSubject[1].move(MoveDirection.BACKWARD);
        testSubject[1].move(MoveDirection.BACKWARD);
        testSubject[1].move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(3,3), testMap.getMaxUpperRight());
    }

    @Test
    public void isOccupied() {
        assertTrue(testMap.isOccupied(new Vector2d(2,1)));
        assertFalse(testMap.isOccupied(new Vector2d(4,1)));
        assertTrue(testMap.isOccupied(new Vector2d(2,-1)));
    }

    @Test
    public void objectAt() {
        assertTrue(testMap.objectAt(new Vector2d(-10,5)) instanceof Animal);
        assertTrue(testMap.objectAt(new Vector2d(2,-1)) instanceof Grass);
        assertNull(testMap.objectAt(new Vector2d(4,1)));
        assertNull(testMap.objectAt(new Vector2d(-1,1)));
    }
}