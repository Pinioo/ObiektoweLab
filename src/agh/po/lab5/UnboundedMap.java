package agh.po.lab5;

import agh.po.lab2.MoveDirection;
import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import agh.po.lab5.AbstractWorldMap;
import agh.po.lab4.IWorldMap;
import agh.po.lab4.MapVisualizer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    private List<Rock> rocksList = new LinkedList<>();

    public UnboundedMap(List<Rock> rocks){
        for(Rock r : rocks){
            if(this.canMoveTo(r.getPosition())) {
                this.rocksList.add(r);
                this.elementsHashMap.put(r.getPosition(), r);
            }
        }
    }

    public Vector2d getMaxLowerLeft(){
        Vector2d tmp = null;
        if(!rocksList.isEmpty()) tmp = animalsList.get(0).getPosition();
        if(!animalsList.isEmpty()) tmp = animalsList.get(0).getPosition();
        for(Animal an : this.animalsList){
            tmp = tmp.lowerLeft(an.getPosition());
        }
        for(Rock r : this.rocksList){
            tmp = tmp.lowerLeft(r.getPosition());
        }
        return tmp;
    }

    public Vector2d getMaxUpperRight(){
        Vector2d tmp = null;
        if(!rocksList.isEmpty()) tmp = animalsList.get(0).getPosition();
        if(!animalsList.isEmpty()) tmp = animalsList.get(0).getPosition();
        for(Animal an : this.animalsList){
            tmp = tmp.upperRight(an.getPosition());
        }
        for(Rock r : this.rocksList){
            tmp = tmp.upperRight(r.getPosition());
        }
        return tmp;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }
}
