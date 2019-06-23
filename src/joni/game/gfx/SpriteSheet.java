package joni.game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public String path;
	public int width;
	public int heigth;

	public int[] pixels;

	public SpriteSheet(String path) {
		BufferedImage image = null;

		try {
			image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (image == null) {
			return;
		}

		this.path = path;
		this.width = image.getWidth();
		this.heigth = image.getHeight();

		pixels = image.getRGB(0, 0, width, heigth, null, 0, width);

		//checks the pixels color of the sprite sheet and set it to a number from 0 to 7
        for (int i = 0; i < pixels.length; i++)
        {
            pixels[i] = (pixels[i] & 0xff) / 32;
        }

	}
}
