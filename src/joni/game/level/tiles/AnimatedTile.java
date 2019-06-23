package joni.game.level.tiles;

import joni.game.gfx.Screen;
import joni.game.level.Level;

public class AnimatedTile extends BasicTile {

	private int[][] animationTileCoords;
	private int currentAnimationIndex;
	private long lastIterationTime;
	private int animationSwitchDelay;
	public AnimatedTile(int id, int[][] animationCoords, int[] tileColour, int levelColour, int animationSwitchDelay) {
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
		screen.render(x, y, tileId, tileColour, 0x00, 1);
	}
}
