import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocks;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score=0;
	
	int getScore() {
		return score;
	}

	ObjectManager(Rocketship rocks) {
		this.rocks = rocks;
	}

	void addProjectile(Projectile pro) {
		projectiles.add(pro);

	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		rocks.update();
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		rocks.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isActive) {
				aliens.remove(i);
			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}

	void checkCollision() {
		for (Alien alien : aliens) {
			if (rocks.collisionBox.intersects(alien.collisionBox)) {
				rocks.isActive = false;
				
				break;
			}
			for (Projectile pro : projectiles) {
				if (alien.collisionBox.intersects(pro.collisionBox)) {
					alien.isActive = false;
					pro.isActive = false;
					score+=1;
				}
			}
		}
	}
}
