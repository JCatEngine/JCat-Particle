package JParticle.EmitterActions.Counter;

import JParticle.Emitter.Emitter;

public class Steady extends CounterAction {

	
	/**
	 * particles amount created every frame
	 */
	private int amount;

	public Steady(int amount) {
		this.amount = amount;
	}
	
	@Override
	public void update(Emitter emitter) {
		emitter.createPartices(amount);

	}

	@Override
	public void start(Emitter emitter) {
		

	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
	

}
