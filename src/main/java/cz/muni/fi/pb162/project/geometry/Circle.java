package cz.muni.fi.pb162.project.geometry;

/**
 * Create Circle with radius and center
 * @author Petr Urbanek
 */
public class Circle implements Measurable, Circular{
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
        this(new Vertex2D(0,0), 1);
    }

    @Override
    public double getRadius(){
        return radius;
    }

    @Override
    public Vertex2D getCenter(){
        return center;
    }

    @Override
    public String toString(){
        return "Circle: center=" + center.toString() + ", radius=" + radius;
    }

    @Override
    public double getWidth(){
        return 2 * radius;
    }

    @Override
    public double getHeight(){
        return 2 * radius;
    }
}
