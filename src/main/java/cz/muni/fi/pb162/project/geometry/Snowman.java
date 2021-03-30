package cz.muni.fi.pb162.project.geometry;

/**
 * @author Petr Urbanek
 */
public class Snowman{

    private final int numberOfBalls = 4;
    private final Circular[] balls = new Circular[numberOfBalls];
    private final double reduction;
    private final double privateConst = 0.8;

    /**
     * Snowman constructor
     * @param circular given first "ball"
     * @param reduction how much will be balls reducted
     */
    public Snowman(Circular circular, double reduction) {
        if (reduction <= 0 || reduction > 1) {
            this.reduction = privateConst;
        } else{
            this.reduction = reduction;
        }
        balls[0] = circular;
        Vertex2D center = circular.getCenter();
        double yCoo = center.getY()+circular.getRadius()+ circular.getRadius()*this.reduction;
        Vertex2D newCenter = new Vertex2D(center.getX(),
                yCoo);
        ballCreater(1, newCenter , circular.getRadius() * this.reduction);
    }

    /**
     * giv balls into array
     * @param i where in array will the ball be
     * @param center of next ball
     * @param radian of next ball
     */
    private void ballCreater(int i,Vertex2D center , double radian){
        if (i < numberOfBalls){
            Circle nextSphere = new Circle(center, radian);
            balls[i] = nextSphere;
            double yCoo = center.getY()+radian+radian*this.reduction;
            Vertex2D newCenter = new Vertex2D(center.getX(), yCoo);
            ballCreater(i+1, newCenter, radian * this.reduction);
        }

    }

    /**
     * All balls in snowman
     * @return all balls
     */
    public Circular[] getBalls(){
        return balls;
    }
}
