package agh.po.lab3;

import agh.po.lab2.*;
import agh.po.lab4.*;

import java.util.Arrays;

public class AnimalWorld {

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map);
    }
}
