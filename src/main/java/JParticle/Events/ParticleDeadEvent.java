package JParticle.Events;

import JParticle.Particles.Particle;

public class ParticleDeadEvent extends ParticleEvent {

	public ParticleDeadEvent(Particle particle) {
		super(ParticleEvent.PARTICLE_DEAD, particle);
		// TODO Auto-generated constructor stub
	}

}
