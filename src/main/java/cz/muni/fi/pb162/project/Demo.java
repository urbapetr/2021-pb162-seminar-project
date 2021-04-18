package cz.muni.fi.pb162.project;

import cz.muni.fi.pb162.project.geometry.Circular;
import cz.muni.fi.pb162.project.geometry.Square;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import cz.muni.fi.pb162.project.geometry.RegularOctagon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * @author Petr Urbanek
 */
public class Demo {

    /**
     * start main function
     * @param args given argument
     */
    public static void main(String[] args) {

        Vertex2D center = new Vertex2D(0,0);
        double radius = 1;
        RegularOctagon octagon = new RegularOctagon(center, radius);
        System.out.println(octagon.toString());

    }
}
