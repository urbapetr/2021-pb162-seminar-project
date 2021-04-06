package cz.muni.fi.pb162.project;


import cz.muni.fi.pb162.project.geometry.RegularOctagon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class for running main method.
 *
 * @author TODO: put your name here
 */
public class Demo {

    /**
     * Runs the code.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {

        Vertex2D center = new Vertex2D(0,0);
        double radius = 1;
        RegularOctagon octagon = new RegularOctagon(center, radius);
        System.out.println(octagon.toString());

    }
}
