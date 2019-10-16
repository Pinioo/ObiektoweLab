package agh.po.lab3;

import agh.po.lab2.MoveDirection;
import java.util.Arrays;

public class AnimalWorld {
    public static void main(String[] args) {
        Animal an = new Animal();
        an.move(MoveDirection.RIGHT);
        an.move(MoveDirection.FORWARD);
        an.move(MoveDirection.FORWARD);
        an.move(MoveDirection.FORWARD);
        System.out.println(an);
        System.out.println(OptionsParser.parse(new String[]{"f", "right", "left", "b", "k", "niewiem"}));
    }
}
