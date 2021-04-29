package cz.muni.fi.pb162.project.geometry;

/**
 * @author Petr Urbanek
 */
public class ColoredPolygon {

    private final Polygon polygon;
    private final Color color;

    /**
     * Create colored polygon
     * @param polygon shape of polygon
     * @param color of polygon
     */
    public ColoredPolygon(Polygon polygon, Color color) {
        this.polygon = polygon;
        this.color = color;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public Color getColor() {
        return color;
    }
}
