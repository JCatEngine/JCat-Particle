package JParticle.ParticleActions;

import JCat.Math.Vector2;
import JCat.Math.Shape.BaseShape;
import JParticle.Particles.Particle;

public class InitArea extends ParticleAction{


	private BaseShape area;

	public InitArea(BaseShape shape) {
		this.area=shape;
	}

	@Override
	public void update(Particle particle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Particle particle) {
		//init area
		Vector2 randomPostion=area.getRandomPoint();
		particle.x+=randomPostion.x;
		particle.y+=randomPostion.y;
		
	}

}
