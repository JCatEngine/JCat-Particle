package JParticle.Particles;

import java.util.LinkedList;

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

	private LinkedList<Particle> caches=new LinkedList<>();
	
	private SharedParticleFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Particle createParticle() {
		if(caches.size()>0)
		{
			return caches.removeFirst();
		}
		else
		{
			return new Particle();
		}
		
	}

	@Override
	public void disposeParticle(Particle particle) {
		particle.reset();
		caches.add(particle);

	}

	@Override
	public void clearAllParticles() {
		caches.clear();

	}

	

}
