package JParticle.Particles;

import JCat.Display.DisplayObject;
import JCat.Display.Texture;

	/**
	 * The Particle class is a set of public properties shared by all particles.
	 * It is deliberately lightweight, with only one method. The Initializers
	 * and Actions modify these properties directly. This means that the same
	 * particles can be used in many different emitters, allowing Particle 
	 * objects to be reused.
	 * 
	 * Particles are usually created by the ParticleCreator class. This class
	 * just simplifies the reuse of Particle objects which speeds up the
	 * application. 
	 */
	public class Particle
	{
		/**
		 * The x coordinate of the particle in pixels.
		 */
		public double x = 0;
		/**
		 * The y coordinate of the particle in pixels.
		 */
		public double y = 0;
		/**
		 * The scale of the particle ( 1 is normal size ).
		 */
		public double scale = 1;	
		/**
		 * The object used to display the image. In a 2D particle, this is usually
		 * a DisplayObject. In a 3D particle, this may be a DisplayObject, for 
		 * displaying on a billboard or similar, or a 3D object in the form used
		 * by the render system.
		 */
		public Texture texture = null;
		/**
		 * Whether the particle is dead and should be removed from the stage.
		 */
		public boolean isDead = false;
		/**
		 * rotation
		 */
		public double rotation=0;
		/**
		 * alpha
		 */
		public double alpha=1;
		/**
		 * speed
		 */
		public double speed=0;
		
		
		/**
		 * Creates a particle. Alternatively particles can be reused by using the ParticleCreator to create
		 * and manage them. Usually the emitter will create the particles and the user doesn't need
		 * to create them.
		 */
		public Particle()
		{
			
			reset();
		}
		

		public void reset()
		{
			scale=1;
			texture=null;
			isDead=false;
			speed=0;
			alpha=1;
			rotation=0;
		}


		public void update() {
			
			double speedX=Math.cos(rotation)*speed;
			double speedY=Math.sin(rotation)*speed;
			
			x+=speedX;
			y+=speedY;
			
		}
	}

