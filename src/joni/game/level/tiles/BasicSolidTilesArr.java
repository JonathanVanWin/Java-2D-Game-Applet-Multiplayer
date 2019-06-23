package joni.game.level.tiles;

import joni.game.gfx.Screen;
import joni.game.level.Level;

public class BasicSolidTilesArr extends BasicTile {
	private int scale;

	public BasicSolidTilesArr(int id, int x, int y, int[] tileColour, int levelColour0, int scale) {
		super(id, x, y, tileColour, levelColour0, 4, scale);
		this.solid = true;
		this.scale = scale;
	}

	public int getScale() {
		return scale;
	}

	@Override
	public void render(Screen screen, Level level, int x, int y, int levelColour, int scale) {
		screen.render(x, y, tileId + 1, tileColour, 0x00, getScale());
		screen.render(x - 8, y, tileId, tileColour, 0x00, getScale());
		screen.render(x - 8, y - 8, tileId - 32, tileColour, 0x00, getScale());
		screen.render(x, y - 8, tileId - 31, tileColour, 0x00, getScale());

		/*
		 * Good way for scaling trees up ( bigger trees!) working, remember to
		 * implement this because the trees are now very little screen.render(x,
		 * y, tileId + 1, tileColour, 0x00, 2); screen.render(x - 16, y, tileId,
		 * tileColour, 0x00, 2); screen.render(x - 16, y - 16, tileId - 32,
		 * tileColour, 0x00, 2); screen.render(x, y - 16, tileId - 31,
		 * tileColour, 0x00, 2);execute @p ~ ~ ~ fill ~-10 ~-3 ~-10 ~10 ~50 ~10 minecraft:dirt 3 replace minecraft:dirt
		 *//*execute @p ~ ~ ~ fill ~-10 ~-3 ~-10 ~10 ~50 ~10 minecraft:air 1 replace:(minecraft:iron_block)
/*effect @p 1 100 10*/
	}

}
