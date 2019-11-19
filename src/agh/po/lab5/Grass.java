package agh.po.lab5;

import agh.po.lab2.Vector2d;
import agh.po.lab4.IWorldMap;
import agh.po.lab7.IPositionChangedObserver;

import java.util.LinkedList;

public class Grass implements IMapElement {
    private Vector2d position;

    public Grass(Vector2d initialPosition) {
        this.position = initialPosition;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    static protected Grass randGrassInSquare(int from, int to){
        return new Grass(Vector2d.randInSquare(from, to));
    }

    @Override
    public String toString(){
        return "*";
    }
}
