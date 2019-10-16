package agh.po.lab3;
import agh.po.lab2.*;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    final private Vector2d lowerLeftMax = new Vector2d(0,0);
    final private Vector2d upperRightMax = new Vector2d(4,4);

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
        if(newPosition.follows(lowerLeftMax) && newPosition.precedes(upperRightMax)) {
            this.position = newPosition;
        }
    }

    @Override
    public String toString(){
        return String.format(
                "Position: %s, Direction: %s",
                position,
                direction
        );
    }


}
