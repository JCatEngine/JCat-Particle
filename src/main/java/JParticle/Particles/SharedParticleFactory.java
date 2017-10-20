package JParticle.Particles;

/**
 * a factory shared by all emitter
 * @author Administrator
 *
 */
public class SharedParticleFactory implements ParticleFactory {

	
	private static ParticleFactory instance;
	public static ParticleFactory getInstance() {
		
		if(instance==null)
		{
			instance=new SharedParticleFactory();
		}
		
		return instance;
	}

	@Override
	public Particle createParticle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeParticle(Particle particle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearAllParticles() {
		// TODO Auto-generated method stub

	}

	

}
