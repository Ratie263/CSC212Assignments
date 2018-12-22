package edu.smith.cs.csc212.p1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

import me.jjfoley.gfx.GFX;

public class Aquarium extends GFX {

	int fish1X = getWidth() + 100;
	int fish2X = getWidth() + 300;
	int fish3X= getWidth()+200;
	public static int LEFT_SIDE_OF_SCREEN=0;
	public static int RIGHT_SIDE_OF_SCREEN=500;
	
	//wave of a school of white ghostly fish
	Wave[] waves=new Wave[30];
	BubbleSystem[] bubbles=new BubbleSystem[10];
	//draws Little and big fish
	Fish[] bigFish=new Fish[5];
	Fish[] smallFish=new Fish[5];
	
	
	HungryFish nemo= new HungryFish(Color.red, false);
	Snail david= new Snail(Color.white.darker(), Color.white, Color.red);
	
public Aquarium() {
		
		for (int i=0; i<bubbles.length; i++) {
		bubbles[i]= new BubbleSystem(Color.white);
		}
		for (int big=0; big<bigFish.length; big++) {
			bigFish[big]= new Fish(Color.pink.darker(), true);
		}
		for (int small=0; small<smallFish.length; small++) {
			smallFish[small]= new Fish(Color.orange.darker(), false);
		}
		for (int i=0; i<waves.length; i++) {
			waves[i]= new Wave(Color.white);
		}
		
}
	
	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background. Its really deep undersea, so its really dark!
		g.setColor(new Color(20, 20, 50));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//Lawn
		g.setColor(Color.green.darker());
		g.fillRect(0,490, 500, 500);
		
		
		// This section Draws Bubbles, fish and waves of fish	
		for (Wave w:this.waves) {
			w.draw(g);
		}
		for (BubbleSystem b:this.bubbles) {
			b.draw(g);
		}
		for (Fish f:this.smallFish) {
			f.draw(g);
			
		}
		for (Fish m:this.bigFish) {
			m.draw(g);
		}
		Creatures.drawTreasureChest(g);
		nemo.draw(g);
		david.draw(g );
				
	}

	public static void main(String[] args) {
		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
