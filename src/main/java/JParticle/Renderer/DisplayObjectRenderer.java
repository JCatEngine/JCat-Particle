package JParticle.Renderer;

import java.util.LinkedList;
import java.util.List;

import JCat.Display.Bitmap;
import JCat.Display.DisplayObject;
import JCat.Display.Sprite;
import JParticle.Emitter.Emitter;
import JParticle.Events.EmitterEvent;
import JParticle.Particles.Particle;

public class DisplayObjectRenderer extends Sprite implements BaseRenderer{

	private LinkedList<Emitter> emitters=new LinkedList<>();

	@Override
	public void addEmitter(Emitter emitter) {
		emitter.addEventListener(EmitterEvent.AFTER_UPDATE, event -> afterUpdate());
		emitter.addEventListener(EmitterEvent.BEFORE_UPDATE, event -> beforeUpdate());
		this.emitters.add(emitter);
	}

	private void beforeUpdate() {
	}

	protected void afterUpdate() {
		for (DisplayObject displayObject : this.getChilds()) {
			this.removeChild(displayObject);
		}
		
		List<Particle> list=new LinkedList<>();
		
		for (Emitter emitter : emitters) {
			list.addAll(emitter.getParticles());
		}
		
		//render all particle
		for (Particle particle : list) {
			Bitmap bitmap=new Bitmap(particle.texture);
			addChild(bitmap);
			
			bitmap.x=particle.x;
			bitmap.y=particle.y;
			bitmap.alpha=particle.alpha;
			bitmap.rotation=particle.rotation;
			bitmap.setScaleX(particle.scale);
			bitmap.setScaleY(particle.scale);
			
		}
		
	}

	@Override
	public void removeEmitter(Emitter emitter) {
		emitter.removeEventListener(EmitterEvent.AFTER_UPDATE);
		emitter.removeEventListener(EmitterEvent.BEFORE_UPDATE);
		this.emitters.remove(emitter);
	}
	
	
	

}
