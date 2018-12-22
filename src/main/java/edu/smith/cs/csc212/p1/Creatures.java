package edu.smith.cs.csc212.p1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

/**
 * This class is based on a class in CSC212Examples.
 * 
 * @author jfoley
 *
 */
public class Creatures {
	/**
	 * This code based on the Python fish in CSC111 labs, e.g.,
	 * https://jcrouser.github.io/CSC111/labs/lab-10-animation.html
	 * 
	 * @author jfoley
	 */
	
	//This part draws fish depending on their size and the direction they are facing
	public static void drawFishFacingLeft(Graphics2D g, Color color, int x, int y) {
		
		g.setColor(color);
		Shape body = new Ellipse2D.Double(x - 40, y - 20, 80, 40);
		Shape tail = new Ellipse2D.Double(x + 30, y - 30, 20, 60);
		Shape eye = new Ellipse2D.Double(x - 15, y - 10, 10, 10);

		g.fill(body);

		// draw body outline.
		g.setColor(Color.black);
		g.draw(body);

		// draw eye (still black):
		g.fill(eye);

		// draw tail:
		Color tailColor = color.darker();
		g.setColor(tailColor);
		g.fill(tail);

		// draw tail outline.
		g.setColor(Color.black);
		g.draw(tail);
	}
	
	/**
	 * This method is implemented by creating a new Graphics "world" located at x,y
	 * that is scaled in a "backwards" X world.
	 * 
	 * @param g the original graphics world.
	 * @param color the color of the fish!
	 * @param x the x-coordinate of the position to draw the fish.
	 * @param y the y-coordinate of the position to draw the fish.
	 */
	public static void drawFishFacingRight(Graphics2D g, Color color, int x, int y) {
		Graphics2D flipped = (Graphics2D) g.create();
		flipped.translate(x, y);
		flipped.scale(-1, 1);
		drawFishFacingLeft(flipped, color, 0, 0);
		flipped.dispose();
	}
	
	/**
	 * This method is implemented by creating a new Graphics "world" located at x,y
	 * that is half the size of a regular one and calling our regular Fish method.
	 * 
	 * @param g the original graphics world.
	 * @param color the color of the fish!
	 * @param x the x-coordinate of the position to draw the fish.
	 * @param y the y-coordinate of the position to draw the fish.
	 */
	public static void drawSmallFishFacingLeft(Graphics2D g, Color color, int x, int y) {
		Graphics2D halfSize = (Graphics2D) g.create();
		halfSize.translate(x, y);
		halfSize.scale(0.5, 0.5);
		drawFishFacingLeft(halfSize, color , 0, 0);
		halfSize.dispose();
	}
	public static void drawSharkFacingRight(Graphics2D g, Color color, int x, int y) {
			Graphics2D flipped = (Graphics2D) g.create();
			flipped.translate(x, y);
			flipped.scale(-2, 2);
			drawFishFacingLeft(flipped, Color.GRAY, 0, 0);
			flipped.dispose();
		}
	public static void drawSharkFacingLeft(Graphics2D g, Color color, int x, int y) {
		Graphics2D flipped = (Graphics2D) g.create();
		flipped.translate(x-100, y);
		flipped.scale(2, -2);
		drawFishFacingLeft(flipped, Color.GRAY, 0, 0);
		flipped.dispose();
	}
	public static void drawSmallFishFacingRight(Graphics2D g, Color color, int x, int y) {
		Graphics2D halfSize = (Graphics2D) g.create();
		halfSize.translate(x, y);
		halfSize.scale(0.5, 0.5);
		drawFishFacingRight(halfSize, color, 0, 0);
		halfSize.dispose();
	}
		public static void drawTinyFishFacingLeft(Graphics2D g, Color color, int x, int y) {
			Graphics2D halfSize = (Graphics2D) g.create();
			halfSize.translate(x, y);
			halfSize.scale(0.2, 0.2);
			drawFishFacingLeft(halfSize, color , 0, 0);
			halfSize.dispose();
		}

	public static void drawTreasureChest(Graphics2D g){
		// Draw the treasureChest or mini castle(from the way its not looking!)
		g.setColor(Color.orange);
		Shape treasureChest= new Rectangle2D.Double(200,470,90,50);
		Shape treasureChest2=new Rectangle2D.Double(220,450,50,25);
		Shape treasureChest3=new Rectangle2D.Double(230,440,10,25);
		Shape treasureChest4=new Rectangle2D.Double(250,440,10,25);
		Shape Door=new Rectangle2D.Double(240,480,10,20);
		g.fill(treasureChest);
		g.fill(treasureChest2);
		g.fill(treasureChest3);
		g.fill(treasureChest4);
		g.setColor(Color.BLACK);
		g.fill(Door);
		
}
	
	public static void drawSnail(Graphics2D g, Color bodyColor, Color shellColor, Color eyeColor){
		// Draw the snail.
		g.setColor(bodyColor);
		Shape snailBody= new Rectangle2D.Double(410,0,70,100);
		g.fill(snailBody);
		
		// Draw the eyes
		Shape snailEye1=new Rectangle2D.Double(420,100,10,40);
		Shape snailEye2=new Rectangle2D.Double(460,100,10,40);
		g.setColor(Color.GRAY);
		g.fill(snailEye1);
		g.fill(snailEye2);
		
		Shape eyeBall1=new Ellipse2D.Double(410,130,25,25);
		Shape eyeBall2=new Ellipse2D.Double(450,130,25,25);
		g.setColor(Color.white);
		g.fill(eyeBall1);
		g.fill(eyeBall2);
		
	
		Shape innerEyeBall1=new Ellipse2D.Double(420,140,10,10);
		Shape innerEyeBall2=new Ellipse2D.Double(460,140,10,10);
		g.setColor(Color.black);
		g.fill(innerEyeBall1);
		g.fill(innerEyeBall2);
		
		// Draws shell
		Shape shell=new Ellipse2D.Double(460,0,100,100);		
		g.setColor(Color.GRAY.darker());
		g.fill(shell);
		Shape innerShell=new Ellipse2D.Double(490,20,50,50);
		g.setColor(Color.GRAY);
		g.fill(innerShell);
		
		//Draws smile
		Shape smile=new Rectangle2D.Double(420,20,10,5);
		g.setColor(Color.black);
		g.fill(smile);
		
	}
		
	public static void drawBubbles(Graphics2D g, Color color, int x, int y) {
		// Draw the bubbles.
		Random rand= new Random();
		int bubbleSize= rand.nextInt(10);
		g.setColor(color);

		Shape bubble = new Ellipse2D.Double(x - 15, y - 10, bubbleSize, bubbleSize);

		// draw bubble
		g.setColor(Color.white);
		g.fill(bubble);
	
	}

		
}

