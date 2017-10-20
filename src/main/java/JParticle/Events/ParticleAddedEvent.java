package JParticle.Events;

import JParticle.Particles.Particle;

public class ParticleAddedEvent extends ParticleEvent{

	public ParticleAddedEvent( Particle particle) {
		super(ParticleEvent.PARTICLE_ADDED, particle);
	}

}
