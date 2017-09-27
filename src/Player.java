import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	int xspeed;
	int yspeed;

	public Player(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		xspeed = 0;
		yspeed = 0;
	}

	@Override
	public void update() {
		super.update();
		x += xspeed;
		y += yspeed;
	}

	@Override
	public void draw(Graphics forest) {
		forest.setColor(Color.green);
		forest.fillRect(x, y, width, height);
		System.out.println("player drawn");
	}
}
