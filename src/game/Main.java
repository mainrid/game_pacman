package game;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	public static boolean play =true;
	
	Content world= new Content();
	Drawing pac= new Drawing(world);
	JButton button=new JButton();
	
	//JFrame constructor
	public Main(){
		super("Pac man");
		setBackground(Color.LIGHT_GRAY);
		setSize(world.getWidth()*40, world.getHeight()*40);
		add(pac);		
		addKeyListener(new GameListener(world));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {		
		do {	
			Main mainWindow=new Main();
			while(Content.gameState){	
			mainWindow.repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {}
			}
			
			Content.playagain=null;
			while(Content.playagain!="y" && Content.playagain!="n" ){
				System.out.println("Enter y or n");
			}
			if(Content.playagain=="y"){	
				play=true;
				Content.gameState=true;
				mainWindow.dispose();				
			}else if(Content.playagain=="n")
				play=false;;
		} while(play);
			System.exit(0);
		

		}}
	
	

