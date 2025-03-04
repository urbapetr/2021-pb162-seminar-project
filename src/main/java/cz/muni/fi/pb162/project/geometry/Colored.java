package cz.muni.fi.pb162.project.geometry;

/**
 * interface for working with colored shapes
 * @author Petr Urbanek
 */
public interface Colored {

    /**
     * @return color of the shape
     */
    Color getColor();

    /**
     * set color of the shape
     * @param color new color
     */
    void setColor(Color color);
}
