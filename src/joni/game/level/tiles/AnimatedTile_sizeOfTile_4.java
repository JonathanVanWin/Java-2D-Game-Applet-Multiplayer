package joni.game.level.tiles;

import joni.game.gfx.Screen;
import joni.game.level.Level;

public class AnimatedTile_sizeOfTile_4 extends BasicTile {

	private int[][] animationTileCoords;
	private int currentAnimationIndex;
	private long lastIterationTime;
	private int animationSwitchDelay;
	private int sizeOfTile;

	public AnimatedTile_sizeOfTile_4(int id, int[][] animationCoords, int[] tileColour, int levelColour,
			int animationSwitchDelay) {
		super(id, animationCoords[0][0], animationCoords[0][1], tileColour, levelColour, 1, 1);
		this.animationTileCoords = animationCoords;
		this.currentAnimationIndex = 0;
		this.lastIterationTime = System.currentTimeMillis();
		this.animationSwitchDelay = animationSwitchDelay;
	}

	public void tick() {
		if ((System.currentTimeMillis() - lastIterationTime) >= (animationSwitchDelay)) {
			lastIterationTime = System.currentTimeMillis();
			currentAnimationIndex = (currentAnimationIndex + 1) % animationTileCoords.length;
			this.tileId = (animationTileCoords[currentAnimationIndex][0]
					+ (animationTileCoords[currentAnimationIndex][1] * 32));
		}

	}

	@Override
	public void render(Screen screen, Level level, int x, int y, int levelColour, int scale) {

		// System.out.println(tileId1);
		screen.render(x, y, tileId + 1, tileColour, 0x00, 1);
		screen.render(x - 8, y, tileId, tileColour, 0x00, 1);
		screen.render(x - 8, y - 8, tileId - 32, tileColour, 0x00, 1);
		screen.render(x, y - 8, tileId - 31, tileColour, 0x00, 1);

	}
}
