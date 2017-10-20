package Example;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Texture;
import JCat.Event.Event;
import JCat.Event.EventDispatcher;
import JCat.Event.EventListener;
import JCat.Utils.ImageLoader;
import JCat.Utils.ImageLoader.onAchieveListener;
import JParticle.Emitter.Emitter;
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
		
		
		Emitter emitter = new Emitter();
		//emitter.fixedFrameTime=1/30;
		DisplayObjectRenderer renderer = new DisplayObjectRenderer();
		GameEngine.getInstance().gamePlane.addChild( renderer );
		renderer.addEmitter( emitter );
		
		emitter.counter = new Steady( 180 );
		
		emitter.addInitializer( new ImageClass(ResourceManager.getInstance().getClassByName("a") ) );
		emitter.addInitializer( new Position( new LineZone( new Po((int) -1000, -5 ), new Po((int) 805, -5 ) ) ) );
		emitter.addInitializer( new Velocity( new RectangleZone( 200, 200, 520, 420 ) ) );
		emitter.addInitializer( new ScaleImageInit( 0.75, 2 ) );

		
		emitter.addAction( new Move() );
		RandomDrift drift = new RandomDrift( 15, 15 );
		emitter.addAction( drift );
		RectangleZone dzone = new RectangleZone( -2000, -10, 1000, 600 );
		DeathZone deathZone = new DeathZone( dzone, true );
		emitter.addAction( deathZone );
	
		
		emitter.start();
		emitter.runAhead( 10 );
		
	}
}
