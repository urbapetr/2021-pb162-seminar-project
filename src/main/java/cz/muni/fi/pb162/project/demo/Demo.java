package cz.muni.fi.pb162.project.demo;


import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.io.*;

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
    public static void main(String[] args) throws IOException {

        try (OutputStream os = new FileOutputStream("polygon-out.txt")) {
            LabeledPolygon labeledPolygon = new LabeledPolygon.Builder()
                    .read(new File("polygon-ok.txt"))
                    .addVertex("vrchol x", new Vertex2D(123,456))
                    .build();
            labeledPolygon.writeJson(os);
        } catch (Throwable te) {
            throw new IOException("wrong file name");
        }

    }
}
