import javax.swing.JFrame;

public class LegionRunner {
	JFrame frame;
	static final int width = 1920;
	static final int height = 1080;
	Tracer linden;

	// constructor
	public LegionRunner() {
		frame = new JFrame();
		linden = new Tracer();
		setup();
	}

	public static void main(String[] args) {
		LegionRunner battlehead = new LegionRunner();
	}

	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(linden);
		frame.setTitle("Legion's Rise");
		frame.addKeyListener(linden);
		frame.setSize(width, height);
		frame.setVisible(true);
		linden.startGame();
	}
}
