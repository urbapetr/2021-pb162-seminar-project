package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;

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
        Vertex2D a;
        Vertex2D b;
        Vertex2D c;
        a = new Vertex2D(-100,0);
        b = new Vertex2D(0,100);
        c = new Vertex2D(100,-100);
        Triangle newTriangle;
        newTriangle = new Triangle(a,b,c);
        System.out.println(newTriangle.toString());

    }
}
