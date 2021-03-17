package cz.muni.fi.pb162.project.geometry;

/**
 * @author Petr Urbanek
 */
public class Vertex2D {
    private double xCoordinate;
    private double yCoordinate;
    public Vertex2D(double x, double y){
        setX(x);
        setY(y);
    }

    public Vertex2D(){
        this(0.0,0.0);
    }

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
    @Override
    public String toString() {
        return "[" + xCoordinate + ", " + yCoordinate + "]";
    }

    public Vertex2D createMiddle(Vertex2D vertex) {
        double newX = (vertex.getX() + xCoordinate) / 2;
        double newY = (vertex.getY() + yCoordinate) / 2;
        Vertex2D newVertex;
        newVertex = new Vertex2D(newX, newY);
        return newVertex;
    }
}
