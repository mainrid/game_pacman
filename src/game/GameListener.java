package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class GameListener implements KeyListener{
	
	Content world;
	
	public GameListener(Content world){
		this.world=world;
	}
	@Override
	public void keyPressed(KeyEvent k) {
		int code=k.getKeyCode();
	
		if (code==KeyEvent.VK_LEFT){
			world.pacdir=world.LEFT;}
		else if(code==KeyEvent.VK_RIGHT)
			world.pacdir=world.RIGHT;
		else if(code==KeyEvent.VK_UP)
			world.pacdir=world.UP;
		else if(code==KeyEvent.VK_DOWN)
			world.pacdir=world.DOWN;
		else if(code==KeyEvent.VK_Y){
			Content.playagain="y";
			System.out.println(Content.playagain);}
		else if(code==KeyEvent.VK_N)
			Content.playagain="n";

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
