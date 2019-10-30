package agh.po.lab5;

import agh.po.lab2.MapDirection;
import agh.po.lab2.MoveDirection;
import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import agh.po.lab4.IWorldMap;
import agh.po.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected LinkedList<Animal> animalsList = new LinkedList<>();

    public HashMap<Vector2d, IMapElement> elementsHashMap = new HashMap<>();

    @Override
    public void animalMoved(Animal an, Vector2d oldPosition, Vector2d newPosition){
        elementsHashMap.remove(oldPosition);
        elementsHashMap.put(newPosition, an);
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())) {
            this.animalsList.add(animal);
            this.elementsHashMap.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
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