import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocks;
ArrayList<Projectile> projectiles=new ArrayList<Projectile>();
ArrayList<Alien> aliens=new ArrayList<Alien>();
Random random=new Random();
ObjectManager(Rocketship rocks){
	this.rocks=rocks;
}
void addProjectile(Projectile pro) {
	projectiles.add(pro);
	
}
void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update() {
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).update();
	}
}
void draw(Graphics g){
	rocks.draw(g);
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).draw(g);
	}
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).draw(g);
	}
}
void purgeObjects(){
	for (int i = 0; i < aliens.size(); i++) {
		if(!aliens.get(i).isActive) {
			aliens.remove(i);
			}
	
		
	}
	for (int i = 0; i < projectiles.size(); i++) {
		if(!projectiles.get(i).isActive) {
			projectiles.remove(i);
		}
	}
}
}
