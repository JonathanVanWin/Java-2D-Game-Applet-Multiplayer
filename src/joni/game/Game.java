package joni.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import joni.game.entities.Dog;
import joni.game.entities.Player;
import joni.game.entities.PlayerMP;
import joni.game.gfx.Colours;
import joni.game.gfx.Screen;
import joni.game.gfx.SpriteSheet;
import joni.game.level.Level;
import joni.game.net.GameClient;
import joni.game.net.GameServer;
import joni.game.net.packets.Packet00Login;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 3;
	public static final String NAME = "Game";
	public static final Dimension DIMENSIONS = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	public static Game game;
	public JFrame frame;

	private Thread thread;

	public boolean running = false;
	public int tickCount = 0;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private int[] colours = new int[6 * 6 * 6];

	private Screen screen;
	public InputHandler input;
	public WindowHandler windowHandler;
	public Level level;
	public Player player;
	public Dog dog;
	public GameClient socketClient;
	public GameServer socketServer;
	public static int numLevelG = 1;
	public boolean debug = true;
	public static boolean isApplet = false;

	public void init() {
		int index = 0;
		for (int r = 0; r < 6; r++) {
			for (int g = 0; g < 6; g++) {
				for (int b = 0; b < 6; b++) {
					int rr = (r * 255 / 5);
					int gg = (g * 255 / 5);
					int bb = (b * 255 / 5);

					colours[index++] = rr << 16 | gg << 8 | bb;
				}
			}
		}

		screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/sprite_sheet.png"));
		input = new InputHandler(this);

		level = new Level("/levels/water_test_level");
		player = new PlayerMP(level, 100, 100, input, JOptionPane.showInputDialog(this, "Please enter a username"),
				null, -1);
		dog = new Dog(level, 80, 80, input, getName());
		level.addEntity(player);
		level.addEntity(dog);
		if (!isApplet) {
			Packet00Login loginPacket = new Packet00Login(player.getUsername(), player.x, player.y);

			if (socketServer != null) {
				socketServer.addConnection(((PlayerMP) player), loginPacket);
			}
			// socketClient.sendData("ping".getBytes());
			loginPacket.writeData(socketClient);
		}
	}

	public synchronized void start() {
		running = true;

		thread = new Thread(this, NAME + "_main");
		thread.start();
		if (!isApplet) {
			if (JOptionPane.showConfirmDialog(this, "Do you want to run the server") == 0) {
				socketServer = new GameServer(this);
				socketServer.start();
			}

			socketClient = new GameClient(this, "localhost");
			socketClient.start();
		}
	}

	public synchronized void stop() {
		running = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long lastTimer = System.currentTimeMillis();
		double nsPerTick = 1000000000D / 60D;
		double delta = 0;
		int ticks = 0;
		int frames = 0;

		init();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				debug(DebugLevel.INFO, ticks + " ticks , " + frames + " frames per second");
				frames = 0;
				ticks = 0;
			}
		}
	}

	public void tick() {
		tickCount++;
		level.tick();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		int xOffset = player.x - (screen.width / 2);
		int yOffset = player.y - (screen.height / 2);

		level.renderTiles(screen, xOffset, yOffset);

		for (int x = 0; x < level.width; x++) {
			@SuppressWarnings("unused")
			// int colour = Colours.get(-1, -1, -1, 000);
			int colour[] = Colours.get(new int[] { 555, 555, 555, 555, 555, 555, 555, 555 });

			if (x % 10 == 0 && x != 0) {
				colour = Colours.get(new int[] { 555, 555, 555, 555, 555, 555, 555, 555 });// Colours.get(-1,
																							// -1,
																							// -1,
																							// 500);
			}
		}

		level.renderEntities(screen);

		for (int y = 0; y < screen.height; y++) {
			for (int x = 0; x < screen.width; x++) {
				int ColourCode = screen.pixels[x + y * screen.width];
				if (ColourCode < 255) {
					pixels[x + y * WIDTH] = colours[ColourCode];

				}
			}
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public void debug(DebugLevel level, String msg) {
		switch (level) {
		default:
		case INFO:
			if (debug) {
				System.out.println("[" + NAME + "] " + msg);
			}
			break;
		case WARNING:
			System.out.println("[" + NAME + "] [WARNING] " + msg);
			break;
		case SEVERE:
			System.out.println("[" + NAME + "] [SEVERE] " + msg);
			this.stop();
			break;
		}
	}

	public static enum DebugLevel {
		INFO, WARNING, SEVERE;
	}
}