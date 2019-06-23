package joni.game.level.tiles;

import joni.game.gfx.Screen;
import joni.game.level.Level;

public class BasicSolidTile extends BasicTile {
	private int scale;
	public BasicSolidTile(int id, int x, int y, int[] tileColour, int levelColour, int scale) {
		super(id, x, y, tileColour, levelColour, 1, scale);
		this.solid = true;
		this.scale=scale;
	}
	
	public int getScale() {
		return scale;
	}
	@Override
	public void render(Screen screen, Level level, int x, int y, int levelColour, int scale) {

		screen.render(x, y, tileId, tileColour, 0x00, 1);
	}
	

}
