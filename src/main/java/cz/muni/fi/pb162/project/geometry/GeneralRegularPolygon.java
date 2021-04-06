package cz.muni.fi.pb162.project.geometry;

import static cz.muni.fi.pb162.project.geometry.Color.BLACK;

/**
 * @author Petr Urbanek
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored{

    private Vertex2D center;
    private int numberOfEdges;
    private double circumCircle;
    private Color color;

    /**
     * GeneralRegularPolygon class creator
     * @param center of new polygon
     * @param numberOfEdges how many edges will polygon have
     * @param circumCircle radius of circle around our palygon
     */
    public GeneralRegularPolygon(Vertex2D center, int numberOfEdges,double circumCircle){
        this.center = center;
        this.numberOfEdges = numberOfEdges;
        this.circumCircle = circumCircle;
        setColor(BLACK);
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public int getNumEdges(){
        return numberOfEdges;
    }

    public double getEdgeLength(){
        return 2 * getRadius() * Math.sin(Math.PI / numberOfEdges);
    }

    /**
     * get one Vertex
     * @param index which index is wanted
     * @return wanted vertex
     */
    public Vertex2D getVertex(int index){
        double x = getCenter().getX() - getRadius() * Math.cos(index * 2 * Math.PI / numberOfEdges);
        double y = getCenter().getY() - getRadius() * Math.sin(index * 2 * Math.PI / numberOfEdges);
        return new Vertex2D(x,y);
    }

    public Vertex2D getCenter(){
        return center;
    }

    public double getRadius(){
        return circumCircle;
    }

    public double getWidth(){
        return 2 * circumCircle;
    }

    public double getHeight(){
        return  2 * circumCircle;
    }

    @Override
    public String toString(){
        return numberOfEdges + "-gon: center=" + getCenter() + ", radius=" + getRadius() + ", color=" + getColor();
    }
}
