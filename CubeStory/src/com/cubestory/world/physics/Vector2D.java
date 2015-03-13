package com.cubestory.world.physics;

import java.util.logging.Level;

import com.cubestory.util.CubeStoryLogger;

public class Vector2D {

	private final String vectorName;
	private float x;
	private float y;
	private float magnitude;
	
	public Vector2D(String name) {
		vectorName = name;
		initVectorVals();
	}
	
	public Vector2D(Vector2D copy) {
		vectorName = copy.vectorName;
		x = copy.x;
		y = copy.y;
		magnitude = copy.magnitude;
	}
	
	public Vector2D(String name, float xVal, float yVal) {
		vectorName = name;
		x = xVal;
		y = yVal;
		magnitude = setMagnitude();
	}
	
	private float setMagnitude() {
		return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public Vector2D compareMagnitude(Vector2D v) {
		if ((x * x + y * y) > (v.getX() * v.getX() + v.getY() * v.getY())) {
			return this;
		}
		return v;
	}
	
	public Vector2D addVector(Vector2D v) {
		Vector2D newVector = new Vector2D(this);
		newVector.x += v.x;
		newVector.y += v.y;
		newVector.magnitude = newVector.setMagnitude();
		return newVector;
	}
	
	public Vector2D addVectors(Vector2D... v) {
		Vector2D newVector = new Vector2D(this);
		
		for (Vector2D vec : v) {
			newVector.x += vec.x;
			newVector.y += vec.y;
			newVector.magnitude = newVector.setMagnitude();
		}
		return newVector;
	}
	
	public Vector2D subtractVector(Vector2D a, Vector2D b) {
		Vector2D newVector = new Vector2D(this);
		newVector.x = a.getX() - b.getX();
		newVector.y = a.getY() - b.getY();
		newVector.magnitude = newVector.setMagnitude();
		return newVector;
	}
	
	public Vector2D multiplyVector(float magnifier) {
		Vector2D newVector = new Vector2D(this);
		newVector.x *= magnifier;
		newVector.y *= magnifier;
		newVector.magnitude = newVector.setMagnitude();
		return newVector;
	}
	
	public Vector2D divideVector(float magnifier) {
		Vector2D newVector = new Vector2D(this);
		if (magnifier == 0) {
			CubeStoryLogger.write(Level.WARNING, "Cannot divide by zero! Not dividing values.");
		}
		else {
			newVector.x /= magnifier;
			newVector.y /= magnifier;
			newVector.magnitude = newVector.setMagnitude();
		}
		return newVector;
	}
	
	public Vector2D normalizeVector() {
		return divideVector(magnitude);
	}
	
	public float dotProduct(Vector2D a, Vector2D b) {
		return a.x + b.x * a.y + b.y;
	}
	
	public float crossProduct(Vector2D a, Vector2D b) {
		return a.x * b.y - a.y * b.x;
	}
	
	public void initVectorVals() {
		x = 0;
		y = 0;
		magnitude = 0;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public Vector2D setVector(float xVal, float yVal) {
		x = xVal;
		y = yVal;
		return this;
	}
	
	public double getMagnitude() {
		return magnitude;
	}
	
	public String getName() {
		return vectorName;
	}
	
	public String toString() {
		return vectorName + ": (" + x + ", " + y + ") Magnitude: " + magnitude;
	}
}
