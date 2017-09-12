import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Overwatcher {
	ArrayList<GameObject> objects;
	Tracer quill;
	Color dark1 = new Color(100, 50, 50);
	Color dark2 = new Color(200, 50, 80);
	Color dark3 = new Color(250, 100, 10);
	Color dark4 = new Color(49, 0, 26);

	long enemyTimer = 0;
	int enemySpawnTime = 1;
	int Playerbulletdamage = 1;

	public Overwatcher(Tracer quill) {
		objects = new ArrayList<GameObject>();
		this.quill = quill;
	}

	public void addObject(int i, GameObject o) {
		if (i != -10) {
			objects.add(i, o);
		} else {
			objects.add(o);
		}

		System.out.println("object added");
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		// checkCollision();
		// purgeObjects();
	}

	public void draw(Graphics g) {
		System.out.println("over before");
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
			System.out.println("object is drawn");
		}
	}

	public Projectile getCurrentProjectile() {
		int i = objects.size();
		GameObject j = objects.get(i);
		if (j instanceof Projectile) {
			return (Projectile) j;
		}
		return null;

	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
				System.out.println("object purged");
			}
		}
	}

	// public void checkCollision() {
	// for (int i = 0; i < objects.size(); i++) {
	// for (int j = i + 1; j < objects.size(); j++) {
	// // what is the purpose of the 'i' for loop enclosing the 'j' for
	// // loop?
	// GameObject o1 = objects.get(i);
	// GameObject o2 = objects.get(j);
	//
	// if (o1.collisionArea.intersects(o2.collisionArea)) {
	//
	// if ((o1 instanceof Enemy && o2 instanceof Projectile)
	// || (o2 instanceof Enemy && o1 instanceof Projectile)) {
	// Projectile bullet = (o1 instanceof Projectile) ? (Projectile) o1 :
	// (Projectile) o2;
	// Enemy shotEnemy = (o1 instanceof Enemy) ? (Enemy) o1 : (Enemy) o2;
	// // if (quill.onScreenRoom.level % 5 == 0) {
	// // Playerbulletdamage = quill.onScreenRoom.level / 5;
	// // }
	// // shotEnemy.health -= Playerbulletdamage;
	// shotEnemy.health -= 1;
	// o2.isAlive = false;
	// if (shotEnemy.health <= 0) {
	// shotEnemy.isAlive = false;
	// Tracer.casualtyCount += shotEnemy.deathPotential;
	//
	// }
	// } else if ((o1 instanceof Enemy && o2 instanceof Player)
	// || (o2 instanceof Enemy && o1 instanceof Player)) {
	//
	// Enemy hordie = o1 instanceof Enemy ? (Enemy) o1 : (Enemy) o2;
	// Player omPlayer = o1 instanceof Player ? (Player) o1 : (Player) o2;
	//
	// int randomDisplacementNum = new Random().nextInt(2);
	// if (randomDisplacementNum == 0) {
	// hordie.x -= 200;
	// } else if (randomDisplacementNum == 1) {
	// hordie.x += 200;
	// }
	// omPlayer.health -= hordie.deathPotential;
	// System.out.println("Player's health is now " + omPlayer.health + ".");
	//
	// if (omPlayer.health <= 0) {
	// omPlayer.isAlive = false;
	// } else if (hordie.health <= 0) {
	// hordie.isAlive = false;
	// }
	// } else if ((o1 instanceof Spawnables && o2 instanceof Player)
	// || (o2 instanceof Spawnables && o1 instanceof Player)) {
	//
	// Spawnables item = o1 instanceof Spawnables ? (Spawnables) o1 : (Spawnables)
	// o2;
	// Player imPlayerity = o1 instanceof Player ? (Player) o1 : (Player) o2;
	//
	// // System.out.println("Player's health is now " +
	// // imPlayerity.health + ".");
	// if (item.typeparameter.equals(item.type1)) {
	// imPlayerity.bulletAmmo += 10;
	// System.out.println("New Bullets: " + imPlayerity.bulletAmmo);
	// } else if (item.typeparameter.equals(item.type2)) {
	// imPlayerity.health += 15;
	// System.out.println("New Health: " + imPlayerity.health);
	// } else if (item.typeparameter.equals(item.type3pt1)) {
	// imPlayerity.nukeCount += 1;
	// System.out.println("New Nuke Count: " + imPlayerity.nukeCount);
	// } else if (item.typeparameter.equals(item.type3pt2)) {
	// imPlayerity.nukeSuitCount += 1;
	// System.out.println("New Nuka-Cola Suit Count: " + imPlayerity.nukeSuitCount);
	// }
	// System.out.println("Item " + item.typeparameter + " picked up!");
	// item.isAlive = false;
	// }
	//
	// }
	// }
	// }
	// }

	public void reset() {
		objects.clear();
	}

}
