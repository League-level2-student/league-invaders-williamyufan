import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	final int MENU=0;
	final int GAME=1;
	final int END=2;
	int currentState=MENU;
	Font titleFont;
	Font startfont;
	Font instructionsFont;
	Font gameoverfont;
	GamePanel(){
		 titleFont = new Font("Arial", Font.PLAIN, 48);
		 startfont=new Font("Arial", Font.PLAIN, 18);
		 instructionsFont=new Font("Arial", Font.PLAIN, 8);
		 gameoverfont=new Font("Arial", Font.PLAIN, 48);
		 
	}
	void updateMenuState(){
		
	}
	void updateGameState() {
		
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 10, 100);
		g.setFont(startfont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to Start", 10, 300);
		g.setFont(instructionsFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE (it is the ongest key on a keboard) for Instructions", 10, 600);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(gameoverfont);
		g.setColor(Color.WHITE);
		g.drawString("Game Over", 10, 500);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	
	}

