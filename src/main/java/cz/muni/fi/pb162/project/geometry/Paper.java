package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static cz.muni.fi.pb162.project.geometry.Color.BLACK;
import static cz.muni.fi.pb162.project.geometry.Color.WHITE;

/**
 * Our workspace for drawable polygons
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
        drawnPolygons = new ArrayList<ColoredPolygon>(drawable.getAllDrawnPolygons());
    }

    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) {
        if (color == WHITE || drawnPolygons.contains(new ColoredPolygon(polygon, color))) {
            return;
        }
        drawnPolygons.add(new ColoredPolygon(polygon, color));
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        drawnPolygons.remove(polygon);
    }

    @Override
    public void eraseAll() {
        drawnPolygons.clear();
    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableCollection(drawnPolygons);
    }

    @Override
    public int uniqueVerticesAmount() {
        Collection<Vertex2D> counter = new ArrayList<>();
        for (ColoredPolygon cp: drawnPolygons) {
            for (int i = 0; i < cp.getPolygon().getNumVertices(); i++){
                if (!counter.contains(cp.getPolygon().getVertex(i))) {
                    counter.add(cp.getPolygon().getVertex(i));
                }
            }
        }
        return counter.size();
    }
}
