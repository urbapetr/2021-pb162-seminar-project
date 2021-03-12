package cz.muni.fi.pb162.project;
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
        Vertex2D a,b;
        a = new Vertex2D();
        b = new Vertex2D();
        a.setX(2);
        a.setY(3);
        b.setX(1);
        b.setY(1);
        a.move(b);
        System.out.println("[" + a.getX() + "," + a.getY() + "]");
        System.out.println("[" + b.getX() + "," + b.getY() + "]");
    }
}
