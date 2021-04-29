package cz.muni.fi.pb162.project.geometry;

/**
 * Create Triangle with 3 Vertex2D
 * @author Petr Urbanek
 */
public class Triangle extends ArrayPolygon implements Measurable {
    private final Triangle[] arrayOfTriangle = new Triangle[3];

    /**
     * Create new triangle
     * @param v1 is first Vertex
     * @param v2 is second Vertex
     * @param v3 is third Vertex
     */
    public Triangle(Vertex2D v1, Vertex2D v2,Vertex2D v3){
        super(new Vertex2D[]{v1, v2, v3});
    }

    /**
     * Create new Triangle without arguments
     */
    public Triangle(){
        super(new Vertex2D[]{new Vertex2D(0,0),new Vertex2D(0,0),new Vertex2D(0,0)});
    }

    /**
     * Create Triangle and divide him
     * @param v1 first Vertex
     * @param v2 second Vertex
     * @param v3 third Vertex
     * @param depth how much deep will we go
     */
    public Triangle(Vertex2D v1, Vertex2D v2,Vertex2D v3, int depth){
        this(v1, v2, v3);
        divide(depth);
    }

    @Override
    public String toString(){
        return "Triangle: vertices=" + getVertex(0) + " " +
                getVertex(1) + " " +
                getVertex(2);
    }

    /**
     * Make smaller triangles
     * @return true if triangle can be divided
     */
    public boolean divide(){
        if ( isDivided() ) {
            return false;
        }
        Vertex2D ab = getVertex(0).createMiddle(getVertex(1));
        Vertex2D ac = getVertex(0).createMiddle(getVertex(2));
        Vertex2D bc = getVertex(1).createMiddle(getVertex(2));
        Triangle firstTriangle = new Triangle(getVertex(0),ab,ac);
        Triangle secondTriangle = new Triangle(getVertex(1),ab,bc);
        Triangle thirdTriangle = new Triangle(getVertex(2),bc,ac);
        arrayOfTriangle[0] = firstTriangle;
        arrayOfTriangle[1] = secondTriangle;
        arrayOfTriangle[2] = thirdTriangle;
        return true;
    }

    /**
     * Is triangle already divided?
     * @return true if its not divided
     */
    public boolean isDivided(){
        return arrayOfTriangle[0] != null && arrayOfTriangle[1] != null && arrayOfTriangle[2] != null;
    }

    /**
     * Returb sub triangle
     * @param index of sub triangle
     * @return sub triangle or null
     */
    public Triangle getSubTriangle(int index){
        if (isDivided() && index >= 0 && index <= 2) {
            return arrayOfTriangle[index];
        }
        return null;
    }

    /**
     * @return true if Triangle is Equilateral
     */
    public boolean isEquilateral(){
        double d1 = getVertex(0).distance(getVertex(1));
        double d2 = getVertex(0).distance(getVertex(2));
        double d3 = getVertex(1).distance(getVertex(2));
        double cmpAbs = 0.001;
        return Math.abs(d1-d2) < cmpAbs && Math.abs(d1-d3) < cmpAbs;
    }

    /**
     * Divide Tringle into more triangles
     * @param depth of subtriangles
     */
    public void divide(int depth){
        if (depth > 0){
            divide();
            for (int i = 0; i < 3; i++){
                arrayOfTriangle[i].divide(depth-1);
            }
        }
    }
}

