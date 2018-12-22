package edu.smith.cs.csc212.p1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class HungryFish {
		
		Color color;
		boolean isLittle;
		boolean isFacingLeft;
		double x;
		double y;
		double targetX;
		double targetY;
		double speed;
		double sharkX;
		double sharkY;

		
	public HungryFish(Color color, boolean isLittle) {
		
		Random rand= new Random();
		this.x= rand.nextInt(500);
		this.y= rand.nextInt(500);
		this.targetX=rand.nextInt(500);
		this.targetY=rand.nextInt(500);
		
		this.color= color;
		this.isLittle = isLittle;
		this.speed=3;
	
	}
	
	// makes fish swim around	
	public void swim() {
			
		double dx= targetX-x;
		double dy= targetY-y;
		double r= Math.sqrt(dx*dx+dy*dy);
		
		this.x+=(dx/r)*speed;
		this.y+=(dy/r)*speed;
	
		if (this.speed>r) {
			Random rand= new Random();
			this.targetX=rand.nextInt(500);
			this.targetY=rand.nextInt(500);
			System.out.println("yes");
			}
	}
	
	// Jaws chases hungry Fish!
	public void chase() {
		
		double dx= x-sharkX;
		double dy= y-sharkY;
		double r= Math.sqrt(dx*dx+dy*dy);
		
		this.sharkX+=(dx/r)*speed;
		this.sharkY+=(dy/r)*speed;
		
		//shark chases next fish
		if (this.sharkX>r) {
			Random rand= new Random();
			this.targetX=rand.nextInt(500);
			this.targetY=rand.nextInt(500);
			
			}
		//Shark eats hungry fish, but hungry fish gives a fight!
		if((sharkX==x)==true){
			this.targetX=-5000;
			this.targetY=-5000;
			
		}
			//shark chases next fish
		if (this.sharkX>r) {
			Random rand= new Random();
			this.targetX=rand.nextInt(500);
			this.targetY=rand.nextInt(500);
		}
			else if((sharkX==x)==true){
				this.x-=1;
				this.targetX=-5000;
				this.targetY=-5000;
		
		}
	}
		//Draws shard and Hungry Fish
		public void draw(Graphics2D world) {
							
				int x=(int) this.x;
				int y=(int) this.y;
				int sharkX=(int)this.sharkX;
				int sharkY=(int) this.sharkY;
					
			if ((this.x==targetX)&&(this.y==targetX)) {
				Random rand= new Random();
				this.targetX=rand.nextInt(500);
				this.targetY=rand.nextInt(500);
			}
			if ((isLittle== true)&&(x>targetX==true)) {
				 
				Creatures.drawSmallFishFacingLeft(world, color, x,y);
					
			}
			else if ((isLittle==true)&&(x>targetX==false)) {
				Creatures.drawSmallFishFacingRight(world, color, x,y);
			}
				
			else if ((isLittle==false)&&(x<targetX==false)) {
				Creatures.drawFishFacingLeft(world, color, x,y);
				}
			
			else {
				Creatures.drawFishFacingRight(world, color, x,y);
				
			}
			if((sharkX>x==true)) {

				Creatures.drawSharkFacingLeft(world, color, sharkX, sharkY);
				
				}
			
				else {
					
					Creatures.drawSharkFacingRight(world, color, sharkX, sharkY);
		}	
			//makes fish swim
			swim();
			
			// Shark Chases hungry fish!
			chase();
		
		}
	}
