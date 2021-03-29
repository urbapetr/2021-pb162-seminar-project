package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * @author Petr Urbanek
 */
public class SimpleMath {

    public double minX(Triangle triangle){
        return Math.min(triangle.getVertex(2).getX(), Math.min(triangle.getVertex(1).getX(),triangle.getVertex(0).getX()));
    }

    public double minY(Triangle triangle){
        return Math.min(triangle.getVertex(2).getY(), Math.min(triangle.getVertex(1).getY(),triangle.getVertex(0).getY()));
    }

    public double maxX(Triangle triangle){
        return Math.max(triangle.getVertex(2).getX(), Math.max(triangle.getVertex(1).getX(),triangle.getVertex(0).getX()));
    }

    public double maxY(Triangle triangle){
        return Math.max(triangle.getVertex(2).getY(), Math.max(triangle.getVertex(1).getY(),triangle.getVertex(0).getY()));
    }
}
