package cz.muni.fi.pb162.project.geometry;

import static cz.muni.fi.pb162.project.geometry.Color.RED;

/**
 * Create Circle with radius and center
 * @author Petr Urbanek
 */
public class Circle extends GeneralRegularPolygon implements Measurable, Circular{

    /**
     * Circle creator
     * @param givenCenter new center of our circle
     * @param givenRadius new radius of our circle
     */
    public Circle(Vertex2D givenCenter, double givenRadius){
        super(givenCenter, Integer.MAX_VALUE, givenRadius);
        setColor(RED);
    }

    /**
     * Create Circle without arguments
     */
    public Circle(){
        this(new Vertex2D(0,0), 1);
    }

    /**
     * what is center and radius
     * @return connected center and radius in string
     */
    @Override
    public String toString(){
        return "Circle: center=" + getCenter().toString() + ", radius=" + getRadius();
    }

    @Override
    public double getEdgeLength() {
        return 0;
    }
}
