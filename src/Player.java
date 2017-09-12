import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	int health = 100;

	public Player(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		this.health = health;
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void draw(Graphics forest) {
		forest.setColor(Color.green);
		forest.fillRect(x, y, width, height);
		System.out.println("player drawn");
	}
}
