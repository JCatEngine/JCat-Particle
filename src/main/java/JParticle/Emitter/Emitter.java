package JParticle.Emitter;

import java.util.LinkedList;

import JCat.Display.Stage;
import JCat.Event.Event;
import JCat.Event.EventDispatcher;
import JParticle.Base.ActionPriority;
import JParticle.EmitterActions.EmitterAction;
import JParticle.Events.ParticleCreatedEvent;
import JParticle.ParticleActions.ParticleAction;
import JParticle.Particles.Particle;
import JParticle.Particles.ParticleFactory;
import JParticle.Particles.SharedParticleFactory;



	public class Emitter extends EventDispatcher
	{
		private static final int UNSTART = 0;
		private static final int RUNNING = 1;
		private static final int STOPED = 2;
		private static final int CLOSED = 3;
		
		
		/**
		 * factory used to creaed particle
		 */
		protected ParticleFactory particleFactory=SharedParticleFactory.getInstance();
		/**
		 * store all particleActions
		 */
		protected LinkedList<ParticleAction> particleActions=new LinkedList<>();
		/**
		 * store all emitterActions
		 */
		protected LinkedList<EmitterAction> emitterActions=new LinkedList<>();
		/**
		 * store all particles
		 */
		protected LinkedList<Particle> particles=new LinkedList<>();
		/**
		 * position of the emitter
		 */
		protected double x;
		protected double y;
		/**
		 * The rotation of the emitter in angle.
		 */
		public double rotation = 0;
		
		protected int state=UNSTART;
		
		
		public Emitter(Stage stage)
		{

			stage.addEventListener(Event.UPDATE, event -> loop());
		}
			
		
		protected void loop() {
			
			update();
			
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
		 * Adds an Action to the Emitter. Actions set the behaviour of particles 
		 * created by the emitter.
		 * 
		 * @param action The Action to add
		 * 
		 */
		public void addEmitterAction(EmitterAction action)
		{
			emitterActions.add(action);
			action.addedToEmitter( this );
		}
		
		/**
		 * Removes an Action from the Emitter.
		 * 
		 * @param action The Action to remove
		 * 
		 */
		public void removeEmitterAction(EmitterAction action)
		{
			emitterActions.remove(action);
			action.removedFromEmitter(this);
			
		}
		
		/**
		 * Detects if the emitter is using a emitter action or not.
		 * 
		 * @param action The action to look for.
		 * 
		 * @return true if the action is being used by the emitter, false 
		 * otherwise.
		 */
		public boolean hasEmitterAction(EmitterAction action)
		{
			return emitterActions.contains(action);
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
			particle.x=x;
			particle.y=y;
			particle.rotation=rotation;
		}

		

		
		/**
		 * Starts the emitter. Until start is called, the emitter will not emit or 
		 * update any particles.
		 */
		public void start()
		{
			if(state==UNSTART)
			{
				state=RUNNING;
				//run start action
				startEmitterAction();
				
			}
			else
			{
				throw new RuntimeException("can't start emitter");
			}
		}
		
		
		
		private void startEmitterAction() {
			//run high
			for (EmitterAction emitterAction : emitterActions) {
				if(emitterAction.getPriority()==ActionPriority.HIGH)
				{
					emitterAction.start(this);
				}
			}
			//run low
			for (EmitterAction emitterAction : emitterActions) {
				if(emitterAction.getPriority()==ActionPriority.LOW)
				{
					emitterAction.start(this);
				}
			}
			
			
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
		 */
		public void update()
		{
			if(state==RUNNING)
			{
				//check particle dead
				
				updateAction();
				
			}
			
		}
		
		
		private void updateAction() {
			// TODO Auto-generated method stub
			//run high
			for (EmitterAction emitterAction : emitterActions) {
				if(emitterAction.getPriority()==ActionPriority.HIGH)
				{
					emitterAction.update(this);
				}
			}
			//run low
			for (EmitterAction emitterAction : emitterActions) {
				if(emitterAction.getPriority()==ActionPriority.LOW)
				{
					emitterAction.update(this);
				}
			}
			//run high
			for (ParticleAction particleAction : particleActions) {
				if(particleAction.getPriority()==ActionPriority.HIGH)
				{
					for (Particle particle : particles) {
						particleAction.update(particle);
					}
					
				}
			}
			//run low
			for (ParticleAction particleAction : particleActions) {
				if(particleAction.getPriority()==ActionPriority.LOW)
				{
					for (Particle particle : particles) {
						particleAction.update(particle);
					}
					
				}
			}
		}


		/**
		 * Pauses the emitter.
		 */
		public void pause()
		{
			if(state==RUNNING)
			{
				state=CLOSED;
			}
			else
			{
				throw new RuntimeException("can't pause emitter!");
			}
		}
		
		
		
		/**
		 * Stops the emitter, killing all current particles and returning them to the 
		 * particle factory for reuse.
		 */
		public void close()
		{
			state=CLOSED;
			
			_releaseData();
		}

		/**
		 * release data
		 */
		private void _releaseData() {
			// TODO Auto-generated method stub
			
		}


		public void createPartices(int amount) {
			for (int i = 0; i < amount; i++) {
				Particle particle=particleFactory.createParticle();
				particles.add(particle);
				
				//apply init event
				startParticleAction(particle);
				dispatchEvent(new ParticleCreatedEvent(particle));
			}
			
		}


		private void startParticleAction(Particle particle) {
			//run high
			for (ParticleAction particleAction : particleActions) {
				if(particleAction.getPriority()==ActionPriority.HIGH)
				{
						particleAction.start(particle);
					
				}
			}
			//run low
			for (ParticleAction particleAction : particleActions) {
				if(particleAction.getPriority()==ActionPriority.LOW)
				{
						particleAction.start(particle);
				}
			}
			
		}
		
		
	}
