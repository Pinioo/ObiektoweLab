package agh.po.lab2;

import java.util.Map;

public enum MapDirection {
    NORTH(new Vector2d(0,1), "Północ", "^"),
    EAST(new Vector2d(1,0), "Wschód", ">"),
    SOUTH(new Vector2d(0, -1), "Południe", "v"),
    WEST(new Vector2d(-1, 0), "Zachód", "<");

    private Vector2d unitVector;
    private String stringForm;
    private String symbol;

    MapDirection(Vector2d unitVector, String stringForm, String symbol){
        this.unitVector = unitVector;
        this.stringForm = stringForm;
        this.symbol = symbol;
    }

    public MapDirection next(){
        return MapDirection.values()[(this.ordinal() + 1) % 4];
    }

    public MapDirection previous(){
        return MapDirection.values()[(this.ordinal() + 3) % 4];
    }

    public Vector2d toUnitVector(){
        return this.unitVector;
    }

    @Override
    public String toString(){
        return this.stringForm;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
