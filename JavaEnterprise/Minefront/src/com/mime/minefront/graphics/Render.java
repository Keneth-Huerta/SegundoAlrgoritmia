package com.mime.minefront.graphics;

public class Render {
	public final int width, height;
	public final int[] pixels;


	public Render(int width, int heigh) {

		this.width = width;
		this.height = heigh;
		pixels = new int[width * heigh];
	}

	public void draw(Render render, int xOffset, int yOffset) {

		for (int y = 0; y < render.height; y++) {
			int yPix = y + yOffset;
			if (yPix < 0 || yPix >= height) {
				continue;
			}
			for (int x = 0; x < render.width; x++) {
				int xPix = x + xOffset;
				if (xPix < 0 || xPix >= width) {
					continue;
				}
				int alpha = render.pixels[x + y * render.width];
				
				if (alpha > 0) {
					pixels[xPix + yPix * width] = alpha;
				}

			}
		}
	}
}
