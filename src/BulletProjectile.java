import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class BulletProjectile extends GameObject implements ActionListener {
	boolean typeIsNormal;
	int speed;
	Color projectilecolor;
	Color fuseIsBurning = new Color(153, 94, 7);
	Color aboutToBlow = new Color(117, 41, 3);
	Color flammenwherfur = Color.red;
	int color_stage;
	Timer delayedBoom;
	Timer explosionPreceder;
	Timer explosion;
	Timer timeUntilDeath;
	Timer redhot;

	public BulletProjectile(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		typeIsNormal = true;
		speed = 10;
		color_stage = 0;
		delayedBoom = new Timer(100000000, this);
		delayedBoom.setInitialDelay(350);
		explosionPreceder = new Timer(100000000, this);
		explosionPreceder.setInitialDelay(200);
		redhot = new Timer(100000000, this);
		redhot.setInitialDelay(100);
		explosion = new Timer(100000000, this);
		explosion.setInitialDelay(30);
		timeUntilDeath = new Timer(100000000, this);
		timeUntilDeath.setInitialDelay(15);
	}

	@Override
	public void update() {
		super.update();
		x += speed;
	}

	private void decideColor(int colorStage) {
		switch (colorStage) {
		case 1:
			projectilecolor = fuseIsBurning;
			break;
		case 2:
			projectilecolor = aboutToBlow;
			break;
		case 3:
			projectilecolor = flammenwherfur;
			break;
		case 4:
			projectilecolor = Color.white;
			break;
		default:
			projectilecolor = Color.black;
			break;
		}
	}

	@Override
	public void draw(Graphics pato) {
		decideColor(color_stage);
		pato.setColor(projectilecolor);
		pato.fillRect(x, y, width, height);
		System.out.println("pato drawn");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == delayedBoom) {
			delayedBoom.stop();
			color_stage++;
			explosionPreceder.start();
		} else if (e.getSource() == explosionPreceder) {
			explosionPreceder.stop();
			color_stage++;
			explosion.start();
		} else if (e.getSource() == redhot) {
			redhot.stop();
			color_stage++;
			explosion.start();
		} else if (e.getSource() == explosion) {
			explosion.stop();
			color_stage++;
			timeUntilDeath.start();
		} else if (e.getSource() == timeUntilDeath) {
			timeUntilDeath.stop();
			isAlive = false;
		}
	}
}
