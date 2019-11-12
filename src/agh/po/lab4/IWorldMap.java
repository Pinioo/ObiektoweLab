package agh.po.lab4;

import agh.po.lab2.*;
import agh.po.lab3.*;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo
 *
 */
public interface IWorldMap {
    /**
     * Indicate if any object can move to the given position.
     *
     * @param position
     *            The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    boolean canMoveTo(Vector2d position);

    /**
     * Actions to take if any animal moves.
     *
     * @param (animal, oldPosition, newPosition)
     *            New position for animal.
     */
    void animalMoved(Animal animal, Vector2d oldPostition, Vector2d newPosition);

    /**
     * Place a animal on the map.
     *
     * @param animal
     *            The animal to place on the map.
     */
    void place(Animal animal);

    /**
     * Move the animal on the map according to the provided move directions. Every
     * n-th direction should be sent to the n-th animal on the map.
     *
     * @param directions
     *            Array of move directions.
     */
    void run(MoveDirection[] directions);

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position
     *            Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(Vector2d position);

    /**
     * Return an object at a given position.
     *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
    Vector2d getMaxLowerLeft();

    Vector2d getMaxUpperRight();

    Object objectAt(Vector2d position);
}