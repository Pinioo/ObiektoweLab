package agh.po.lab3;
import agh.po.lab5.IMapElement;
import agh.po.lab2.*;
import agh.po.lab4.IWorldMap;
import agh.po.lab7.IPositionChangedObserver;

import java.util.LinkedList;

public class Animal implements IMapElement {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap map;
    private LinkedList<IPositionChangedObserver> observersList = new LinkedList<>();

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
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

    public void addObserver(IPositionChangedObserver obs){
        this.observersList.add(obs);
    }

    public void removeObserver(IPositionChangedObserver obs){
        this.observersList.remove(obs);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangedObserver observer : observersList){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public Vector2d getPosition() {
        return this.position;
    }

    @Override
    public String toString(){
        return this.direction.getSymbol();
    }
}
