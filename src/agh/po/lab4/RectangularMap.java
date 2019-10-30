package agh.po.lab4;

import agh.po.lab2.Vector2d;
import agh.po.lab5.AbstractWorldMap;

public class RectangularMap extends AbstractWorldMap {
    private Vector2d maxUpperRight;
    private Vector2d maxLowerLeft;

    public RectangularMap(int width, int height){
        super();
        this.maxUpperRight = new Vector2d(width - 1, height - 1);
        this.maxLowerLeft = new Vector2d(0,0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position) && position.follows(this.maxLowerLeft) && position.precedes(this.maxUpperRight);
    }

    @Override
    public Vector2d getMaxLowerLeft() {
        return this.maxLowerLeft;
    }

    @Override
    public Vector2d getMaxUpperRight() {
        return this.maxUpperRight;
    }
}
