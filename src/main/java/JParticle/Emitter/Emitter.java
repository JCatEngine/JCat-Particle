package JParticle.Emitter;

import java.util.LinkedList;

import JCat.Event.EventDispatcher;
import JParticle.EmitterActions.EmitterAction;
import JParticle.ParticleActions.ParticleAction;
import JParticle.Particles.Particle;
import JParticle.Particles.ParticleFactory;
import JParticle.Particles.SharedParticleFactory;



	public class Emitter extends EventDispatcher
	{
		/**
		 * @private
		 */
		protected ParticleFactory _particleFactory=SharedParticleFactory.getInstance();
		
		/**
		 * @private
		 */
		protected LinkedList<ParticleAction> particleActions=new LinkedList<>();
		/**
		 * @private
		 */
		protected LinkedList<EmitterAction> emitterActions=new LinkedList<>();
		/**
		 * @private
		 */
		protected LinkedList<Particle> particles=new LinkedList<>();
		/**
		 * @private
		 */
		protected boolean _running = false;
		/**
		 * @private
		 */
		
		public Emitter()
		{
			
		}
			
		
		/**
		 * Adds an Action to the Emitter. Actions set the behaviour of particles 
		 * created by the emitter.
		 * 
		 * @param action The Action to add
		 * 
		 * @see removeAction();
		 * @see org.flintParticles.common.actions.Action.getDefaultPriority()
		 */
		public void addParticleAction(ParticleAction action)
		{
			particleActions.add(action);
			action.addedToEmitter( this );
		}
		
		/**
		 * Removes an Action from the Emitter.
		 * 
		 * @param action The Action to remove
		 * 
		 * @see addAction()
		 */
		public void removeParticleAction(ParticleAction action)
		{
			particleActions.remove(action);
			action.removedFromEmitter(this);
			
		}
		
		/**
		 * Detects if the emitter is using a particular action or not.
		 * 
		 * @param action The action to look for.
		 * 
		 * @return true if the action is being used by the emitter, false 
		 * otherwise.
		 */
		public boolean hasParticleAction(ParticleAction action)
		{
			return particleActions.contains(action);
		}
			
		
		/**
		 * Emitters do their own particle initialization here - usually involves 
		 * positioning and rotating the particle to match the position and rotation 
		 * of the emitter. This method is called before any initializers that are
		 * assigned to the emitter, so initializers can  any properties set 
		 * here.
		 * 
		 * <p>The implementation of this method in this base class does nothing.</p>
		 */
		protected void initParticle(Particle particle)
		{
			
		}

		

		
		/**
		 * Starts the emitter. Until start is called, the emitter will not emit or 
		 * update any particles.
		 */
		public void start()
		{
			
		}
		
		
		
		/**
		 * Used to update the emitter. If using the internal tick, this method
		 * will be called every frame without any action by the user. If not
		 * using the internal tick, the user should call this method on a regular
		 * basis to update the particle system.
		 * 
		 * <p>The method asks the counter how many particles to create then creates 
		 * those particles. Then it calls sortParticles, applies the activities to 
		 * the emitter, applies the Actions to all the particles, removes all dead 
		 * particles, and finally dispatches an emitterUpdated event which tells 
		 * any renderers to redraw the particles.</p>
		 * 
		 * @param time The duration, in seconds, to be applied in the update step.
		 * 
		 * @see sortParticles();
		 */
		public void update(double time)
		{
			if(_running )
			{
				
			}
			
		}
		
		
		/**
		 * Pauses the emitter.
		 */
		public void pause()
		{
			_running = false;
		}
		
		/**
		 * Resumes the emitter after a pause.
		 */
		public void resume()
		{
			_running = true;
		}
		
		/**
		 * Stops the emitter, killing all current particles and returning them to the 
		 * particle factory for reuse.
		 */
		public void stop()
		{
			
		}
		
		
	}
