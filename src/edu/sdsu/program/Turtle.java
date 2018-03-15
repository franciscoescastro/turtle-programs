package edu.sdsu.program;

import edu.sdsu.Point;

import java.security.InvalidParameterException;

public class Turtle {
    private Point location;
    private int direction;
    private boolean penUpState;

    public Turtle() {
        location = new Point(0.0, 0.0);
        direction = 0;
        penUpState = true;
    }

    public void move(int distance) {
        if (distance < 0) {
            throw new InvalidParameterException();
        }

        Double radians = direction * Math.PI / 180;
        Double deltaX = Math.cos(radians) * distance;
        Double deltaY = Math.sin(radians) * distance;
        location.update(deltaX, deltaY);
    }

    public void turn(int degrees) {
        direction += degrees;
    }

    public void penUp() {
        penUpState = true;
    }

    public void penDown() {
        penUpState = false;
    }

    public boolean isPenUp() {
        return penUpState;
    }

    public int direction() {
        return direction;
    }

    public Point location() {
        return location;
    }
}