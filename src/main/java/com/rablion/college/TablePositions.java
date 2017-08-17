package com.rablion.college;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class TablePositions {
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	private Point p;
	private Dimension d;
	Rectangle rect ;
	
	

	public TablePositions(String name, int x, int y, int width, int height) {
		p = new Point(x,y);
		d = new Dimension(width,height);
		rect = new Rectangle( p, d);
		this.name = name;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public Dimension getD() {
		return d;
	}

	public void setD(Dimension d) {
		this.d = d;
	}
	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
}
