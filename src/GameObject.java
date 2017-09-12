import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle collisionArea = new Rectangle(x, y, width, height);
	int health;

	public GameObject(int x, int y, int width, int height, int health) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
	}

	public void update() {
		collisionArea.setBounds(x, y, width, height);
		if (y < 0) {
			y = 0;
		} else if (y > LegionRunner.height - height) {
			y = LegionRunner.height - height;
		}
		// fix sinking into floor D:
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		System.out.println("gameobject update");

	}

}