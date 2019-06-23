package joni.game.level.tiles;

import joni.game.gfx.Colours;
import joni.game.gfx.Screen;
import joni.game.level.Level;

public class BasicTile extends Tile {

	protected int tileId;
	protected int[] tileColour;
	protected int sizeOfTile;

	public BasicTile(int id, int x, int y, int[] tileColour, int levelColour, int sizeOfTile, int scale) {
		super(id, false, false, levelColour, false);
		this.sizeOfTile = sizeOfTile;
		this.tileId = x + y * 32;
		this.TileId=this.tileId;
		this.tileColour = tileColour;
		this.changeColor=false;
	}

	public void tick() {

	}
	

	public void render(Screen screen, Level level, int x, int y, int levelColour, int scale) {
		if(changeColor)tileColour=Colours.get(new int[]{0});
		if (this.sizeOfTile == 1) {
			screen.render(x, y, tileId, tileColour, 0x00, 1);
		} else if (this.sizeOfTile == 2) {
			screen.render(x, y, tileId, tileColour, 0x00, 1);
			screen.render(x, y-8, tileId-32, tileColour, 0x00, 1);
			
		}
	}

}
