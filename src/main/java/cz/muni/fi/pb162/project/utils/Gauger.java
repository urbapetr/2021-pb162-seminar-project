package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * @author Petr Urbanek
 */
public class Gauger {

    public static void printMeasurement(Measurable shape){
        System.out.println("Width: " + shape.getWidth() + "\n");
        System.out.println("Height: " + shape.getHeight() + "\n");
    }

    public static void printMeasurement(Triangle triangle){
        System.out.println(triangle.toString());
        Measurable shape = new Triangle(triangle.getVertex(0),
                triangle.getVertex(1),
                triangle.getVertex(2));
        printMeasurement(shape);
    }
}
