package agh.po.lab2;

public class World {
    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1,2);
        Vector2d position2 = new Vector2d(-2,1);

        MapDirection direction1 = MapDirection.SOUTH;
        MapDirection direction2 = MapDirection.WEST;

        System.out.println(direction1);
        System.out.println(direction1.next());
        System.out.println(direction1.previous());
        System.out.println(direction1.toUnitVector().add(direction2.toUnitVector()));
    }
}
