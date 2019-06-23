package joni.game.gfx;

public class Colours {

	// get the colors
	public static int[] get(int[] colour) {
		// intakes colour array and sets the colour per each index
		for (int i = 0; i < colour.length; i++) {
			if (colour[i] < 0) {
				colour[i] = 255;
			} else {
				colour[i] = ((colour[i] / 100 % 10) * 36) + ((colour[i] / 10 % 10) * 6) + (colour[i] % 10);
			}
		}
		return colour;
	}
}
