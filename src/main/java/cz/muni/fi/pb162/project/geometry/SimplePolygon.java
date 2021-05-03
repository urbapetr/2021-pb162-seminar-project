package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * @author Petr Urbanek
 */
public abstract class SimplePolygon implements Polygon{

    /**
     * Simple polygon constructor
     * @param vertices of our polygon
     * @throws IllegalArgumentException when null is occured
     */
    public SimplePolygon(Object[] vertices) throws IllegalArgumentException{
        if (vertices == null){
            throw new IllegalArgumentException("null array");
        }
        for (Object vertex2D : vertices) {
            if (vertex2D == null) {
                throw new IllegalArgumentException("null in array");
            }
        }
    }

    @Override
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }

    @Override
    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

    @Override
    public String toString(){
        String myString = "Polygon: vertices =";
        for (int i = 0; i < getNumVertices(); i++){
            myString = myString.concat(" " + getVertex(i));
        }
        return myString;
    }
}
