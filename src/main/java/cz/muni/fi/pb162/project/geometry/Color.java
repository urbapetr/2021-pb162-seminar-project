package cz.muni.fi.pb162.project.geometry;

/**
 * basic color possibilities
 * @author Petr Urbanek
 */
public enum Color {
    GREEN,
    BLACK,
    WHITE,
    RED,
    BLUE,
    YELLOW,
    ORANGE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}



