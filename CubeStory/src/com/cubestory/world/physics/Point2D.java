//package com.cubestory.world.physics;
//
//public class Point2D {
//
//	private float x;
//	private float y;
//	
//	public Point2D(Point2D copy) {
//		x = copy.x;
//		y = copy.y;
//	}
//
//	public Point2D(float xVal, float yVal) {
//		x = xVal;
//		y = yVal;
//	}
//	
//	public Point2D addPoint(Vector2D v) {
//		Point2D newPoint = new Point2D(this);
//		newPoint.x += v.getX();
//		newPoint.y += v.getY();
//		return newPoint;
//	}
//	
//	public Point2D subtractPoint(Point2D p) {
//		Point2D newPoint = new Point2D(this);
//		newPoint.x -= p.x;
//		newPoint.y -= p.y;
//		return newPoint;
//	}
//	
//	public float getX() {
//		return x;
//	}
//	
//	public float getY() {
//		return y;
//	}
//	
//	public String toString() {
//		return "(" + x + ", " + y + ")";
//	}
//}
