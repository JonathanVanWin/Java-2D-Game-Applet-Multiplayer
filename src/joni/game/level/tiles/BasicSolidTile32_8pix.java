package joni.game.level.tiles;

import joni.game.gfx.Screen;

import joni.game.level.Level;

public class BasicSolidTile32_8pix extends BasicTile {

	public BasicSolidTile32_8pix(int id, int x, int y, int[] tileColour, int levelColour) {
		super(id, x, y, tileColour, levelColour, 256, 1);
		this.solid=true;
		
	}
	@Override
	public void render(Screen screen, Level level, int x, int y, int levelColour, int scale) {
		screen.render(x, y-24, tileId-96, tileColour, 0x00, 1);
		screen.render(x, y-16, tileId-64, tileColour, 0x00, 1);
		screen.render(x, y-8, tileId-32, tileColour, 0x00, 1);
		screen.render(x, y, tileId, tileColour, 0x00, 1);

	}



}
