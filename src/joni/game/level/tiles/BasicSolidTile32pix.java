package joni.game.level.tiles;

import joni.game.gfx.Screen;
import joni.game.level.Level;

public class BasicSolidTile32pix extends BasicTile {

	public BasicSolidTile32pix(int id, int x, int y, int[] tileColour, int levelColour) {
		super(id, x, y, tileColour, levelColour, 32, 1);
		this.solid = true;
	}

	@Override
	public void render(Screen screen, Level level, int x, int y, int levelColour, int scale) {
		// render the lower pixelsfrom the sprite
		screen.render(x - 24, y, tileId, tileColour, 0x00, 1);
		screen.render(x - 16, y, tileId + 1, tileColour, 0x00, 1);
		screen.render(x - 8, y, tileId + 2, tileColour, 0x00, 1);
		screen.render(x, y, tileId + 3, tileColour, 0x00, 1);

		// render the middle pixels from the sprite
		screen.render(x - 24, y - 8, tileId - 32, tileColour, 0x00, 1);
		screen.render(x - 16, y - 8, tileId - 31, tileColour, 0x00, 1);
		screen.render(x - 8, y - 8, tileId - 30, tileColour, 0x00, 1);
		screen.render(x, y - 8, tileId - 29, tileColour, 0x00, 1);

		// render the middle pixels from the sprite
		screen.render(x - 24, y - 16, tileId - 64, tileColour, 0x00, 1);
		screen.render(x - 16, y - 16, tileId - 63, tileColour, 0x00, 1);
		screen.render(x - 8, y - 16, tileId - 62, tileColour, 0x00, 1);
		screen.render(x, y - 16, tileId - 61, tileColour, 0x00, 1);

		// render the upper pixels from the sprite
		screen.render(x - 24, y - 24, tileId - 96, tileColour, 0x00, 1);
		screen.render(x - 16, y - 24, tileId - 95, tileColour, 0x00, 1);
		screen.render(x - 8, y - 24, tileId - 94, tileColour, 0x00, 1);
		screen.render(x, y - 24, tileId - 93, tileColour, 0x00, 1);

	}

}
