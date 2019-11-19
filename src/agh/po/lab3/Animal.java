package agh.po.lab3;
import agh.po.lab5.IMapElement;
import agh.po.lab2.*;
import agh.po.lab4.IWorldMap;
import agh.po.lab7.AbstractObservedMapElement;
import agh.po.lab7.IPositionChangedObserver;

import java.util.LinkedList;

public class Animal extends AbstractObservedMapElement {
    private MapDirection direction = MapDirection.NORTH;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.map = map;
    }

    public MapDirection getDirection(){
        return this.direction;
    }

    public void move(MoveDirection direction) throws IllegalArgumentException{
        Vector2d unitVector;
        switch(direction){
            case FORWARD: unitVector = this.direction.toUnitVector(); break;
            case BACKWARD: unitVector = this.direction.toUnitVector().opposite(); break;
            case LEFT: this.direction = this.direction.previous(); return;
            case RIGHT: this.direction = this.direction.next(); return;
            default: throw new NullPointerException("Null passed as a move function parameter");
        }

        Vector2d newPosition = this.position.add(unitVector);
        if(this.map.canMoveTo(newPosition)) {
            this.positionChanged(this.getPosition(), newPosition);
            this.position = newPosition;
        }
        else{
            throw new IllegalArgumentException("Animal cannot move to position " + this.position.toString());
        }
    }

    @Override
    public String toString(){
        return this.direction.getSymbol();
    }
}
