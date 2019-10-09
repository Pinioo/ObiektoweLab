package agh.po.lab1;

public enum Direction{
    BACKWARD, FORWARD, LEFT, RIGHT;

    public static Direction fromString(String st){
        switch(st){
            case "f": return FORWARD;
            case "b": return BACKWARD;
            case "l": return LEFT;
            case "r": return RIGHT;
            default: return null;
        }
    }
}
