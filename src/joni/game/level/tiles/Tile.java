package joni.game.level.tiles;

import java.awt.image.BufferedImage;

import joni.game.gfx.Colours;
import joni.game.gfx.Screen;
import joni.game.gfx.Sprite;
import joni.game.level.Level;

public abstract class Tile {
	public static final Tile[] tiles = new Tile[256];
	public static final Tile VOID = new BasicSolidTile(0, 0, 0, Colours.get(new int[] { 000, 000, 131, 131, 131, 131,
			131, 131 })/* Colours.get(000, -1, -1, -1) */, 0xFF000000, 1);
	public static final Tile STONE = new BasicSolidTile(33, 1, 0, Colours.get(new int[] { 131, 131, 333, 131, 131, 131,
			131, 131 }) /* Colours.get(-1, 333, -1, -1) */, 0xFF555555, 1);
	public static final Tile GRASS = new BasicTile(2, 2, 0, Colours.get(new int[] { 131, 131, 131, 131, 131, 141, 131,
			131 })/* Colours.get(-1, 131, 141, -1) */, 0xFF00FF00, 1, 1);
	public static final Tile GRASSWITHFLOWERS = new BasicSolidTile16_16pix(37, 5, 1,
			Colours.get(new int[] { 131, 121, 421, 421, 421, 421, 421, 555 }), 0xFFff0000, 1);
	public static final Tile WATER = new AnimatedTile(3, new int[][] { { 0, 5 }, { 1, 5 }, { 2, 5 }, { 1, 5 } },
			Colours.get(new int[] { 004, 004, 004, 004, 004, 115, 004,
					004 })/* Colours.get(-1, 004, 115, -1) */,
			0xFF0000FF, 1000);
	public static final Tile TREE = new BasicSolidTilesArr(4, 0, 7, Colours.get(new int[] { 131, 131, 040, 131, 131,
			050, 131, 320 })/* Colours.get(131, 040, 050, 320) */, 0xFF003300, 1);
	/*
	 * public static final Tile TREE00 = new BasicSolidTile(4, 0, 7,
	 * Colours.get(131, 040, 050, 320), 0xFF003300, 1); public static final Tile
	 * TREE01 = new BasicSolidTile(5, 1, 7, Colours.get(131, 040, 050, 320),
	 * 0xFF006600, 1); public static final Tile TREE02 = new BasicSolidTile(6,
	 * 0, 6, Colours.get(131, 040, 050, 320), 0xFF009900, 1); public static
	 * final Tile TREE03 = new BasicSolidTile(7, 1, 6, Colours.get(131, 040,
	 * 050, 320), 0xFF00cc00, 1);
	 */
	public static final Tile ELECTRICITY = new BasicTile(8, 4, 0, Colours.get(new int[] { 431, 431, 131, 131, 131, 420,
			420, 000 })/* Colours.get(431, 131, 420, 000) */, 0xFFcc6600, 1, 1);
	public static final Tile DOOR1 = new BasicSolidTilesArr(9, 0, 10, Colours.get(new int[] { 131, 131, 320, 320, 320,
			431, 431, 420 })/* Colours.get(131, 320, 431, 420) */, 0xFF996600, 1);
	public static final Tile HOUSE = new BasicSolidTile32pix(10, 0, 15, Colours.get(new int[] { -1, 321, 320, 320, 320,
			431, 500, 420 })/* Colours.get(131, 320, 431, 420) */, 0xFFff3000);
	public static final Tile WOODPLANK = new BasicTile32pix(11, 0, 19,
			Colours.get(new int[] { 210, 210, 310, -1, -1, 420, -1, 223 }), 0xFF993300);
	public static final Tile WOODPLANKBACK = new BasicTile(12, 0, 19, Colours.get(new int[] { 210, 210, 310, -1, -1,
			420, -1, 223 })/* Colours.get(-1, 131, 141, -1) */, 0xFFda4900, 1, 1);
	public static final Tile TABLE = new BasicTile64_32pix(13, 4, 15,
			Colours.get(new int[] { 310, 111, 210, -1, -1, 321, 310, 432 }), 0xFFaa8550);

	public static final Tile UPPERWALLLEFT = new BasicSolidTile(14, 0, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFF886767, 1);
	public static final Tile UPPERWALLMID = new BasicSolidTile(15, 1, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFF3e6767, 1);
	public static final Tile UPPERWALLRIGHT = new BasicSolidTile(16, 2, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFF67613e, 1);

	public static final Tile LOWERWALLLEFT = new BasicSolidTile(17, 3, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFFaa8181, 1);
	public static final Tile LOWERWALLMID = new BasicSolidTile(18, 4, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFF6284aa, 1);
	public static final Tile LOWERWALLRIGHT = new BasicSolidTile(19, 5, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFFaa6262, 1);

