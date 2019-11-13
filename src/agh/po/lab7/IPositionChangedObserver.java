package agh.po.lab7;

import agh.po.lab2.Vector2d;

public interface IPositionChangedObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
