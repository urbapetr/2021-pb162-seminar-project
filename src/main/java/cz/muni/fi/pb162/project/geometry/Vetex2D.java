package cz.muni.fi.pb162.project.geometry;

public class Vertex2D {

	private double xCoordinate = 0, yCoordinate = 0;
	
	public double getX() {
		return xCoordinate;
	} 
	
	public double getY() {
		return yCoordinate;
	}
	
	public void setX(double x) {
		xCoordinate = x;
	}
    
	public void setY(double y) {
		yCoordinate = y;
	}
	
	public String getInfo() {
		return "[" + xCoordinate + ", " + yCoordinate + "]";
	}
	
	public double sumCoordinates() {
		return xCoordinate + yCoordinate;
	}
	
	public void move(Vertex2D vertex) {
		xCoordinate = xCoordinate + vertex[0];
		yCoordinate = yCoordinate + vertex[1];
	}
}