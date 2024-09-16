package Minefront;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ReonCraft.DisplayReonCraft;

public class Launcher extends JFrame implements Runnable {
	private static final long serialVersionUID = 6031394679183022710L;

	protected JPanel window = new JPanel();
	private JButton play, options, help, quit;
	private Rectangle rplay, roptions, rhelp, rquit;
	Configuration config = new Configuration();

	private int width = 800;
	private int height = 400;
	protected int button_width = 80;
	protected int button_height = 40;
	boolean running = false;
	Thread thread;

	public static int games = 0;

	public Launcher(int id) {

		setUndecorated(true);
		setTitle("Minefront Launcher");
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// getContentPane().add(window);

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		window.setLayout(null);
	
		InputHandler input = new InputHandler();
		addMouseListener(input);
		addMouseMotionListener(input);
		startMenu();

		repaint();
	}

	public void updateFrame() {
		if (InputHandler.dragged) {

			int x = getX();
			int y = getY();
			setLocation(x + InputHandler.MouseDX - InputHandler.MousePX,
					y + InputHandler.MouseDY - InputHandler.MousePY);

		}
	}

	private void renderMenu() throws IllegalStateException {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 400);
		try {

			g.drawImage(ImageIO.read(Launcher.class.getResource("/res/menu_image.png")), 0, 0, 800, 400, null);
			Image image1 = ImageIO.read(Launcher.class.getResource("/res/menu/play_on.png"));
			Image image2 = ImageIO.read(Launcher.class.getResource("/res/menu/play_off.png"));
			Image image3 = ImageIO.read(Launcher.class.getResource("/res/menu/options_on.png"));
			Image image4 = ImageIO.read(Launcher.class.getResource("/res/menu/options_off.png"));
			Image image5 = ImageIO.read(Launcher.class.getResource("/res/menu/help_on.png"));
			Image image6 = ImageIO.read(Launcher.class.getResource("/res/menu/help_off.png"));
			Image image7 = ImageIO.read(Launcher.class.getResource("/res/menu/exit_on.png"));
			Image image8 = ImageIO.read(Launcher.class.getResource("/res/menu/exit_off.png"));

			loadImage(image1, image2, 690, 130, g, 1);
			loadImage(image3, image4, 641, 170, g, 2);
			loadImage(image5, image6, 690, 210, g, 3);
			loadImage(image7, image8, 690, 250, g, 4);
			g.setFont(new Font("Bodoni Bd BT", 1, 70));
			g.setColor(new Color(0x5b3a29));
			g.drawString("ReonCraft", 100, 150);

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		g.dispose();
		bs.show();
	}

	public void loadImage(Image image, Image image2, int posX, int posY, Graphics g, int wich) throws IOException {
		if (InputHandler.MouseX > posX && InputHandler.MouseX < posX + image.getWidth(help)
				&& InputHandler.MouseY > posY && InputHandler.MouseY < posY + image.getHeight(help)) {
			g.drawImage(image, posX, posY, image.getWidth(help), image.getHeight(help), null);
			g.drawImage(ImageIO.read(Launcher.class.getResource("/res/menu/arrow.png")), posX + image.getWidth(help),
					posY + 2, 24, 24, null);
			if (wich == 1) {
				if (InputHandler.MouseButton == 1) {
				//	config.loadConfiguration("/res/settings/config.xml");
					dispose();
					new DisplayReonCraft();
					games = 1;
				}
			} else if (wich == 2) {
				if (InputHandler.MouseButton == 1) {

					new Options();
					
				}

			} else if (wich == 4) {
				if (InputHandler.MouseButton == 1) {
					System.exit(0);
				}
			}
		} else {

			g.drawImage(image2, posX, posY, image.getWidth(help), image.getHeight(help), null);
		}
	}

	public void startMenu() {

		running = true;
		thread = new Thread(this, "menu");
		thread.start();
	}

	public void stopMenu() {
		try {

			thread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void run() {
		while (running) {

			renderMenu();
			updateFrame();
		}

	}

	

}
