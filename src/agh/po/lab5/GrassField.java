package agh.po.lab5;

import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import agh.po.lab4.MapVisualizer;

import javax.swing.text.html.HTMLDocument;
import java.util.LinkedList;
import java.util.Set;

public class GrassField extends AbstractWorldMap {
    private int grassCount;

    public GrassField(int grassCount){
        this.grassCount = grassCount;
        for(int i = 0; i < grassCount; i++)
            this.addRandGrassInSquare();
    }

    public void addGrass(Grass toAdd) throws IllegalArgumentException{
        if(this.objectAt(toAdd.getPosition()) != null)
            throw new IllegalArgumentException("Grass cannot be placed at position " + toAdd.getPosition().toString());
        this.elementsHashMap.put(toAdd.getPosition(), toAdd);
    }

    public void addGrass(Vector2d pos) throws IllegalArgumentException{
        this.addGrass(new Grass(pos));
    }

    private void addRandGrassInSquare(){
        while(true){
            Grass newGrass = Grass.randGrassInSquare(0, (int)Math.sqrt(this.grassCount*10));
            if(this.objectAt(newGrass.getPosition()) == null) {
                addGrass(newGrass);
                break;
            }
        }
    }

    @Override
    public void animalMoved(Animal an, Vector2d oldPosition, Vector2d newPosition){
        Object objAtNewPosition = this.objectAt(newPosition);
        if(objAtNewPosition instanceof Grass){
            this.elementsHashMap.remove(((Grass) objAtNewPosition).getPosition());
            this.addRandGrassInSquare();
        }
        super.animalMoved(an, oldPosition, newPosition);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.objectAt(position) instanceof Animal);
    }

    @Override
    public Vector2d getMaxLowerLeft() {
        if(elementsHashMap.isEmpty())
            throw new IllegalStateException("Max lower left cannot be found; map is empty");
        Vector2d maxLowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(Vector2d key : this.elementsHashMap.keySet()){
            maxLowerLeft = key.lowerLeft(maxLowerLeft);
        }
        return maxLowerLeft;
    }

    @Override
    public Vector2d getMaxUpperRight() {
        if(elementsHashMap.isEmpty())
            throw new IllegalStateException("Max upper right cannot be found; map is empty");
        Vector2d maxUpperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Vector2d key : this.elementsHashMap.keySet()){
            maxUpperRight = key.upperRight(maxUpperRight);
        }
        return maxUpperRight;
    }
}
