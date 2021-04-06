package cz.muni.fi.pb162.project.geometry;

/**
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

    /**
     * Return one Vetrex of square
     * @param index which vertex is wanted
     * @return wanted vertex, if index is out of range return null
     */
    @Override
    public Vertex2D getVertex(int index){
        switch (index){
            case 0: return new Vertex2D(getCenter().getX()-(getRadius()), getCenter().getY());
            case 1: return new Vertex2D(getCenter().getX(), getCenter().getY()-(getRadius()));
            case 2: return new Vertex2D(getCenter().getX()+(getRadius()), getCenter().getY());
            case 3: return new Vertex2D(getCenter().getX(), getCenter().getY()+(getRadius()));
            default: return null;
        }
    }

    @Override
    public String toString(){
        return "Square: vertices=" + getVertex(0).toString() + " " +
                getVertex(1).toString() + " " +
                getVertex(2).toString() + " " +
                getVertex(3).toString();
    }
}
