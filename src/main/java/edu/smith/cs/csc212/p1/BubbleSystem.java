package edu.smith.cs.csc212.p1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class BubbleSystem {
	
	Color color;
	
	double bubbleX;
	int bubbleY;
	int numBubbles;
	
	int randomPosition;
	//this.radius=ThreadLocalRandom.current() .nextInt(5,15+1);
	
	public BubbleSystem(Color color) {
			
			this.color=color;
			Random rand= new Random();
			this.bubbleX= 502;
			this.bubbleY= rand.nextInt(500);
			
			
		}
	//makes bubbles move up and loop
	public void move() {
			
		this.bubbleY-=1;
		double A= 5.0;
		double W= 10.0;
		
		// this part akes the bubble move in a sin manner
		this.bubbleX=(int)(A*Math.sin(bubbleY/W)+250);
		this.bubbleY-=1;
		if (bubbleY<0) {
			Random rand= new Random();
			this.bubbleY=510;
			this.bubbleX=rand.nextInt(500);
			
			}
		   
}
	//Draws the bubbles
	public void draw(Graphics2D world) {
		int bubbleX=(int) this.bubbleX;
		
		Creatures.drawBubbles(world, color, bubbleX, bubbleY);
		
		
		move();
		}
}
