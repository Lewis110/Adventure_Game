package org.example;

enum MOVES {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    QUIT
}


public class Player implements ScreenLayer{
    public Point coordinates = new Point(7, 20);
    public static final Character ID = '@';

    public Player() {
    }

    public Character getID() {
        return ID;
    }
    //do hardcode location first, maybe change after!

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Character[][] coordinates) {
        //NOT IMPLEMENTED YET   ^ not right I think

    }
    public int getX(Point location) {
        return location.x;
    }

    public int getY(Point location){
        return location.y;
    }

    public Character[][] getLayer() {
        Character[][] layer = new Character[15][41];
        layer[coordinates.x][coordinates.y] = ID;
        return layer;
    }
    public int getX() {
        return this.coordinates.x;
    }

    public int getY() {
        return this.coordinates.y;
    }
}
