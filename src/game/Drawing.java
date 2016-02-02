package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;



public class Drawing extends JPanel{
	private static final long serialVersionUID = 1L;
	private static final int T = 40;
	
	private Content pacworld;

	public Drawing(Content pacworld){
		this.pacworld=pacworld;
	}
	
	//Draw map 
	public void paint (Graphics g){
			
		for (int x = 0; x < pacworld.getHeight(); x++) {
			for (int y = 0; y < pacworld.getWidth(); y++) {
				char c= pacworld.getElement(x, y);
				switch(c){
				case '#':{ 
					g.setColor(Color.BLACK);
					g.fillRect(y*T, x*T, T, T);break;}
				case '.': 
					g.setColor(Color.darkGray);
					g.fillOval(y*T+T/3, x*T+T/3, T/4, T/4); break;
				default: System.out.println(c);
				}
			}
		}

		
		//Draw pacman
		if(pacworld.pacdir==pacworld.RIGHT || pacworld.pacdir==pacworld.STILL){
			g.setColor(Color.orange);
			pacworld.tick();
			g.fillArc((int)pacworld.pacx*T, (int)pacworld.pacy*T, T, T, 30, 300);}
		else if(pacworld.pacdir==pacworld.LEFT) {
			g.setColor(Color.orange);
			pacworld.tick();
			g.fillArc((int)pacworld.pacx*T, (int)pacworld.pacy*T, T, T, 200, 300);}
		else if(pacworld.pacdir==pacworld.UP){
			g.setColor(Color.orange);
			pacworld.tick();
			g.fillArc((int)pacworld.pacx*T, (int)pacworld.pacy*T, T, T, 110, 300);}
		else if(pacworld.pacdir==pacworld.DOWN){
			g.setColor(Color.orange);
			pacworld.tick();
			System.out.println(pacworld.pacy);
			g.fillArc((int)pacworld.pacx*T, (int)pacworld.pacy*T, T, T, 290, 300);}
		//Draw score message
		if(Content.gameState==true)
			g.drawString("Your score: "+ String.valueOf((int)pacworld.score-1), pacworld.getWidth()/2*(T-5), 20);
		else{
			g.drawString("You have been eaten!!! Your total score is: "+ String.valueOf((int)pacworld.score-1), pacworld.getWidth()/2*(T-15), 15);
			g.drawString("Please enter 'y' to play again or 'n' to finish", pacworld.getWidth()/2*(T-15), 30);
			}
		//Draw ghosts		
		for (Ghost ghost: pacworld.ghosts){
			g.setColor(ghost.color);
			g.fillOval((int)(ghost.x*T), (int)(ghost.y*T), T, T);
			g.fillRect((int)(ghost.x*T), (int)(ghost.y*T) +T/2, T, T/2);
			g.setColor(Color.WHITE);
			g.fillOval((int)(ghost.x*T)+T/4, (int)(ghost.y*T)+T/4, T/6, T/6);
			g.fillOval((int)(ghost.x*T)+T/2, (int)(ghost.y*T)+T/4, T/6, T/6);
		}			
		
	}
		
	}

