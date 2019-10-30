package agh.po.lab3;

import agh.po.lab2.*;
import agh.po.lab4.*;
import agh.po.lab5.AbstractWorldMap;
import agh.po.lab5.Rock;
import agh.po.lab5.UnboundedMap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class AnimalWorld {

    public static void main(String[] args) {
        IWorldMap map;
        MoveDirection[] directions = new OptionsParser().parse(args);

        /*
        map = new RectangularMap(10, 5);
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map);
        */

        LinkedList<Rock> examples = new LinkedList<>();
        Random rand = new Random();
        for(int i = 0; i < 10; ++i){
            examples.add(new Rock(new Vector2d(rand.nextInt(40) - 20, rand.nextInt(40) - 20)));
        }
        map = new UnboundedMap(examples);
        map.place(new Animal(map,new Vector2d(3,4)));
        map.place(new Animal(map,new Vector2d(2,1)));
        map.run(directions);
        System.out.println(map);
    }
}
