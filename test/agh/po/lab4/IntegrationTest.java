package agh.po.lab4;

import agh.po.lab2.MapDirection;
import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import agh.po.lab3.OptionsParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {
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
    public void integrationTest(){
        map.run(OptionsParser.parse(new String[]{
                "f","r","r",
                "f","r","f",
                "f","r","f",
                "f","r","f"
        }));
        assertEquals(new Vector2d(2,3), testSubject1.getPosition());
        assertEquals(new Vector2d(2,4), testSubject2.getPosition());
        assertEquals(new Vector2d(9,4), testSubject3.getPosition());

        assertEquals(testSubject1, map.objectAt(new Vector2d(2,3)));
        assertEquals(testSubject2, map.objectAt(new Vector2d(2,4)));
        assertEquals(testSubject3, map.objectAt(new Vector2d(9,4)));

        assertEquals(MapDirection.NORTH, testSubject1.getDirection());
        assertEquals(MapDirection.NORTH, testSubject2.getDirection());
        assertEquals(MapDirection.EAST, testSubject3.getDirection());
    }
}
