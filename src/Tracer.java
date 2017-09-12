import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Tracer extends JPanel implements ActionListener, KeyListener {
	Timer godclock;
	Timer delayedBoom;
	Timer explosionPreceder;
	Overwatcher granger;
	Player fritz;
	Projectile polypencil;

	public Tracer() {
		godclock = new Timer(1000 / 150, this);
		delayedBoom = new Timer(100000000, this);
		delayedBoom.setInitialDelay(450);
		explosionPreceder = new Timer(100000000, this);
		explosionPreceder.setInitialDelay(200);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// maneuvering and shooting
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Projectile pencil = new Projectile(fritz.x + fritz.width, fritz.y + fritz.height / 2, 25, 13, 0);
			granger.addObject(-10, pencil);
			polypencil = pencil;
			delayedBoom.start();
			System.out.println("pencil has been added");
		}
		// dev tools
		if (e.getKeyCode() == KeyEvent.VK_L) {
			int i = 0;
			for (GameObject suchWow : granger.objects) {
				i++;
				System.out.println("\n Object " + i + " is at " + suchWow.x + ", " + suchWow.y);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void updateGame() {
		// TODO Auto-generated method stub
		granger.update();
	}

	public void drawGame(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, LegionRunner.width, LegionRunner.height);
		granger.draw(g);
	}

	@Override
	protected void paintComponent(Graphics tapestrical) {
		// TODO Auto-generated method stub
		System.out.println("repaint");
		repaint();
		drawGame(tapestrical);
	}

	public void startGame() {
		granger = new Overwatcher(this);
		fritz = new Player(LegionRunner.width / 4, LegionRunner.height / 2, 100, 100, 20);
		granger.addObject(0, fritz);
		godclock.start();
		// addToHorde(hordeAdder);
		// main_title = new Song("main_title.mp3");
		// main_title.play();
		// maintitlePlayed = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateGame();
		if (e.getSource() == delayedBoom) {
			delayedBoom.stop();
			Projectile a = polypencil;
			if (a != null) {
				a.projectilecolor = a.fuseIsBurning;
			}
			explosionPreceder.start();

		}
		// if (e.getSource() == explosionPreceder) {
		//
		// }
	}
}
