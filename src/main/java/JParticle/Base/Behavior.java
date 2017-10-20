package JParticle.Base;

import JParticle.Emitter.Emitter;

public interface Behavior {

	/**
	 * called when added to emitter
	 * @param emitter
	 */
	public void addedToEmitter(Emitter emitter);
	/**
	 * called when removed from emitter
	 * @param emitter
	 */
	public void removedFromEmitter(Emitter emitter);
}
