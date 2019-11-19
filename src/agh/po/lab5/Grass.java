package agh.po.lab5;

import agh.po.lab2.Vector2d;
import agh.po.lab4.IWorldMap;
import agh.po.lab7.AbstractObservedMapElement;
import agh.po.lab7.IPositionChangedObserver;

import java.util.LinkedList;
import java.util.List;

public class Grass extends AbstractObservedMapElement {
    public Grass(Vector2d initialPosition) {
        super(initialPosition);
    }

    public Vector2d getPosition() {
        return this.position;
    }

    static Grass randGrassInSquare(int from, int to){
        return new Grass(Vector2d.randInSquare(from, to));
    }

    public void changePosition(Vector2d newGrassPosition) {
        this.positionChanged(this.position, newGrassPosition);
        this.position = newGrassPosition;
    }

    @Override
    public String toString(){
        return "*";
    }
}
