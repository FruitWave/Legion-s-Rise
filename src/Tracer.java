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

	Overwatcher granger;
	Player fritz;
	BulletProjectile pencil;
	boolean goingup = false;
	boolean goingdown = false;
	boolean goingleft = false;
	boolean goingright = false;
	Timer slide;

	public Tracer() {
		godclock = new Timer(1000 / 150, this);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		// shooting
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			pencil = new BulletProjectile(fritz.x + fritz.width, fritz.y + fritz.height / 2, 15, 5, 0);
			granger.addObject(-10, pencil);
			pencil.delayedBoom.start();
			System.out.println("pencil has been added");
		}
		// maneuvering
		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_A)
				|| (e.getKeyCode() == KeyEvent.VK_D)) {
			slide = new Timer(1000 / 10, this);

			if (e.getKeyCode() == KeyEvent.VK_W) {
				fritz.yspeed -= 5;
				goingup = true;
				goingdown = false;
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				fritz.yspeed += 5;
				goingdown = true;
				goingup = false;
			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				fritz.xspeed -= 5;
				goingleft = true;
				goingright = false;
			} else if (e.getKeyCode() == KeyEvent.VK_D) {
				fritz.xspeed += 5;
				goingright = true;
				goingleft = false;
			}
			slide.start();
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

		if (goingdown) {
			for (int i = fritz.yspeed; i > 0; i++) {
				fritz.yspeed -= 1;
			}
			if (fritz.yspeed <= 0) {
				goingdown = false;
			}
		}
		if (goingup) {
			for (int i = fritz.yspeed; i < 0; i++) {
				fritz.yspeed += 1;
			}
			if (fritz.yspeed >= 0) {
				goingup = false;
			}
		}
		if (goingright) {
			for (int i = fritz.xspeed; i > 0; i++) {
				fritz.xspeed -= 1;
			}
			if (fritz.xspeed <= 0) {
				goingright = false;
			}
		}
		if (goingleft) {
			for (int i = fritz.xspeed; i < 0; i++) {
				fritz.xspeed += 1;
			}
			if (fritz.xspeed >= 0) {
				goingleft = false;
			}
		}
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
		if (e.getSource() == godclock) {
			updateGame();
		}

	}
}
