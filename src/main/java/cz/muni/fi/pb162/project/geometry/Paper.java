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
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) {
        if (vertices == null){
            throw new NullPointerException("null in argument");
        }
        List<Vertex2D> newList = new ArrayList<>(vertices);
        CollectionPolygon col = new CollectionPolygon(vertices);
        do {
            try {
                col = new CollectionPolygon(newList);
            } catch (IllegalArgumentException ex) {
                newList.remove(null);
            }
        } while (false);
        return col;
    }

    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {
        int polygonsPainted = 0;
        Exception cause = null;
        for (List<Vertex2D> listOfVertex : collectionPolygons) {
            try {
                Polygon newPolygon = tryToCreatePolygon(listOfVertex);
                drawPolygon(newPolygon);
                polygonsPainted = polygonsPainted + 1;
            } catch (TransparentColorException tcex){
                changeColor(BLACK);
                cause = tcex;
            } catch (MissingVerticesException | NullPointerException ex) {
                cause = ex;
            } catch (IllegalArgumentException ignored) {
            }
        }
        if (polygonsPainted == 0) {
            throw new EmptyDrawableException(cause);
        }
    }

    /**
     * Return Collection of polygons with given color
     * @param color of polygons
     * @return polygons with given color
     */
    public Collection<Polygon> getPolygonsWithColor(Color color) {
        Collection<Polygon> drawnPolygonsWithGivenColor = new ArrayList<>();
        for (ColoredPolygon polygon : drawnPolygons) {
            if (polygon.getColor() == color) {
                drawnPolygonsWithGivenColor.add(polygon.getPolygon());
            }
        }
        return drawnPolygonsWithGivenColor;
    }
}
