package cz.muni.fi.pb162.project.geometry;

/**
 * @author Petr Urbanek
 */
public class RegularOctagon extends GeneralRegularPolygon{

    /**
     * RegularOctagon class creator
     * @param center of octagon
     * @param circumCircle radius of circle around octagon
     */
    public RegularOctagon(Vertex2D center ,double circumCircle){
        super(center, 8, circumCircle);
    }
}
