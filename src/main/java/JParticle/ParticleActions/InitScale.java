package JParticle.ParticleActions;

import JCat.Utils.MathTool;
import JParticle.Particles.Particle;

public class InitScale extends ParticleAction{

	private double min;
	private double max;

	public InitScale(double min, double max) {
		this.min = min;
		this.max = max;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Particle particle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Particle particle) {
		particle.scale=MathTool.random(min, max);
		
	}

}
