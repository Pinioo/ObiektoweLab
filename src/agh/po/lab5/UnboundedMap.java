package agh.po.lab5;

import agh.po.lab2.MoveDirection;
import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import agh.po.lab4.IWorldMap;

import java.util.LinkedList;
import java.util.List;

public class UnboundedMap implements IWorldMap {
    private List<Rock> rocksList = new LinkedList<>();
    private List<Animal> animalsList = new LinkedList<>();

    public UnboundedMap(List<Rock> rocks){
        for(Rock r : rocks){
            if(this.canMoveTo(r.getPosition())) {
                this.rocksList.add(r);
            }
        }
    }

    private Vector2d maxLowerLeft(){
        Vector2d tmp = null;
        if(!rocksList.isEmpty()) tmp = animalsList.get(0).getPosition();
        if(!animalsList.isEmpty()) tmp = animalsList.get(0).getPosition();
        for(Animal an : this.animalsList){

        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            this.animalsList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int animalsCount = this.animalsList.size();
        for(int i = 0; i < directions.length; ++i) {
            this.animalsList.get(i % animalsCount).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal an: this.animalsList){
            if(an.getPosition().equals(position))
                return an;
        }
        for(Rock r: this.rocksList){
            if(r.getPosition().equals(position))
                return r;
        }
        return null;
    }

    @Override
    public String toString(){
        return "";
    }
}
