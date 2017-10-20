package Example;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Texture;
import JCat.Event.Event;
import JCat.Event.EventDispatcher;
import JCat.Event.EventListener;
import JCat.Math.Vector2;
import JCat.Math.Shape.LineShape;
import JCat.Math.Shape.RectShape;
import JCat.Utils.ImageLoader;
import JCat.Utils.ImageLoader.onAchieveListener;
import JParticle.Emitter.Emitter;
import JParticle.EmitterActions.Counter.Steady;
import JParticle.ParticleActions.InitArea;
import JParticle.ParticleActions.InitRotation;
import JParticle.ParticleActions.InitScale;
import JParticle.ParticleActions.InitTexture;
import JParticle.ParticleActions.ApplySpeed;
import JParticle.ParticleActions.DeadZone;
import JParticle.Renderer.DisplayObjectRenderer;

public class Basic {
public static void main(String[] args) {
		
		ImageLoader loader=new ImageLoader();
		loader
		.add("resources\\bunny.png")
		.start(new onAchieveListener() {

			@Override
			public void onAchieve(ImageLoader loader) {
				
				loadAchieve();
			}
		});
	}

	protected static void loadAchieve() {
		
		RenderSystem system=new RenderSystem(800, 600);
		Texture texture=system.getImageManager().getTextureByName("bunny");
		Bitmap bitmap=new Bitmap(texture);
		bitmap.x=system.getStage().getStageWidth()/2;
		bitmap.y=system.getStage().getStageHeight()/2;
		bitmap.setAnchorX(0.5);
		bitmap.setAnchorY(0.5);
		bitmap.addEventListener(Event.UPDATE, new EventListener() {
			
			@Override
			public void onResponce(Event event) {
				bitmap.rotation+=5;
			}
		});
		
		
		
		system.getStage().addChildAll(bitmap);
		
		
		Emitter emitter = new Emitter(system.getStage());
		emitter.addEmitterAction(new Steady(10));
		emitter.addParticleAction(new InitArea(new LineShape(Vector2.ZERO, new Vector2(system.getStage().getStageWidth(), 0))));
		emitter.addParticleAction(new InitTexture("bunny"));
		emitter.addParticleAction(new ApplySpeed(5,0));
		emitter.addParticleAction(new InitScale(0.2,0.5));
		emitter.addParticleAction(new DeadZone(new RectShape(system.getStage().getBound(null))));
		emitter.addParticleAction(new InitRotation(360));
		emitter.start();
		
		emitter.x=200;
		emitter.y=200;
		
		
		DisplayObjectRenderer renderer=new DisplayObjectRenderer();
		renderer.addEmitter(emitter);
		
		system.getStage().addChild(renderer);
		


		
	}
}
