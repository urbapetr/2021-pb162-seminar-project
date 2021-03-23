package cz.muni.fi.pb162.project.geometry;

/**
 * @author Petr Urbanek
 */
public class Triangle {
    private Vertex2D[] arrayOfVertex2D = new Vertex2D[] {new Vertex2D(0,0),new Vertex2D(0,0),new Vertex2D(0,0)};
    //private Vertex2D[] arrayOfVertex2D = new Vertex2D[] {new Vertex2D(0,0),new Vertex2D(0,0),new Vertex2D(0,0)};
    // tohle je rekurzivni definice: pro vytvoreni Triangle je potreba vytvorit 3x Triangle (temi new Triangle)
    // proc je tady vlastne tento konstruktor?
    /*
    private Triangle[] arrayOfTriangle = new Triangle[] {
            new Triangle(new Vertex2D(0.0,0.0),new Vertex2D(0.0,0.0), new Vertex2D(0.0,0.0)),
            new Triangle(new Vertex2D(0.0,0.0),new Vertex2D(0.0,0.0), new Vertex2D(0.0,0.0)),
            new Triangle(new Vertex2D(0.0,0.0),new Vertex2D(0.0,0.0), new Vertex2D(0.0,0.0))
    };
    */

    // tohle vytvori pole o delce 3, ale obsah pole je nyni {null,null,null}
    // (a bude fungovat isDivided() mimochodem)
    private Triangle[] arrayOfTriangle = new Triangle[3];

    /**
     * Create new triangle
     * @param v1 is first angle
     * @param v2 is second angle
     * @param v3 is third angle
     */

    public Triangle(Vertex2D v1, Vertex2D v2,Vertex2D v3){
        setVertex(0,v1);
        setVertex(1,v2);
        setVertex(2,v3);
    }

    /**
     * Return wanted angle
     * @param index which angle is wanted
     * @return wanted angle
     */
    public Vertex2D getVertex(int index){
        if (index >= 0 && index <= 2) {
            return arrayOfVertex2D[index];
        }
        return null;
    }

    /**
     * Set angle into different angle
     * @param index which angle we want to change
     * @param vertex new angle
     */
    public void setVertex(int index, Vertex2D vertex) {
        if (index >= 0 && index <=2){
            //arrayOfVertex2D[index].setX(vertex.getX());
            //arrayOfVertex2D[index].setY(vertex.getY());
            //
            //kopirovani nahrazeno prirazenim... coz umozni Jave uvidet,
            //ze arrayOfVertex2D[index] a vertex jsou stejne
            arrayOfVertex2D[index] = vertex;
        }
    }

    /**
     * Prints all angles of triangle
     * @return string of angles
     */
    public String toString(){
        return "Triangle: vertices=" + arrayOfVertex2D[0].toString() + " " +
                arrayOfVertex2D[1].toString() + " " +
                arrayOfVertex2D[2].toString();
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
}
