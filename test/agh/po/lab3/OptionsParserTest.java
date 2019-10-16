package agh.po.lab3;

import agh.po.lab2.MoveDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptionsParserTest {
    @Test
    public void testParse(){
        assertArrayEquals(new MoveDirection[]{MoveDirection.FORWARD}, OptionsParser.parse(new String[]{"t", "gat", "f"}));
    }
}