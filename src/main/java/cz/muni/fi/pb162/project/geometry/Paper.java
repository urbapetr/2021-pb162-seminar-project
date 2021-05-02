package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Collection;

import static cz.muni.fi.pb162.project.geometry.Color.BLACK;

/**
 * @author Petr Urbanek
 */
public class Paper implements Drawable{

    private Collection<ColoredPolygon> drawnPolygons = new ArrayList<>();
    private Color color = BLACK;

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
        drawnPolygons.add(new ColoredPolygon((Polygon) drawable, BLACK));
    }

    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) {

    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        drawnPolygons.remove(polygon);
    }

    @Override
    public void eraseAll() {
        drawnPolygons = new ArrayList<>();
    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return drawnPolygons;
    }

    @Override
    public int uniqueVerticesAmount() {
        int counter = 0;
        for (int i = 0; i < drawnPolygons.size(); i++) {
            counter++;
        }
        return counter;
    }
}
