package game;

import java.awt.Color;



public class Ghost {
	float x,y;
	Color color;
	int dir;
	
	public Ghost(float x, float y, Color color){
		this.x=x;
		this.y=y;
		this.color=color;
	}
	
	public void dir(Content world){
		float dx= world.pacx-x;
		float dy=world.pacy-y;
		
		if (Math.abs(dx)>Math.abs(dy))
			if(dx>0)
				dir=world.RIGHT;
			else
				dir=world.LEFT;
		else{
			if(dy>0)
				dir=world.DOWN;
			else
				dir=world.UP;
		}
	}
}
