package agh.po.lab5;

import agh.po.lab2.Vector2d;
import agh.po.lab4.IWorldMap;

public class Rock implements IMapElement {
    private Vector2d position;
    private IWorldMap map;

    public Rock(Vector2d initialPosition){
        this.position = initialPosition;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    @Override
    public String toString(){
        return "r";
    }
}
