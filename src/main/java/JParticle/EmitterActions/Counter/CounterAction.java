package JParticle.EmitterActions.Counter;

import JParticle.Base.ActionPriority;
import JParticle.Emitter.Emitter;
import JParticle.EmitterActions.EmitterAction;

/**
 * special action which concern focus on particles creation
 * @author Administrator
 *
 */
public abstract class CounterAction implements EmitterAction{
		
	@Override
	public void addedToEmitter(Emitter emitter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removedFromEmitter(Emitter emitter) {
		// TODO Auto-generated method stub

	}
	/**
	 * CounterAction need to be called before which action work with the exists particle
	 */
	@Override
	public ActionPriority getPriority() {
		// TODO Auto-generated method stub
		return ActionPriority.HIGH;
	}
	
}
