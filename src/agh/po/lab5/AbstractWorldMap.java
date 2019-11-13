package agh.po.lab5;

import agh.po.lab2.MoveDirection;
import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import agh.po.lab4.IWorldMap;
import agh.po.lab4.MapVisualizer;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class AbstractWorldMap implements IWorldMap{
    LinkedList<Animal> animalsList = new LinkedList<>();

    HashMap<Vector2d, IMapElement> elementsHashMap = new HashMap<>();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement element = (IMapElement) this.objectAt(oldPosition);
        elementsHashMap.remove(oldPosition);
        elementsHashMap.put(newPosition, element);
    }

    @Override
    public void place(Animal animal) throws IllegalArgumentException {
        if(this.canMoveTo(animal.getPosition())) {
            this.animalsList.add(animal);
            this.elementsHashMap.put(animal.getPosition(), animal);
        }
        else
            throw new IllegalArgumentException("Animal cannot be placed at position " + animal.getPosition().toString());
    }

    @Override
    public void run(MoveDirection[] directions) throws IllegalArgumentException{
        int animalsCount = this.animalsList.size();
        for(int i = 0; i < directions.length; ++i){
            this.animalsList.get(i % animalsCount).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.elementsHashMap.get(position);
    }

    @Override
    public String toString(){
        MapVisualizer visual = new MapVisualizer(this);
        return visual.draw(this.getMaxLowerLeft(), this.getMaxUpperRight());
    }
}
