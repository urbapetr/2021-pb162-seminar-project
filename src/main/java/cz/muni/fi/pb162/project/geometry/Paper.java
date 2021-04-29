package cz.muni.fi.pb162.project.geometry;

import java.util.Collection;
import java.util.List;

/**
 * @author Petr Urbanek
 */
public class Paper implements Drawable{

    private List<Vertex2D> drawnPolygons;

    /**
     * Paper constructor without param
     */
    public Paper() {
    }

    /**
     * paper constructor with Drawable param
     * @param drawable object
     */
    public Paper(Drawable drawable) {

    }

    @Override
    public void changeColor(Color color) {

    }

    @Override
    public void drawPolygon(Polygon polygon) {

    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {

    }

    @Override
    public void eraseAll() {

    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return null;
    }

    @Override
    public int uniqueVerticesAmount() {
        return 0;
    }
}
