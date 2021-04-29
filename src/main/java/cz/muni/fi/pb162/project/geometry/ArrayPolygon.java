package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;
/**
 * @author Petr Urbanek
 */
public class ArrayPolygon extends SimplePolygon{

    private final Vertex2D[] arrayOfVertices;

    /**
     * constructor of ArrayPolygon class
     * @param arrayOfVertices Vertexes witch will create polygon
     */
    public ArrayPolygon(Vertex2D[] arrayOfVertices){
        super(arrayOfVertices);
        /*if (arrayOfVertices == null || arrayOfVertices.length < 3) {
            throw new IllegalArgumentException("array has less than 3 Veticles");
        }
        for (int i = 0; i < arrayOfVertices.length; i++){
            if (arrayOfVertices[i] == null) {
                throw new IllegalArgumentException("one of the Verticles is null");
            }
        }
        this.arrayOfVertices = Arrays.copyOf(arrayOfVertices, arrayOfVertices.length);*/
    }

    /**
     * Get one of Vertexes
     * @param i which Vertex is wanted
     * @return wanted Vertex
     */
    public Vertex2D getVertex(int i){
        if (i < 0) {
            throw new IllegalArgumentException("negative index not possible");
        }
        return arrayOfVertices[i % getNumVertices()];
    }

    /**
     * Compare two arrays of polygon
     * @param arrayPolygon Compared array
     * @return true if they are same, otherwise false
     */
    @Override
    public boolean equals(Object arrayPolygon){
        if (arrayPolygon == null || (getClass() != arrayPolygon.getClass())) {
            return false;
        }
        ArrayPolygon cmpArray = (ArrayPolygon) arrayPolygon;
        if (cmpArray.getNumVertices() != arrayOfVertices.length) {
            return false;
        }
        for (int i = 0; i < arrayOfVertices.length; i++){
            if (!cmpArray.getVertex(i).equals(arrayOfVertices[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    /**
     * how many Vertexes polygon have
     * @return number of Vertexes
     */
    public int getNumVertices(){
        return arrayOfVertices.length;
    }
}
