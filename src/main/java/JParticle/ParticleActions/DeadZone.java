package JParticle.ParticleActions;

import JCat.Math.Shape.BaseShape;
import JParticle.Particles.Particle;

public class DeadZone extends ParticleAction{

	private BaseShape shape;

	public DeadZone(BaseShape shape) {
		this.shape = shape;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Particle particle) {
		if(!shape.contains(particle.x, particle.y))
		{
			particle.isDead=true;
		}
		
	}

	@Override
	public void start(Particle particle) {
		
		
	}

}
