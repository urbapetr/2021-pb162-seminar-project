package cz.muni.fi.pb162.project.geometry;

/**
 * Create Triangle with 3 Vertex2D
 * @author Petr Urbanek
 */
public class Triangle {
    private final Vertex2D[] arrayOfVertex2D = new Vertex2D[] {new Vertex2D(0,0),new Vertex2D(0,0),new Vertex2D(0,0)};
    private final Triangle[] arrayOfTriangle = new Triangle[3];

    /**
     * Create new triangle
     * @param v1 is first angle
     * @param v2 is second angle
     * @param v3 is third angle
     */
    public Triangle(Vertex2D v1, Vertex2D v2,Vertex2D v3){
        arrayOfVertex2D[0] = v1;
        arrayOfVertex2D[1] = v2;
        arrayOfVertex2D[2] = v3;
    }

    /**
     * Create new Triangle without arguments
     */
    public Triangle(){
        this(new Vertex2D(0,0),new Vertex2D(0,0),new Vertex2D(0,0));
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

    /**
     * @param index which vertex
     * @return vertex
     */
    public Vertex2D getVertex(int index){
        if (index >= 0 && index <= 2) {
            return arrayOfVertex2D[index];
        }
        return null;
    }

    @Override
    public String toString(){
        return "Triangle: vertices=" + arrayOfVertex2D[0] + " " +
                arrayOfVertex2D[1] + " " +
                arrayOfVertex2D[2];
    }

    /**
     * Make smaller triangles
     * @return true if triangle can be divided
     */
    public boolean divide(){
        if ( isDivided() ) {
            return false;
        }
        Vertex2D ab = arrayOfVertex2D[0].createMiddle(arrayOfVertex2D[1]);
        Vertex2D ac = arrayOfVertex2D[0].createMiddle(arrayOfVertex2D[2]);
        Vertex2D bc = arrayOfVertex2D[1].createMiddle(arrayOfVertex2D[2]);
        Triangle firstTriangle = new Triangle(arrayOfVertex2D[0],ab,ac);
        Triangle secondTriangle = new Triangle(arrayOfVertex2D[1],ab,bc);
        Triangle thirdTriangle = new Triangle(arrayOfVertex2D[2],bc,ac);
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
        double d1 = arrayOfVertex2D[0].distance(arrayOfVertex2D[1]);
        double d2 = arrayOfVertex2D[0].distance(arrayOfVertex2D[2]);
        double d3 = arrayOfVertex2D[1].distance(arrayOfVertex2D[2]);
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

