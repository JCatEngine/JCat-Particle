package JParticle.Events;

import JCat.Event.Event;

public class EmitterEvent extends Event {

	
	
	public static final String AFTER_UPDATE = "after_update";
	public static final String BEFORE_UPDATE = "before_update";

	public EmitterEvent(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

}
