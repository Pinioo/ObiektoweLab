package agh.po.lab5;

import agh.po.lab2.Vector2d;
import agh.po.lab3.Animal;
import agh.po.lab4.MapVisualizer;
import agh.po.lab7.MapBoundary;

import javax.swing.text.html.HTMLDocument;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Set;

public class GrassField extends AbstractWorldMap {
    private int grassCount;
    private MapBoundary boundary;

    public GrassField(int grassCount){
        this.boundary = new MapBoundary();
        this.grassCount = grassCount;
        for(int i = 0; i < grassCount; i++)
            this.addRandGrassInSquare();
        for(Vector2d pos : this.elementsHashMap.keySet()){
            this.boundary.place(pos);
        }
    }

    private void addRandGrassInSquare(){
        while(true){
            Grass newGrass = Grass.randGrassInSquare(0, (int)Math.sqrt(this.grassCount*10));
            if(this.objectAt(newGrass.getPosition()) == null) {
                this.elementsHashMap.put(newGrass.getPosition(), newGrass);
                this.boundary.place(newGrass.getPosition());
                newGrass.addObserver(this);
                newGrass.addObserver(this.boundary);
                break;
            }
        }
    }

    @Override
    public void place(Animal an){
        Object oldObject = objectAt(an.getPosition());
        if(oldObject instanceof Grass){
            Vector2d newGrassPosition = Vector2d.randInSquare(0, (int)Math.sqrt(this.grassCount*10));
            while(objectAt(newGrassPosition) != null)
                newGrassPosition = Vector2d.randInSquare(0, (int)Math.sqrt(this.grassCount*10));
            ((Grass)oldObject).changePosition(newGrassPosition);
        }
        this.boundary.place(an.getPosition());
        an.addObserver(this.boundary);
        an.addObserver(this);
        super.place(an);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Object objAtNewPosition = this.objectAt(newPosition);
        if(objAtNewPosition instanceof Grass){
            Vector2d newGrassPosition = Vector2d.randInSquare(0, (int)Math.sqrt(this.grassCount*10));
            while(objectAt(newGrassPosition) != null)
                newGrassPosition = Vector2d.randInSquare(0, (int)Math.sqrt(this.grassCount*10));
            ((Grass)objAtNewPosition).changePosition(newGrassPosition);
        }
        super.positionChanged(oldPosition, newPosition);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.objectAt(position) instanceof Animal);
    }

    @Override
    public Vector2d getMaxLowerLeft() {
        return this.boundary.lowerLeft();
    }

    @Override
    public Vector2d getMaxUpperRight() {
        return this.boundary.upperRight();
    }
}
