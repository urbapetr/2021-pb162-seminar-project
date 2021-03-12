package cz.muni.fi.pb162.project.geometry;

/**
 * @author Petr Urbanek
 */

public class Vertex2D {

    private double xCoordinate, yCoordinate;

    /**
     * Get the X value
     * @return x value
     */
    public double getX() {
        return xCoordinate;
    }

    /**
     * Sets the x value
     * @param x new value of x
     */
    public void setX(double x) {
        xCoordinate = x;
    }

    /**
     * Get Y value
     * @return y value
     */
    public double getY() {
        return yCoordinate;
    }

    /**
     * Sets Y value
     * @param y new value of y
     */
    public void setY(double y) {
        yCoordinate = y;
    }

    /**
     * Return the coordinates
     * @return coordinates
     */
    public String getInfo() {
        return "[" + xCoordinate + ", " + yCoordinate + "]";
    }

    /**
     * Sum the coordinates
     * @return sum of coordinates
     */
    public double sumCoordinates() {
        return xCoordinate + yCoordinate;
    }

    /**
     * Move one vertex
     * @param vertex value
     */
    public void move(Vertex2D vertex) {
        xCoordinate = xCoordinate + vertex.getX();
        yCoordinate = yCoordinate + vertex.getY();
    }
}
