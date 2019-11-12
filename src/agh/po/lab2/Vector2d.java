package agh.po.lab2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Vector2d {
    final public int x;
    final public int y;

    static final private Random rand = new Random();

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean precedes(Vector2d other){
        if(this.x <= other.x && this.y <= other.y)
            return true;
        else
            return false;
    }

    public boolean follows(Vector2d other){
        if(this.x >= other.x && this.y >= other.y)
            return true;
        else
            return false;
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    static public Vector2d randInSquare(int from, int to){
        int x = from + rand.nextInt(to - from);
        int y = from + rand.nextInt(to - from);
        return new Vector2d(x, y);
    }

    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        return other instanceof Vector2d && this.x == ((Vector2d) other).x && this.y == ((Vector2d) other).y;
}

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public int hashCode() {
        int tmp = (y +  ((x+1)/2));
        return x + (tmp * tmp);
    }
}
