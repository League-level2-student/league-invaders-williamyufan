import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	public static final int WIDTH=500;
	public static final int HEIGHT=800;
	GamePanel gamepanel;
	
	public static void main(String[] args) {
		 LeagueInvaders g=new LeagueInvaders();
			g.setup();
		}

public LeagueInvaders() {
	frame=new JFrame();
	gamepanel=new GamePanel();
	frame.addKeyListener(gamepanel);
}
void setup() {
	frame.add(gamepanel);
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
}