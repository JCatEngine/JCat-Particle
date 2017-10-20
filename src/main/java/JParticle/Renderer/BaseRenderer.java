package JParticle.Renderer;

import JParticle.Emitter.Emitter;

public interface BaseRenderer {

	/**
	 * Add an emitter to this renderer. The renderer should draw all the 
	 * particles that are being managed by the emitter.
	 * 
	 * @param emitter The emitter whose particles should be drawn by the 
	 * renderer
	 */ void addEmitter(Emitter emitter);

	/**
	 * Stop rendering particles that are managed by this emitter.
	 * 
	 * @param emitter The emitter whose particles should no longer be
	 * drawn by the renderer.
	 */ void removeEmitter(Emitter emitter);
}
