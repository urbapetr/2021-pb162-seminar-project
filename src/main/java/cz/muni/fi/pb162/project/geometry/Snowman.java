package cz.muni.fi.pb162.project.geometry;

/**
 * Class that create snowman of regularPolygons
 * @author Petr Urbanek
 */
public class Snowman{

    private final int numberOfBalls = 3;
    private final RegularPolygon[] balls = new RegularPolygon[numberOfBalls];
    private final double reduction;
    private final double privateConst = 0.8;

    /**
     * Snowman constructor
     * @param regularPolygon given first "ball"
     * @param reduction how much will be balls reduced
     */
    public Snowman(RegularPolygon regularPolygon, double reduction) {
        if (reduction <= 0 || reduction > 1) {
            this.reduction = privateConst;
        } else{
            this.reduction = reduction;
        }
        balls[0] = regularPolygon;
        Vertex2D center = regularPolygon.getCenter();
        double yCoo = center.getY()+regularPolygon.getRadius()+ regularPolygon.getRadius()*this.reduction;
        Vertex2D newCenter = new Vertex2D(center.getX(), yCoo);
        ballCreater(1, newCenter , regularPolygon.getRadius() * this.reduction, balls[0]);
    }

    /**
     * giv balls into array
     * @param i where in array will the ball be
     * @param center of next ball
     * @param radian of next ball
     */
    private void ballCreater(int i,Vertex2D center , double radian, RegularPolygon base){
        if (i < numberOfBalls){
            RegularPolygon nextSphere = new GeneralRegularPolygon(center, base.getNumEdges(),radian);
            balls[i] = nextSphere;
            double yCoo = center.getY()+radian+radian*this.reduction;
            Vertex2D newCenter = new Vertex2D(center.getX(), yCoo);
            ballCreater(i+1, newCenter, radian * this.reduction, base);
        }

    }

    /**
     * All balls in snowman
     * @return all balls
     */
    public RegularPolygon[] getBalls(){
        return balls;
    }
}
