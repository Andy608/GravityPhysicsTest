package com.cubestory.world;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.cubestory.util.CubeStoryLogger;
import com.cubestory.world.physics.Vector2D;

public class Forces {

	public static final float GRAVITATIONAL_CONSTANT = 9.8f;
	
	private Vector2D weight;
	
	private Vector2D gravity;
	private Vector2D normal;
	private Vector2D acceleration;
	private Vector2D drag;
	private Vector2D friction;
	
	private Vector2D totalApplied;
	private List<Vector2D> appliedForces;
	
	public Forces(float mass) {
		initForces(mass);
	}
	
	private void initForces(float mass) {
		appliedForces = new ArrayList<>();
		this.weight = new Vector2D("weight", 0, mass * GRAVITATIONAL_CONSTANT);
		
		this.gravity = new Vector2D("gravity");
		updateGravity();
		this.normal = new Vector2D("normal");
		this.acceleration = new Vector2D("acceleration");
		this.drag = new Vector2D("drag");
		this.friction = new Vector2D("friction");
		this.totalApplied = new Vector2D("totalApplied");
	}
	
	public Vector2D getWeight() {
		return weight;
	}
	
	public Vector2D getGravity() {
		return gravity;
	}
	
	public Vector2D getNormal() {
		return normal;
	}
	
	public Vector2D getAcceleration() {
		return acceleration;
	}
	
	public Vector2D getDrag() {
		return drag;
	}
	
	public Vector2D getFriction() {
		return friction;
	}
	
	public Vector2D getNetForce() {
//		return gravity.addVectors(normal, drag, friction);
		
		totalApplied.initVectorVals();
		for (int i = 0; i < appliedForces.size(); i++) {
			totalApplied = totalApplied.addVector(appliedForces.get(i));
		}
		
		System.out.println(gravity.addVectors(totalApplied, normal, drag, friction));
		return gravity.addVectors(totalApplied, normal, drag, friction);
	}
		
	/**
	 * updateWeight updates the weight and gravitational force for the object. Returns the weight force for convenience.
	 * @param mass of the object.
	 * @return weight force.
	 */
	public Vector2D updateWeight(float mass) {
		if (mass != (this.weight.getY() / GRAVITATIONAL_CONSTANT)) {
			this.weight = this.weight.setVector(0, mass * GRAVITATIONAL_CONSTANT);
			updateGravity();
		}
		return this.weight;
	}
	
	private void updateGravity() {
		this.gravity = this.weight;
	}
	
	/**
	 * updateNormal updates the normal force of the object and returns it for convenience.
	 * You should call update weight before this for accurate reading.
	 * @param mass of the object.
	 * @return normal force.
	 */
	public Vector2D updateNormal(float mass) {
		this.normal = this.weight;
		return this.normal;
	}
	
	public Vector2D updateAcceleration(float mass) {
		acceleration = getNetForce().divideVector(mass);
		return acceleration;
	}
//	
//	public Vector2D updateDrag() {
//		return drag;
//	}
//	
//	public Vector2D updateFriction() {
//		return friction;
//	}
	
	public void addAppliedForce(Vector2D v) {
		appliedForces.add(v);
	}
	
	public void removeAppliedForce(String vectorName) {
		
		for (int i = 0; i < appliedForces.size(); i++) {
			if (appliedForces.get(i).getName().equals(vectorName)) {
				appliedForces.remove(i);
				return;
			}
		}
		CubeStoryLogger.write(Level.WARNING, "COULD NOT FIND A VECTOR WITH THAT NAME! Not removing vector.");
	}
}
