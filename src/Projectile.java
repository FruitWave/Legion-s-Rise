import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	boolean typeIsNormal;
	int speed;
	Color projectilecolor;
	Color aboutToBlow = new Color(117, 41, 3);
	Color fuseIsBurning = new Color(153, 94, 7);

	public Projectile(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		typeIsNormal = true;
		speed = 10;
		projectilecolor = Color.black;
	}

	@Override
	public void update() {
		super.update();
		x += speed;
	}

	@Override
	public void draw(Graphics pato) {
		pato.setColor(projectilecolor);
		pato.fillRect(x, y, width, height);
		System.out.println("pato drawn");
	}
}
