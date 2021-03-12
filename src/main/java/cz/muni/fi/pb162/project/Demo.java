package cz.muni.fi.pb162.project;
import package cz.muni.fi.pb162.project.geometry.Vertex2D;

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
    	firstX = Vertex2D.setX(2);
    	firstY = Vertex2D.setY(3);
    	secondX = Vertex2D.setX(1);
    	secondY = Vertex2D.setY(1);
    	Vertex2D.move([firstX,firstY], [secondX,secondY]);
    	System.out.println();

    }
}
