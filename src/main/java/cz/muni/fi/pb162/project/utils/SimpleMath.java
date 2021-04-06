package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * retrun min and max coordinate
 * @author Petr Urbanek
 */
public class SimpleMath {

    /**
     * smallest x coordinate
     * @param triangle where are we searching min x
     * @return minimum x
     */
    public static double minX(Triangle triangle){
        return Math.min(triangle.getVertex(2).getX(),
                Math.min(triangle.getVertex(1).getX(),triangle.getVertex(0).getX()));
    }

    /**
     * smallest y coordinate
     * @param triangle where are we searching min y
     * @return minimum y
     */
    public static double minY(Triangle triangle){
        return Math.min(triangle.getVertex(2).getY(),
                Math.min(triangle.getVertex(1).getY(),triangle.getVertex(0).getY()));
    }

    /**
     * biggest x coordinate
     * @param triangle where are we searching max x
     * @return maximum x
     */
    public static double maxX(Triangle triangle){
        return Math.max(triangle.getVertex(2).getX(),
                Math.max(triangle.getVertex(1).getX(),triangle.getVertex(0).getX()));
    }

    /**
     * biggest y coordinate
     * @param triangle where are we searching max y
     * @return maximum y
     */
    public static double maxY(Triangle triangle){
        return Math.max(triangle.getVertex(2).getY(),
                Math.max(triangle.getVertex(1).getY(),triangle.getVertex(0).getY()));
    }
}
