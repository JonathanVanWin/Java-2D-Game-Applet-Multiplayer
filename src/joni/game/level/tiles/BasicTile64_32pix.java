package joni.game.level.tiles;

import joni.game.gfx.Screen;
import joni.game.level.Level;

public class BasicTile64_32pix extends BasicTile {

	public BasicTile64_32pix(int id, int x, int y, int[] tileColour, int levelColour) {
		super(id, x, y, tileColour, levelColour, 2048, 1);
		this.solid = true;

	}

	@Override
	public void render(Screen screen, Level level, int x, int y, int levelColour, int scale) {
		// render the lower pixels from the sprite
		screen.render(x - 56, y, tileId, tileColour, 0x00, 1);
		screen.render(x - 48, y, tileId + 1, tileColour, 0x00, 1);
		screen.render(x - 40, y, tileId + 2, tileColour, 0x00, 1);
		screen.render(x - 32, y, tileId + 3, tileColour, 0x00, 1);

		screen.render(x - 24, y, tileId + 4, tileColour, 0x00, 1);
		screen.render(x - 16, y, tileId + 5, tileColour, 0x00, 1);
		screen.render(x - 8, y, tileId + 6, tileColour, 0x00, 1);
		screen.render(x, y, tileId + 7, tileColour, 0x00, 1);

		// render the middle pixels from the sprite
		screen.render(x - 56, y - 8, tileId - 32, tileColour, 0x00, 1);
		screen.render(x - 48, y - 8, tileId - 31, tileColour, 0x00, 1);
		screen.render(x - 40, y - 8, tileId - 30, tileColour, 0x00, 1);
		screen.render(x - 32, y - 8, tileId - 29, tileColour, 0x00, 1);

		screen.render(x - 24, y - 8, tileId - 28, tileColour, 0x00, 1);
		screen.render(x - 16, y - 8, tileId - 27, tileColour, 0x00, 1);
		screen.render(x - 8, y - 8, tileId - 26, tileColour, 0x00, 1);
		screen.render(x, y - 8, tileId - 25, tileColour, 0x00, 1);

		// render the middle pixels from the sprite
		screen.render(x - 56, y - 16, tileId - 64, tileColour, 0x00, 1);
		screen.render(x - 48, y - 16, tileId - 63, tileColour, 0x00, 1);
		screen.render(x - 40, y - 16, tileId - 62, tileColour, 0x00, 1);
		screen.render(x - 32, y - 16, tileId - 61, tileColour, 0x00, 1);

		screen.render(x - 24, y - 16, tileId - 60, tileColour, 0x00, 1);
		screen.render(x - 16, y - 16, tileId - 59, tileColour, 0x00, 1);
		screen.render(x - 8, y - 16, tileId - 58, tileColour, 0x00, 1);
		screen.render(x, y - 16, tileId - 57, tileColour, 0x00, 1);

		// render the upper pixels from the sprite
		screen.render(x - 56, y - 24, tileId - 96, tileColour, 0x00, 1);
		screen.render(x - 48, y - 24, tileId - 95, tileColour, 0x00, 1);
		screen.render(x - 40, y - 24, tileId - 94, tileColour, 0x00, 1);
		screen.render(x - 32, y - 24, tileId - 93, tileColour, 0x00, 1);

		screen.render(x - 24, y - 24, tileId - 92, tileColour, 0x00, 1);
		screen.render(x - 16, y - 24, tileId - 91, tileColour, 0x00, 1);
		screen.render(x - 8, y - 24, tileId - 90, tileColour, 0x00, 1);
		screen.render(x, y - 24, tileId - 89, tileColour, 0x00, 1);

	}

}
