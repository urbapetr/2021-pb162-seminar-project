package cz.muni.fi.pb162.project.geometry;

/**
 * Crate square shape
 * @author Petr Urbanek
 */
public class Square extends GeneralRegularPolygon implements Circular {

    /**
     * Constructor with given center and diameter
     * @param center center of square
     * @param diameter of square
     */
    public Square(Vertex2D center, double diameter){
        super(center, 4, diameter/2);
    }

    /**
     * Constructor with given circular object
     * @param circular object which will tel us center and diameter
     */
    public Square(Circular circular){
        this(circular.getCenter(),2*circular.getRadius());
    }

    @Override
    public String toString(){
        return "Square: vertices=" + getVertex(0).toString() + " " +
                getVertex(1).toString() + " " +
                getVertex(2).toString() + " " +
                getVertex(3).toString();
    }
}
