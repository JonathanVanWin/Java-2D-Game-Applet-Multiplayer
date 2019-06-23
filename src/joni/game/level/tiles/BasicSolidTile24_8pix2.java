package joni.game.level.tiles;

import joni.game.gfx.Screen;

import joni.game.level.Level;

public class BasicSolidTile24_8pix2 extends BasicTile {

	public BasicSolidTile24_8pix2(int id, int x, int y, int[] tileColour, int levelColour) {
		super(id, x, y, tileColour, levelColour, 256, 1);
		this.solid=true;
		
	}
	@Override
	public void render(Screen screen, Level level, int x, int y, int levelColour, int scale) {
		screen.render(x, y-16, tileId-64, tileColour, 0x00, 1);
		screen.render(x, y-8, tileId-32, tileColour, 0x00, 1);
		screen.render(x, y, tileId, tileColour, 0x00, 1);

	}



}
