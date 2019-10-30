package agh.po.lab5;

import agh.po.lab2.Vector2d;

public class Rock {
    private Vector2d position;

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
