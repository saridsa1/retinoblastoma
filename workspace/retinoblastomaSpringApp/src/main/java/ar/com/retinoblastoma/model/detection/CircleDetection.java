package ar.com.retinoblastoma.model.detection;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

public class CircleDetection implements Detection {
	
	private Point pt;
	private int radius;
	private int thickness;
	private boolean positive;
	private String comment;
		
	
	public CircleDetection() {
		pt = new Point();
		radius = 0;
		thickness= 2;
		positive = false;
	}
	
	public CircleDetection(Point pt,int radius) {
		this.pt = pt;
		this.radius = radius;
		thickness = 2;
		positive = false;
	}
	
	@Override
	public void draw(Mat im,Scalar sc) {
		// draw the found circle		
		Core.circle(im, pt, radius, sc, thickness);
		
	}

	public Point getPt() {
		return pt;
	}

	public void setPt(Point pt) {
		this.pt = pt;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	public Rect getInternRect() {
		return new Rect((int)(pt.x - (radius*Math.sqrt(2)/2)) , (int)(pt.y - (radius*Math.sqrt(2)/2)), (int)(radius*Math.sqrt(2)), (int)(radius*Math.sqrt(2)));
	}

	public boolean isPositive() {
		return positive;
	}

	public void setPositive(boolean positive) {
		this.positive = positive;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}	
	

}
