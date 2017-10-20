package JParticle.ParticleActions;

import JCat.Display.Texture;
import JCat.Manager.TextureManager;
import JParticle.Particles.Particle;

public class InitTexture extends ParticleAction{

	private Texture texture;

	public InitTexture(String name) {
		texture=TextureManager.getInstance().getTextureByName(name);
	}

	@Override
	public void update(Particle particle) {
		
	}

	@Override
	public void start(Particle particle) {
		particle.texture=texture;
		
	}

}
