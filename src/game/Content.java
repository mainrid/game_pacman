package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;


public class Content {
	
	public String map =  "####################/n"
					 +   "#..................#/n"
					 +   "#..................#/n"	
					 +	 "#....#.######......#/n"
					 +	 "#....#......#...#..#/n"
					 +	 "#.......#...#......#/n"
					 +	 "#....#..#..........#/n"
					 +	 "#....#......#......#/n"
					 +	 "#....#####.##..##..#/n"
					 +	 "#..................#/n"
					 +	 "#..............#...#/n"
					 +	 "#.......#.#........#/n"
					 +	 "#..................#/n"
					 +	 "#....####.####.....#/n"
					 +	 "#..................#/n"
					 +	 "#..................#/n"
					 +	 "#..................#/n"
					 +	 "#..................#/n"
					 +   "####################/n";	

	//Making an ArrayList, that contains elements of a map
	public float score=0;
	public static boolean gameState =true;
	public static String playagain;
	private ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>();
	public ArrayList<Ghost> ghosts= new ArrayList<Ghost>();
	
	public Content() {
		for (String s : map.split("/n")) {
			ArrayList<Character> row = new ArrayList<Character>();
			for (int i = 0; i < s.length(); i++) {
				row.add(s.charAt(i));
			}
			board.add(row);
		}
		ghosts.add(new Ghost((int)(Math.random()*18)+1,(int)(Math.random()*8)+1, Color.cyan));
		ghosts.add(new Ghost((int)(Math.random()*18)+1,(int)(Math.random()*8)+1, Color.blue));
		ghosts.add(new Ghost((int)(Math.random()*18)+1,(int)(Math.random()*8)+1, Color.GREEN));
	}
	// Retrieving width, height and an element from the map
	public int getHeight(){
		return board.size();
	}
	
	public int getWidth(){
		return board.get(0).size();
	}
	
	public char getElement(int x,int y){
		return board.get(x).get(y);
	}
	
	public void setElement(int x,int y, char c){
		board.get(y).set(x,c);
	}

	
	//pacman coordinates
	public float pacx =9, pacy=12;
	
	public static final int STILL=0;
	public static final int UP=1, DOWN=2;
	public static final int LEFT=3, RIGHT=4;
	
	public int pacdir=STILL;
	
	
	public void tick(){			
		int x=(int)pacx;
		int y=(int)pacy;
		
		//in case if wall
		if(getElement(y,x+1)=='#' && pacdir==RIGHT || getElement(y,x-1)=='#' && pacdir==LEFT 
		|| getElement(y+1,x)=='#' && pacdir==DOWN|| getElement(y-1,x)=='#' && pacdir==UP)
			pacdir=STILL;
		
		//moving pac
		if(pacdir==RIGHT)
			pacx+=.1;
		else if (pacdir==LEFT)
			pacx-=.1;
		else if (pacdir==UP)
			pacy-=.1;
		else if(pacdir==DOWN)
			pacy+=.1;
			
		//getting scores
		if (getElement(y,x)=='.'){
			setElement(x,y,' ');
			score=score+1;
			}
		//moving ghosts
		for (Ghost g: ghosts){
			g.dir(this);
			
			if(g.dir==LEFT)
				g.x-=.07;
			else if (g.dir==RIGHT)
				g.x+=.07;
			else if  (g.dir==UP)
				g.y-=.07;
			else
				g.y+=.07;
			
			//checks gamestate, if ghosts coordinates ==pac coordinates, game over.
			if((int)g.x==x && (int)g.y==y){
				gameState=false;
			}
		}
		System.out.println("Total score: " + score);
	}
	
}
