package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Petr Urbanek
 */
public abstract class SimplePolygon implements Polygon{

    private final List<Vertex2D> collectionOfVertex = new ArrayList<>();

    /**
     * Simple polygon constructor
     * @param vertices of our polygon
     */
    public SimplePolygon(Vertex2D[] vertices) {
        if (vertices == null){
            throw new IllegalArgumentException("null array");
        }
        for (Vertex2D vertex2D : vertices) {
            if (vertex2D == null) {
                throw new IllegalArgumentException("null in array");
            }
            collectionOfVertex.add(vertex2D);
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
