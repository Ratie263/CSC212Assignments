package edu.smith.cs.csc212.p1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {

	Color color;
	
	boolean isLittle;
	boolean isFacingLeft;
	double x;
	double y;
	double targetX;
	double targetY;
	double bubbleX;
	double bubbleY;
	double speed;


	public Fish(Color color, boolean isLittle) {
		Random rand= new Random();
		
		this.x= rand.nextInt(500);
		this.y= rand.nextInt(500);
		this.targetX=rand.nextInt(500);
		this.targetY=rand.nextInt(500);
		this.color= color;
		this.isLittle = isLittle;
						
		this.speed=1;
		
	}
		public void swim() {
			
			double dx= targetX-x;
			double dy= targetY-y;
			double r= Math.sqrt(dx*dx+dy*dy);
			
			// makes fish chase its target
			this.x+=(dx/r)*speed;
			this.y+=(dy/r)*speed;
			
			if (this.speed>r) {
				Random rand= new Random();
				this.targetX=rand.nextInt(500);
				this.targetY=rand.nextInt(500);
				
				}
			
			
			}
				 
		//Draws the fist depending on their direction and size
	public void draw(Graphics2D world) {
		int x=(int) this.x;
		int y=(int) this.y;
	
		
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
		swim();
	
			
	}
	
}	
			
		
		
			
		
		
		
		
		
			
		

	

	
