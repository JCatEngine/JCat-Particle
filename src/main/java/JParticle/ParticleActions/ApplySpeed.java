package JParticle.ParticleActions;

import JParticle.Particles.Particle;

public class ApplySpeed extends ParticleAction {

	private int speed;
	private int addSpeed;

	public ApplySpeed(int initSpeed, int addSpeed) {
		this.addSpeed = addSpeed;
		this.speed=initSpeed;
	}

	@Override
	public void update(Particle particle) {
		particle.speed+=addSpeed;

	}

	@Override
	public void start(Particle particle) {
		particle.speed=speed;
		
	}

}
