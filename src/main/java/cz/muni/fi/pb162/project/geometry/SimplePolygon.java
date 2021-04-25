package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;
/**
 * @author Petr Urbanek
 */
public abstract class SimplePolygon implements Polygon{

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
