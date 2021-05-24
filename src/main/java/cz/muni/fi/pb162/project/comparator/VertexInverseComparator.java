package cz.muni.fi.pb162.project.comparator;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.util.Comparator;

/**
 * @author Petr Urbanek
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {

    @Override
    public int compare(Vertex2D v1, Vertex2D v2) {
        int xCmp = Double.compare(v2.getX(), v1.getX());
        if (xCmp != 0) {
            return xCmp;
        }
        return Double.compare(v2.getY(), v1.getY());
    }
}
