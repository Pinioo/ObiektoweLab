package agh.po.lab7;

import agh.po.lab2.Vector2d;
import agh.po.lab5.IMapElement;

import java.util.LinkedList;

public abstract class AbstractObservedMapElement implements IMapElement {
    protected LinkedList<IPositionChangedObserver> observersList;
    protected Vector2d position;

    public AbstractObservedMapElement(Vector2d initialPosition){
        this.position = initialPosition;
        this.observersList = new LinkedList<>();
    }

    protected void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangedObserver observer : this.observersList){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public void addObserver(IPositionChangedObserver obs){
        this.observersList.add(obs);
    }

    public void removeObserver(IPositionChangedObserver obs){
        this.observersList.remove(obs);
    }

    @Override
    public Vector2d getPosition() {
        return this.position;
    }
}
