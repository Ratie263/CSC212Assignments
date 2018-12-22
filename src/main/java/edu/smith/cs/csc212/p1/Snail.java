package edu.smith.cs.csc212.p1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;


public class Snail {
	    Color shellColor;
	    Color bodyColor;
	    Color eyeColor;
	    		
		double snailX;
		double snailY;
				
		public Snail(Color shellColor, Color bodyColor, Color eyeColor) {
				
				this.shellColor=shellColor;
				this.bodyColor=shellColor;
				this.eyeColor=shellColor;
												
		}	   
		// Draws our snail
		public void draw(Graphics2D world) {
				  Graphics2D translated = (Graphics2D) world;
				  translated.translate(snailX, snailY);
				  Creatures.drawSnail(translated, bodyColor, shellColor, eyeColor);
				  translated.dispose();
				
				  //stops snail from moving off screen
				  if (snailX>-400) {
					  this.snailX-=1;
					  this.snailY=0;
				  }
				  
				  if (snailX<=-400) {
					  System.out.print(snailX);
					  this.snailY=-10;
					  this.snailX=0;
					 
					}
			
			}
	
	}



