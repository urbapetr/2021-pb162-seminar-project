package cz.muni.fi.pb162.project.geometry;

/**
 * @author Petr Urbanek
 */
public class Square implements Circular{

    Vertex2D center;
    double diameter;

    public Square(Vertex2D center, double diameter){
        this.center = center;
        this.diameter = diameter;
    }

    public Square(Circular circular){
        new Square(circular.getCenter(),2*circular.getRadius());
    }

    @Override
    public Vertex2D getCenter(){
        return center;
    }

    @Override
    public double getRadius(){
        return diameter/2;
    }

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
