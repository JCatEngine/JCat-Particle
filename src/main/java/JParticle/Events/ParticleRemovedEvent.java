package JParticle.Events;

import JParticle.Particles.Particle;

public class ParticleRemovedEvent extends ParticleEvent{

	public ParticleRemovedEvent( Particle particle) {
		super(ParticleEvent.PARTICLE_REMOVED, particle);
		// TODO Auto-generated constructor stub
	}

}
