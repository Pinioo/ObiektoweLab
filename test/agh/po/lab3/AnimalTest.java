package agh.po.lab3;

import agh.po.lab2.MoveDirection;
import agh.po.lab2.Vector2d;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    private Animal testSubject;

    @Before
    public void beforeTest(){
        testSubject = new Animal();
    }

    @Test
    public void testToString() {
        assertEquals("Position: (2,2), Direction: Północ", testSubject.toString());
    }

    //Assuming that Animal.toString() method is correct
    @Test
    public void testMove() {
        testSubject.move(MoveDirection.RIGHT);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.LEFT);
        testSubject.move(MoveDirection.BACKWARD);
        assertEquals("Position: (3,1), Direction: Północ", testSubject.toString());
    }

    @Test
    public void testMoveUpperRight() {
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.RIGHT);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        assertEquals("Position: (4,4), Direction: Wschód", testSubject.toString());
    }

    @Test
    public void testMoveLowerLeft() {
        testSubject.move(MoveDirection.BACKWARD);
        testSubject.move(MoveDirection.BACKWARD);
        testSubject.move(MoveDirection.BACKWARD);
        testSubject.move(MoveDirection.LEFT);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        assertEquals("Position: (0,0), Direction: Zachód", testSubject.toString());
    }

    @Test
    public void testMoveLowerRight() {
        testSubject.move(MoveDirection.BACKWARD);
        testSubject.move(MoveDirection.BACKWARD);
        testSubject.move(MoveDirection.BACKWARD);
        testSubject.move(MoveDirection.RIGHT);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        assertEquals("Position: (4,0), Direction: Wschód", testSubject.toString());
    }

    @Test
    public void testMoveUpperLeft() {
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.LEFT);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        testSubject.move(MoveDirection.FORWARD);
        assertEquals("Position: (0,4), Direction: Zachód", testSubject.toString());
    }
}