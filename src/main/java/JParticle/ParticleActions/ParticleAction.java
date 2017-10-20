package JParticle.ParticleActions;

import JParticle.Base.Action;
import JParticle.Base.ActionPriority;
import JParticle.Emitter.Emitter;
import JParticle.Particles.Particle;

/**
 * base ParticleAction class
 * @author Administrator
 *
 */
public abstract class ParticleAction implements Action{
	
	/**
	 * called every frame
	 * @param emitter The Emitter that created the particle.
	 * @param particle The particle to be updated.
	 * @param time The duration of the frame - used for time based updates.
	 * 
	 */
	public abstract void update(Particle particle);

	/**
	 * called when one particle be created
	 * @param emitter
	 * @param particle
	 */
	public abstract void start(Particle particle);
	
	
	/**
	 * most time these two action are useless,so i just null implement it 
	 */
	@Override
	public void addedToEmitter(Emitter emitter) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void removedFromEmitter(Emitter emitter) {
		// TODO Auto-generated method stub
		
	}
	//default is low
	@Override
	public ActionPriority getPriority() {
		// TODO Auto-generated method stub
		return ActionPriority.LOW;
	}
	
	

}
