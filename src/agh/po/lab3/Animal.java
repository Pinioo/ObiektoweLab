package agh.po.lab3;
import agh.po.lab2.*;
import agh.po.lab4.IWorldMap;
import agh.po.lab4.RectangularMap;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map = new RectangularMap(4,4);

    public Animal(){
    }

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public MapDirection getDirection(){
        return this.direction;
    }

    public void move(MoveDirection direction){
        Vector2d unitVector;
        switch(direction){
            case FORWARD: unitVector = this.direction.toUnitVector(); break;
            case BACKWARD: unitVector = this.direction.toUnitVector().opposite(); break;
            case LEFT: this.direction = this.direction.previous(); return;
            case RIGHT: this.direction = this.direction.next(); return;
            default: return;
        }

        Vector2d newPosition = this.position.add(unitVector);
        if(this.map.canMoveTo(newPosition)) {
            this.position = newPosition;
        }
    }

    @Override
    public String toString(){
        return this.direction.getSymbol();
    }


}
