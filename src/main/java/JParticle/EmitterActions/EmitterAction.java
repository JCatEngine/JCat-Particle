package JParticle.EmitterActions;

import JParticle.Base.Action;
import JParticle.Emitter.Emitter;

/**
 * emitter dealed with emitter itself
 * @author Administrator
 *
 */
public interface EmitterAction extends Action{
	/**
	 * called every frame
	 * @param emitter The Emitter that created the particle.
	 * @param particle The particle to be updated.
	 * @param time The duration of the frame - used for time based updates.
	 * 
	 */
	public void update(Emitter emitter);

	/**
	 * called when emitter start
	 * @param emitter
	 * @param particle
	 */
	public void start(Emitter emitter);
	
	
	/**
	 * called when emitter end
	 * @param emitter
	 * @param particle
	 */
	public void end(Emitter emitter);

}
