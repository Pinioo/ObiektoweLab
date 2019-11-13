package agh.po.lab7;

import agh.po.lab2.Vector2d;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangedObserver {
    SortedSet<Vector2d> sortedByX = new TreeSet<>((Vector2d ls, Vector2d rs) -> {
        if(ls.getX() < rs.getX()) return -1;
        if(ls.getX() > rs.getX()) return 1;
        if(ls.getY() < rs.getY()) return -1;
        if(ls.getY() > rs.getY()) return 1;
        return 0;
    });

    SortedSet<Vector2d> sortedByY = new TreeSet<>((Vector2d ls, Vector2d rs) -> {
        if(ls.getY() < rs.getY()) return -1;
        if(ls.getY() > rs.getY()) return 1;
        if(ls.getX() < rs.getX()) return -1;
        if(ls.getX() > rs.getX()) return 1;
        return 0;
    });

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
    }
}
