package com.cubestory.world;

import com.cubestory.world.physics.Vector2D;

public class WorldObject {

	protected float mass;
	protected Vector2D position;
	protected Vector2D velocity;
	protected Forces forces;
	
	public WorldObject(float mass) {
		this.mass = mass;
		this.position = new Vector2D("position");
		this.velocity = new Vector2D("velocity");
		forces = new Forces(this.mass);
	}
	
	public WorldObject(float mass, Vector2D pos) {
		this(mass);
		this.position = pos;
	}
	
	public void updateObject(float dt) {
		Vector2D lastAcceleration = new Vector2D(forces.getAcceleration());
		Vector2D avgAcceleration = new Vector2D("average_acceleration");
		
		//Updates weight of object if the mass changes.
		forces.updateWeight(mass);
		
		//Updates the position of the object using kinematic equation d = vi(t)+ 1/2(a)(t^2)
		position = position.addVector(velocity.multiplyVector(dt).addVector(lastAcceleration.multiplyVector(0.5f).multiplyVector(dt * dt)));
		
		//Updates the acceleration of the object using F = ma
		forces.updateAcceleration(mass);
		
		//Get the average acceleration using (lastAcceleration + new Acceleration) / 2
		avgAcceleration = forces.getAcceleration().addVector(lastAcceleration).divideVector(2);
		
		//Update the velocity by adding (average accleration * t) to current velocity
		velocity = velocity.addVector(avgAcceleration);
//		System.out.println("Gravity Force: " + forces.getGravity() + " Acceleration Force: " + forces.getAcceleration());
		
	}
	
	public float getMass() {
		return mass;
	}
	
	public Vector2D getPosition() {
		return position;
	}
	
	public Vector2D getVelocity() {
		return velocity;
	}
	
	public Forces getForces() {
		return forces;
	}
	
	public void setMass(float m) {
		mass = m;
	}
	
	public void setPosition(Vector2D p) {
		position = p;
	}
	
	public void setVelocity(Vector2D v) {
		v = velocity;
	}
}
