package cz.muni.fi.pb162.project.geometry;

/**
 * Create Vertex with x and y coordinate
 * @author Petr Urbanek
 */
public class Vertex2D {
    private final double xCoordinate;
    private final double yCoordinate;

    /**
     * Create Vertex object
     * @param x is coordinate x
     * @param y is coordinate y
     */
    public Vertex2D(double x, double y){
        xCoordinate = x;
        yCoordinate = y;
    }

    /**
     * @return x value
     */
    public double getX() {
        return xCoordinate;
    }

    /**
     * @return y value
     */
    public double getY() {
        return yCoordinate;
    }

    @Override
    public String toString() {
        return "[" + xCoordinate + ", " + yCoordinate + "]";
    }

    /**
     * Create middle of Vertex with another vertex
     * @param vertex second vertex
     * @return vertex in the middle
     */
    public Vertex2D createMiddle(Vertex2D vertex) {
        double newX = (vertex.getX() + xCoordinate) / 2;
        double newY = (vertex.getY() + yCoordinate) / 2;
        Vertex2D newVertex;
        newVertex = new Vertex2D(newX, newY);
        return newVertex;
    }

    /**
     * Count distance between two Vertexes
     * @param vertex second vertex
     * @return distance
     */
    public double distance(Vertex2D vertex){
        if (vertex == null) {
            return -1.0;
        }
        double x = xCoordinate - vertex.getX();
        double y = yCoordinate - vertex.getY();
        return Math.sqrt(x*x+y*y);
    }
}
