import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font startfont;
	Font instructionsFont;
	Font gameoverfont;
	Timer frameDraw;
	Rocketship rocketship=new Rocketship(260, 700, 50, 50);
	ObjectManager obman=new ObjectManager(rocketship);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Timer alienSpawn;
	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startfont = new Font("Arial", Font.PLAIN, 18);
		instructionsFont = new Font("Arial", Font.PLAIN, 8);
		gameoverfont = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}
		obman.getScore();
	}

	void updateMenuState() {
		
	}

	void updateGameState() {
		obman.update();
		if(rocketship.isActive==false) {
			currentState=END;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
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
		g.drawString("Press SPACE (it is the longest key on a keboard) for Instructions", 10, 600);
	}

	void drawGameState(Graphics g) {
		
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		obman.draw(g);
	}

	
	private void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(gameoverfont);
		g.setColor(Color.WHITE);
		g.drawString("Game Over", 10, 500);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}
	void startGame(){
		alienSpawn=new Timer(1000, obman);
		alienSpawn.start();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			rocketship=new Rocketship(260, 700, 50, 50);
			obman=new ObjectManager(rocketship);
			} else {
				currentState++;
				if(currentState==GAME) {
					startGame();
				}
				else if(currentState==END) {
					alienSpawn.stop();
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.up();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.down();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.left();
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.right();
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(currentState==GAME) {
		obman.addProjectile(rocketship.getProjectile());
			}
		}
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
