package JParticle.ParticleActions;

import JCat.Utils.MathTool;
import JParticle.Particles.Particle;

public class InitRotation extends ParticleAction{

	private int maxRotation;

	public InitRotation(int maxRotation) {
		this.maxRotation = maxRotation;
		
	}

	@Override
	public void update(Particle particle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Particle particle) {
		particle.rotation=MathTool.random(0, maxRotation);
	}

}
