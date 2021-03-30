package cz.muni.fi.pb162.project.geometry;

/**
 * @author Petr Urbanek
 */
public class Square implements Circular{

    private final Vertex2D center;
    private final double diameter;

    /**
     * Constructor with given center and diameter
     * @param center center of square
     * @param diameter of square
     */
    public Square(Vertex2D center, double diameter){
        this.center = center;
        this.diameter = diameter;
    }

    /**
     * Constructor with given circular object
     * @param circular object which will tel us center and diameter
     */
    public Square(Circular circular){
        this(circular.getCenter(),2*circular.getRadius());
    }

    @Override
    public Vertex2D getCenter(){
        return center;
    }

    @Override
    public double getRadius(){
        return diameter/2;
    }

    /**
     * Return one Vetrex of square
     * @param index which vertex is wanted
     * @return wanted vertex, if index is out of range return null
     */
    public Vertex2D getVertex(int index){
        switch (index){
            case 0: return new Vertex2D(center.getX()-(diameter/2), center.getY());
            case 1: return new Vertex2D(center.getX(), center.getY()-(diameter/2));
            case 2: return new Vertex2D(center.getX()+(diameter/2), center.getY());
            case 3: return new Vertex2D(center.getX(), center.getY()+(diameter/2));
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
