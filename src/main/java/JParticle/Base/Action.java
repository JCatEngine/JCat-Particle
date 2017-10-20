package JParticle.Base;

import JParticle.Emitter.Emitter;

public interface Action {

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
	/**
	 * return the priority of the action
	 * at the init state the actions which have high priority will be call first,followed
	 * by the actions which have low priority
	 * if a action need do sth (such as a action which create new particles need be called before others)
	 * @return
	 */
	public ActionPriority getPriority();
}
