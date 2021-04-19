package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;

/**
 * retrun min and max coordinate
 * @author Petr Urbanek
 */
public class SimpleMath {

    /**
     * smallest x coordinate
     * @param polygon where are we searching min x
     * @return minimum x
     */
    public static double minX(Polygon polygon){
        if (polygon.getNumVertices() <= 0) {
            return 0;
        }
        double min = polygon.getVertex(0).getX();
        for (int i = 1; i <= polygon.getNumVertices(); i++){
            if (polygon.getVertex(i).getX() < min){
                min = polygon.getVertex(i).getX();
            }
        }
        return min;
    }

    /**
     * smallest y coordinate
     * @param polygon where are we searching min y
     * @return minimum y
     */
    public static double minY(Polygon polygon){
        if (polygon.getNumVertices() <= 0) {
            return 0;
        }
        double min = polygon.getVertex(0).getY();
        for (int i = 1; i <= polygon.getNumVertices(); i++){
            if (polygon.getVertex(i).getY() < min){
                min = polygon.getVertex(i).getY();
            }
        }
        return min;
    }

    /**
     * biggest x coordinate
     * @param polygon where are we searching max x
     * @return maximum x
     */
    public static double maxX(Polygon polygon){
        if (polygon.getNumVertices() <= 0) {
            return 0;
        }
        double max = polygon.getVertex(0).getX();
        for (int i = 1; i <= polygon.getNumVertices(); i++){
            if (polygon.getVertex(i).getX() > max){
                max = polygon.getVertex(i).getX();
            }
        }
        return max;
    }

    /**
     * biggest y coordinate
     * @param polygon where are we searching max y
     * @return maximum y
     */
    public static double maxY(Polygon polygon){
        if (polygon.getNumVertices() <= 0) {
            return 0;
        }
        double max = polygon.getVertex(0).getY();
        for (int i = 1; i <= polygon.getNumVertices(); i++){
            if (polygon.getVertex(i).getY() > max){
                max = polygon.getVertex(i).getY();
            }
        }
        return max;
    }
}
