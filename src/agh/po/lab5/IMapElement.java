package agh.po.lab5;

import agh.po.lab2.Vector2d;
import agh.po.lab4.IWorldMap;

public interface IMapElement {
    Vector2d position = null;
    IWorldMap map = null;
    Vector2d getPosition();
}
