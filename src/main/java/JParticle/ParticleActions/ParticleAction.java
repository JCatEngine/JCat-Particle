package JParticle.ParticleActions;

import JParticle.Base.Action;
import JParticle.Emitter.Emitter;
import JParticle.Particles.Particle;

/**
 * base ParticleAction class
 * @author Administrator
 *
 */
public interface ParticleAction extends Action{
	
	/**
	 * called every frame
	 * @param emitter The Emitter that created the particle.
	 * @param particle The particle to be updated.
	 * @param time The duration of the frame - used for time based updates.
	 * 
	 */
	public void update(Particle particle);

	/**
	 * called when one particle be created
	 * @param emitter
	 * @param particle
	 */
	public void start(Particle particle);
	
	
//	/**
//	 * called when one particle dead
//	 * @param emitter
//	 * @param particle
//	 */
//	public void end(Particle particle);

}
