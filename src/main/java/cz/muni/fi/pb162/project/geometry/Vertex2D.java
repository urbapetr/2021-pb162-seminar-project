package cz.muni.fi.pb162.project.geometry;

/**
 * Create Vertex with x and y coordinate
 * @author Petr Urbanek
 */
public class Vertex2D implements Comparable<Vertex2D>{
    private final double x;
    private final double y;

    /**
     * Create Vertex object
     * @param x is coordinate x
     * @param y is coordinate y
     */
    public Vertex2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return x value
     */
    public double getX() {
        return x;
    }

    /**
     * @return y value
     */
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    /**
     * Create middle of Vertex with another vertex
     * @param vertex second vertex
     * @return vertex in the middle
     */
    public Vertex2D createMiddle(Vertex2D vertex) {
        double newX = (vertex.getX() + x) / 2;
        double newY = (vertex.getY() + y) / 2;
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
        return Math.sqrt(Math.pow(x - vertex.getX(), 2) + Math.pow(y - vertex.getY(), 2));
    }

    /**
     * Check if two Vertexes have same coordinates
     * @param vertex compared vertex
     * @return true if the have same coordinates, false otherwise
     */
    @Override
    public boolean equals(Object vertex){
        if (vertex == null) {
            return false;
        }
        if (getClass() != vertex.getClass()) {
            return false;
        }
        return ((Double.compare(x, ((Vertex2D) vertex).getX()) == 0)
                && (Double.compare(y, ((Vertex2D) vertex).getY()) == 0));
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 7 * result + (int) (Double.doubleToLongBits(x));
        result = 7 * result + (int) (Double.doubleToLongBits(y));
        return result;
    }

    @Override
    public int compareTo(Vertex2D vertex) {
        int xCmp = Double.compare(getX(), vertex.getX());
        if (xCmp != 0) {
            return xCmp;
        }
        return Double.compare(getY(), vertex.getY());
    }
}
