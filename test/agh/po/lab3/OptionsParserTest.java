package agh.po.lab3;

import agh.po.lab2.MoveDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptionsParserTest {
    @Test
    public void testParse(){
        assertArrayEquals(
                new MoveDirection[]{
                        MoveDirection.FORWARD,
                        MoveDirection.BACKWARD,
                        MoveDirection.LEFT,
                        MoveDirection.RIGHT,
                        MoveDirection.RIGHT,
                        MoveDirection.LEFT},
                OptionsParser.parse(new String[]{"t", "gat", "f", "backward", "left", "r", "right", "l"})
        );
    }
}