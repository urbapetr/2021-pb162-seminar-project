package cz.muni.fi.pb162.project.geometry;

/**
 * @author Petr Urbanek
 */
public class Snowman{

    public static final int NUMBEROFBALLS = 4;
    private static final Circular[] BALLS = new Circular[NUMBEROFBALLS];
    private final double reduction;
    private static final double REDUCTIONCONST = 0.8;

    /**
     * Snowman constructor
     * @param circular given first "ball"
     * @param reduction how much will be balls reducted
     */
    public Snowman(Circular circular, double reduction) {
        if (reduction <= 0 || reduction > 1) {
            this.reduction = REDUCTIONCONST;
        } else{
            this.reduction = reduction;
        }
        BALLS[0] = circular;
        Vertex2D center = circular.getCenter();
        double yCoo = center.getY()+circular.getRadius()+ circular.getRadius()*this.reduction;
        Vertex2D newCenter = new Vertex2D(center.getX(),
                yCoo);
        if (1 < NUMBEROFBALLS) {
            ballCreater(1, newCenter, circular.getRadius() * this.reduction);
        }
    }

    /**
     * giv balls into array
     * @param i where in array will the ball be
     * @param center of next ball
     * @param radius of next ball
     */
    private void ballCreater(int i,Vertex2D center , double radius){
        double yCoo = center.getY()+radius+radius*this.reduction;
        Vertex2D newCenter = new Vertex2D(center.getX(), yCoo);
        Circle nextSphere = new Circle(center, radius);
        if (i < NUMBEROFBALLS){
            BALLS[i] = nextSphere;
            ballCreater(i+1, newCenter, radius * this.reduction);
        }

    }

    /**
     * All balls in snowman
     * @return all balls
     */
    public Circular[] getBalls(){
        return BALLS;
    }
}
