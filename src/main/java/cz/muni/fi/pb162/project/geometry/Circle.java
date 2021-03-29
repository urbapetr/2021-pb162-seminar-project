package cz.muni.fi.pb162.project.geometry;

/**
 * Create Circle with radius and center
 * @author Petr Urbanek
 */
public class Circle {
    private final Vertex2D center;
    private final double radius;

    /**
     * Circle creator
     * @param givenCenter new center of our circle
     * @param givenRadius new radius of our circle
     */
    public Circle(Vertex2D givenCenter, double givenRadius){
        center = givenCenter;
        radius = givenRadius;
    }

    /**
     * Create Circle without arguments
     */
    public Circle(){
        center = new Vertex2D(0,0);
        radius = 1;
    }

    /**
     * Whats the radius
     * @return radius of circle
     */
    public double getRadius(){
        return radius;
    }

    /**
     * Whats the center
     * @return center of circle
     */
    public Vertex2D getCenter(){
        return center;
    }

    /**
     * what is center and radius
     * @return connected center and radius in string
     */
    public String toString(){
        return "Circle: center=" + center.toString() + ", radius=" + radius;
    }
}
