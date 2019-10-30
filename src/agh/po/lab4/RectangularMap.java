package agh.po.lab4;

import agh.po.lab2.MapDirection;
import agh.po.lab2.MoveDirection;
import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private Vector2d maxUpperRight;
    private Vector2d maxLowerLeft;

    private List<Animal> animalsList = new LinkedList<>();

    public RectangularMap(int width, int height){
        this.maxUpperRight = new Vector2d(width - 1, height - 1);
        this.maxLowerLeft = new Vector2d(0,0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.follows(this.maxLowerLeft) && position.precedes(this.maxUpperRight) && !this.isOccupied(position)){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            this.animalsList.add(animal);
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
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal an : this.animalsList)
            if(position.equals(an.getPosition()))
                return an;
        return null;
    }

    @Override
    public String toString(){
        MapVisualizer visual = new MapVisualizer(this);
        return visual.draw(this.maxLowerLeft, this.maxUpperRight);
    }
}
