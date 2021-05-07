package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.MissingVerticesException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class that store vertices in list
 * @author Petr Urbanek
 */
public class CollectionPolygon extends SimplePolygon {

    private final List<Vertex2D> collectionOfVertex;

    /**
     * Collection polygon constructor
     * @param array array of vertices
     * @throws IllegalArgumentException when null is occured
     */
    public CollectionPolygon(Vertex2D[] array) throws MissingVerticesException {
        super(array);
        collectionOfVertex = Arrays.asList(array.clone());
    }

    /**
     * Constructor of collection polygon
     * @param listOfVertices list of vertices
     */
    public CollectionPolygon(List<Vertex2D> listOfVertices) throws MissingVerticesException {
        super(listOfVertices.toArray());
        collectionOfVertex = List.copyOf(listOfVertices);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("negative index not possible");
        }
        return collectionOfVertex.get(index % getNumVertices());
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
        Vertex2D whichVertex = getVertex(0);
        for (int i = 1; i < getNumVertices(); i++){
            if (getVertex(i).getX() < whichVertex.getX()){
                whichVertex = getVertex(i);
            }
        }
        List<Vertex2D> newArray = new ArrayList<Vertex2D>(List.copyOf(collectionOfVertex));
        newArray.removeAll(Collections.singletonList(whichVertex));
        return new CollectionPolygon(newArray);
    }
}
