package JParticle.Events;

import JCat.Event.Event;
import JParticle.Particles.Particle;

public abstract class ParticleEvent extends Event {

	/**
	 * The event dispatched by an emitter when a particle is created.
	 */
	public static String PARTICLE_CREATED = "particleCreated";
	
	/**
	 * The event dispatched by an emitter when a particle dies.
	 */
	public static String PARTICLE_DEAD = "particleDead";
	
	/**
	 * The event dispatched by an emitter when a pre-existing particle is added to it.
	 */
	public static String PARTICLE_ADDED = "particleAdded";
	
	/**
	 * The event dispatched by an emitter when a particle is removed from it (but doesn't die).
	 */
	public static String PARTICLE_REMOVED = "particleRemoved";

	private Particle particle;
	
	public ParticleEvent(String type,Particle particle) {
		super(type);
		this.particle = particle;
		
	}

	public Particle getParticle() {
		return particle;
	}
	
	
	

}
