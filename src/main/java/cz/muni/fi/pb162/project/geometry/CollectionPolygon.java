package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Petr Urbanek
 */
public class CollectionPolygon extends SimplePolygon {

    private final List<Vertex2D> collectionOfVertex = new ArrayList<>();

    /**
     * Collection polygon constructor
     * @param array array of vertices
     */
    public CollectionPolygon(Vertex2D[] array) {
        super(array);
    }

    /**
     * Constructor of collection polygon
     * @param listOfVertices list of vertices
     */
    public CollectionPolygon(List<Vertex2D> listOfVertices) {
        super((Vertex2D[]) listOfVertices.toArray());
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("negative index not possible");
        }
        return collectionOfVertex.get(index);
    }

    @Override
    public int getNumVertices() {
        return collectionOfVertex.size();
    }

    @Override
    public boolean equals(Object collectionPolygon){
        if (collectionPolygon == null || (getClass() != collectionPolygon.getClass())) {
            return false;
        }
        CollectionPolygon cmpCollection = (CollectionPolygon) collectionPolygon;
        if (cmpCollection.getNumVertices() != getNumVertices()) {
            return false;
        }
        for (int i = 0; i < getNumVertices(); i++){
            if (!cmpCollection.getVertex(i).equals(collectionOfVertex.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 7 * result + (int) (Double.doubleToLongBits(getVertex(1).getX()));
        result = 7 * result + (int) (Double.doubleToLongBits(getVertex(1).getY()));
        return result;
    }

    /**
     * delete first vertice
     * @return same collection without first vertice
     */
    public CollectionPolygon withoutLeftmostVertices(){
        if (getNumVertices() <= 1) {
            return null;
        }
        Vertex2D[] newArray = new Vertex2D[getNumVertices()-1];
        for (int i = 0; i < getNumVertices(); i++){
            newArray[i] = getVertex(i+1);
        }
        return new CollectionPolygon(newArray);
    }
}
