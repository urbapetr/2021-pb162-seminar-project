package cz.muni.fi.pb162.project.demo;


import cz.muni.fi.pb162.project.geometry.Color;
import cz.muni.fi.pb162.project.geometry.GeneralRegularPolygon;
import cz.muni.fi.pb162.project.geometry.RegularOctagon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class for running main method.
 *
 * @author Petr Urbanek
 */
public class Demo {

    /**
     * Runs the code.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {

        GeneralRegularPolygon newPolygon = new RegularOctagon(new Vertex2D(0,0),1);
        newPolygon.setColor(Color.BLACK);
        System.out.println(newPolygon.toString());

    }
}
