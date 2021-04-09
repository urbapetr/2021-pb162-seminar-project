package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * @author Petr Urbanek
 */
public class Gauger {

    /**
     * print measurement of given Measurable object
     * @param shape Measurable object
     */
    public static void printMeasurement(Measurable shape){
        System.out.println("Width: " + shape.getWidth());
        System.out.println("Height: " + shape.getHeight());
    }

    /**
     * print triangle measurement
     * @param triangle which will be printed
     */
    public static void printMeasurement(Triangle triangle){
        System.out.println(triangle.toString());
        Measurable shape = new Triangle(triangle.getVertex(0),
                triangle.getVertex(1),
                triangle.getVertex(2));
        printMeasurement(shape);
    }
}