	public static final Tile INNERUPPERWALLLEFT = new BasicSolidTile(20, 6, 8,
			Colours.get(new int[] { 310, 210, 211, 211, 211, 211, 211, 211 }), 0xFF675900, 1);
	public static final Tile INNERUPPERWALLMID = new BasicSolidTile(21, 10, 8,
			Colours.get(new int[] { 310, 210, 211, 211, 211, 211, 211, 211 }), 0xFFc65900, 1);
	public static final Tile INNERUPPERWALLRIGHT = new BasicSolidTile(22, 7, 8,
			Colours.get(new int[] { 310, 210, 211, 211, 211, 211, 211, 211 }), 0xFF8b7800, 1);

	public static final Tile INNERLOWERWALLLEFT = new BasicSolidTile(23, 8, 8,
			Colours.get(new int[] { 310, 210, 211, 211, 211, 211, 211, 211 }), 0xFF716200, 1);
	public static final Tile INNERLOWERWALLMID = new BasicSolidTile(30, 16, 8,
			Colours.get(new int[] { 310, 210, 211, 211, 211, 211, 211, 211 }), 0xFFaa4c00, 1);
	public static final Tile INNERLOWERWALLRIGHT = new BasicSolidTile(24, 9, 8,
			Colours.get(new int[] { 310, 210, 211, 211, 211, 211, 211, 211 }), 0xFF71661c, 1);

	public static final Tile VERTICALWALLLEFTUP = new BasicSolidTile(25, 11, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFFaa632a, 1);
	public static final Tile VERTICALWALLLEFTDOWN = new BasicSolidTile(26, 12, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFFff953e, 1);
	public static final Tile VERTICALWALLRIGHTUP = new BasicSolidTile(27, 13, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFFff8d30, 1);
	public static final Tile VERTICALWALLRIGHTDOWN = new BasicSolidTile(28, 14, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFFffb67a, 1);
	public static final Tile VERTICALWALLMIDRIGHT = new BasicSolidTile(29, 15, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFFd77300, 1);
	public static final Tile VERTICALWALLMIDLEFT = new BasicSolidTile(31, 17, 8,
			Colours.get(new int[] { 310, 321, 321, 321, 321, 321, 431, 442 }), 0xFFb0771f, 1);
	public static final Tile LEFTPARTCHIMNEY = new BasicSolidTile32_8pix(32, 0, 23,
			Colours.get(new int[] { 211, 311, 223, 421, 443, 321, 433, 555 }), 0xFFe5e6c7);

	public static final Tile UPPERMIDDLEPARTCHIMNEY = new BasicSolidTilesArr(34, 1, 21,
			Colours.get(new int[] { 211, 311, 223, 000, 233, 321, 433, 555 }), 0xFFe3e685, 1);
	public static final Tile RIGHTPARTCHIMNEY = new BasicSolidTile24_8pix2(35, 3, 23,
			Colours.get(new int[] { 211, 311, 223, 000, 233, 321, 433, 555 }), 0xFFe1e64a);
	public static final Tile RIGHTUPPERPARTCHIMNEY = new BasicSolidTile(36, 3, 20,
			Colours.get(new int[] { 211, 311, 223, 000, 233, 321, 433, 555 }), 0xFFe3e694, 1);

	public static final Tile ANIMATEDFIRE = new AnimatedTile_sizeOfTile_4(1,
			new int[][] { { 0, 25 }, { 2, 25 }, { 4, 25 } },
			Colours.get(new int[] { 000, 311, 521, 211, 321, 100, 411, 531 }), 0xFFffa749, 200);
	/*
	 * public static final Tile DOOR2 = new BasicSolidTile(10, 1, 10,
	 * Colours.get(131, 320, 431, 420), 0xFFaa7500, 1); public static final Tile
	 * DOOR3 = new BasicSolidTile(11, 0, 9, Colours.get(131, 320, 431, 420),
	 * 0xFFcc9933, 1); public static final Tile DOOR4 = new BasicSolidTile(12,
	 * 1, 9, Colours.get(131, 320, 431, 420), 0xFFff9900, 1);
	 */
	protected byte id;
	public boolean solid;
	protected boolean emitter;
	private int levelColour;
	public boolean changeColor;
	public int TileId;

	public Tile(int id, boolean isSolid, boolean isEmitter, int levelColour, boolean changeColor) {

		this.id = (byte) id;
		/*
		 * if (tiles[id] != null) throw new
		 * RuntimeException("Duplicate tilex id on " + id);
		 */
		this.solid = isSolid;
		this.emitter = isEmitter;
		this.levelColour = levelColour;
		this.changeColor = changeColor;
		tiles[id] = this;
	}

	public byte getId() {
		return id;
	}

	public boolean isSolid() {
		return solid;
	}

	public boolean isEmitter() {
		return emitter;
	}

	public int getLevelColour() {
		return levelColour;
	}

	public void changeColorOf(Tile tile, int[] colour) {
		if (tile.changeColor)
			tile = new BasicTile(tile.getId(), tile.getX(), tile.getY(), Colours.get(colour), tile.getLevelColour(), 1,
					1);
	}

	private int getY() {
		return TileId / 32;
	}

	private int getX() {
		return TileId % 32;
	}

	public abstract void tick();

	public abstract void render(Screen screen, Level level, int x, int y, int levelColour, int scale);

}
