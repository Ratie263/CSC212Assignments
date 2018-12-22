package edu.smith.cs.csc212.p1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Wave{
	
	Color color;
	
	double waveY;
	int waveX;
		
	public Wave(Color color) {
			
			this.color=color;
			Random rand= new Random();
			this.waveY= rand.nextInt(500);
			this.waveX= rand.nextInt(500);
				
		}
	public void move() {

		this.waveX-=1;
		
		double A= 100.0;
		double W= 80.0;
			
		//makes our tiny school of fish swim in a sin manner
		this.waveY=(int)(A*Math.sin(waveX/W)+250);
	
		if (waveX<0) {
			Random rand= new Random();
			this.waveX=510;
			this.waveY=rand.nextInt(500);
			System.out.println("yes");
			}
		   
}
	public void draw(Graphics2D world) {
		int waveY=(int) this.waveY;
		
		Creatures.drawTinyFishFacingLeft(world, color, waveX, waveY);
		
		move();
		}
}
