package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cz.muni.fi.pb162.project.geometry.Color.BLACK;
import static cz.muni.fi.pb162.project.geometry.Color.WHITE;

/**
 * Our workspace for drawable polygons
 * @author Petr Urbanek
 */
public class Paper implements Drawable, PolygonFactory{

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
    public void drawPolygon(Polygon polygon) throws TransparentColorException {
        if (color == WHITE){
            throw new TransparentColorException("you tried to draw white on white paper");
        }
        if (drawnPolygons.contains(new ColoredPolygon(polygon, color))) {
            return;
        }
        drawnPolygons.add(new ColoredPolygon(polygon, color));
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        drawnPolygons.remove(polygon);
    }

    @Override
    public void eraseAll() throws EmptyDrawableException {
        if (drawnPolygons.size() == 0){
            throw new EmptyDrawableException("nothing to erase, paper is clean");
        }
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

    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) throws MissingVerticesException {
        if (vertices == null){
            throw new NullPointerException("null in argument");
        }
        CollectionPolygon col = new CollectionPolygon(vertices)
        do {
            try {
                col = new CollectionPolygon(vertices);
            } catch (IllegalArgumentException ex) {
                vertices.remove(null);
            } catch (MissingVerticesException ex) {
                throw new MissingVerticesException("small input");
            }
        } while (false);
        return col;
    }

    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {

    }
}
