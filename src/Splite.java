import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Splite {
	protected double X;
	protected double Y;
	protected double size;
	protected final double MOVE_DISTANCE = 10;

	public Splite(double x, double y, double size){
		this.X = x;
		this.Y = y;
		this.size = size;
	}
	public double getX(){
		return X;
	}
	public double getY(){
		return Y;
	}
	public double getSize(){
		return size;
	}

	public void paint(Graphics2D g2){
		g2.fill(new Ellipse2D.Double(X, Y, size, size));
	}

}
