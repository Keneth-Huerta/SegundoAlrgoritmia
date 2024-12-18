package com.mime.minefront.graphics;

import java.util.Random;

import com.mime.minefront.Game;
import com.mime.minefront.input.Controller;
import com.mime.minefront.level.Block;
import com.mime.minefront.level.Level;

public class Render3D extends Render {
	public double[] zBuffer;
	public double[] zBufferWall;
	private double renderDistance = 10000;
	private double forward, right, cosine, sine, up, walking;
	private int spriteSheetWidth = 24;
	Random random = new Random();

	double h = 0.5;

	public Render3D(int width, int heigh) {
		super(width, heigh);
		zBuffer = new double[width * heigh];
		zBufferWall = new double[width];

	}

	public void floor(Game game) {

		for (int x = 0; x < width; x++) {
			zBufferWall[x] = 0;
		}

		double floorPosition = 8;
		double cellinPosition = 8;
		forward = game.controls.z;
		right = game.controls.x;
		up = game.controls.y;
		walking = 0;
		double rotation = game.controls.rotation;
		cosine = Math.cos(rotation);
		sine = Math.sin(rotation);

		for (int y = 0; y < height; y++) {
			double ceiling = (y + -height / 2.0) / height;

			double z = (floorPosition + up) / ceiling;
			if (Controller.walk) {

				walking = Math.sin(game.time / 6.0) * 0.5;
				z = (floorPosition + up + walking) / ceiling;
			}
			if (Controller.cruchWalk && Controller.walk) {
				walking = Math.sin(game.time / 6.0) * 0.2;
				z = (floorPosition + up + walking) / ceiling;
			}
			if (Controller.runWalk && Controller.walk) {
				walking = Math.sin(game.time / 6.0) * 0.8;
				z = (floorPosition + up + walking) / ceiling;

			}

			if (ceiling < 0) {
				z = (cellinPosition - up) / -ceiling;
				if (Controller.walk) {

					z = (cellinPosition - up - walking) / -ceiling;
				}
			}

			for (int x = 0; x < width; x++) {
				double depth = (x - width / 2.0) / height;
				depth *= z;
				double xx = depth * cosine + z * sine;
				double yy = z * cosine - depth * sine;
				int xPix = (int) (xx + right);
				int yPix = (int) (yy + forward);
				zBuffer[x + y * width] = z;
				pixels[x + y * width] = Texture.floor.pixels[(xPix & 7) + (yPix & 7) * Texture.floor.width];// here we
																											// go to put
																											// the
																											// spriteSheetWidth

				if (z > 500) {
					pixels[x + width * y] = 0;
				}
			}

		}
		Level level = game.level;
		int size = 50;
		for (int xBlock = -size; xBlock <= size; xBlock++) {
			for (int zBlock = -size; zBlock <= size; zBlock++) {

				Block block = level.create(xBlock, zBlock);
				Block east = level.create(xBlock + 1, zBlock);
				Block south = level.create(xBlock, zBlock + 1);

				if (block.solid) {
					if (!east.solid) {

						renderWall(xBlock + 1, xBlock + 1, zBlock, zBlock + 1, 0);
					}
					if (!south.solid) {

						renderWall(xBlock + 1, xBlock, zBlock + 1, zBlock + 1, 0);
					}
				} else {

					if (east.solid) {

						renderWall(xBlock + 1, xBlock + 1, zBlock + 1, zBlock, 0);
					}
					if (south.solid) {

						renderWall(xBlock, xBlock + 1, zBlock + 1, zBlock + 1, 0);
					}

				}
			}

		}
		for (int xBlock = -size; xBlock <= size; xBlock++) {
			for (int zBlock = -size; zBlock <= size; zBlock++) {

				Block block = level.create(xBlock, zBlock);
				Block east = level.create(xBlock + 1, zBlock);
				Block south = level.create(xBlock, zBlock + 1);

				if (block.solid) {
					if (!east.solid) {

						renderWall(xBlock + 1, xBlock + 1, zBlock, zBlock + 1, 0.5);
					}
					if (!south.solid) {

						renderWall(xBlock + 1, xBlock, zBlock + 1, zBlock + 1, 0.5);
					}
				} else {

					if (east.solid) {

						renderWall(xBlock + 1, xBlock + 1, zBlock + 1, zBlock, 0.5);
					}
					if (south.solid) {

						renderWall(xBlock, xBlock + 1, zBlock + 1, zBlock + 1, 0.5);
					}

				}
			}

		}
		for (int xBlock = -size; xBlock <= size; xBlock++) {
			for (int zBlock = -size; zBlock <= size; zBlock++) {

				Block block = level.create(xBlock, zBlock);
				for (int s = 0; s < block.sprites.size(); s++) {
					Sprite sprite = block.sprites.get(s);
					renderSprite(xBlock + sprite.x, sprite.y, zBlock + sprite.z, 0.5);
				}
			}
		}

	}

	public void renderSprite(double x, double y, double z, double hoffset) {
		double upCorrect = -0.125;
		double rightCorrect = 0.0625;
		double forwardCorrect = 0.0625;
		double walkingCorrect = 0.0625;

		double xc = ((x / 2) - (right * rightCorrect)) * 2 + hoffset;
		double yc = ((y / 2) - (up * upCorrect)) + (walking * walkingCorrect) * 2 + hoffset;
		double zc = ((z / 2) - (forward * forwardCorrect)) * 2;

		double rotX = xc * cosine - zc * sine;
		double rotY = yc;
		double rotZ = zc * cosine + xc * sine;

		double xCenter = 400.0;
		double yCenter = 300.0;

		double xPixel = rotX / rotZ * height + xCenter;
		double yPixel = rotY / rotZ * height + yCenter;

		double xPixelL = xPixel - height / 2 / rotZ;
		double xPixelR = xPixel + height / 2 / rotZ;

		double yPixelL = yPixel - height / 2 / rotZ;
		double yPixelR = yPixel + height / 2 / rotZ;

		int xpl = (int) xPixelL;
		int xpr = (int) xPixelR;
		int ypl = (int) yPixelL;
		int ypr = (int) yPixelR;

		if (xpl < 0)
			xpl = 0;
		if (xpr > width)
			xpr = width;
		if (ypl < 0)
			ypl = 0;
		if (ypr > height)
			ypr = height;

		rotZ *= 8;

		for (int yp = ypl; yp < ypr; yp++) {
			double pixelRotationY = (yp - yPixelR) / (yPixelL - yPixelR);
			int yTexture = (int) (pixelRotationY * 8);

			for (int xp = xpl; xp < xpr; xp++) {
				double pixelRotationX = (xp - xPixelR) / (xPixelL - xPixelR);
				int xTexture = (int) (pixelRotationX * 8);
				if (zBuffer[xp + yp * width] > rotZ) {
					int col = Texture.floor.pixels[((xTexture & 7) + 16) + (yTexture & 7)];
					if (col != 0xff00ff) {

						pixels[xp + yp * width] = col;
						zBuffer[xp + yp * width] = rotZ;
					}
				}
			}
		}

	}

	public void renderWall(double xLeft, double xRight, double zDistanceLeft, double zDistanceRight, double yHeight) {
		double upCorrect = 0.0625;
		double rightCorrect = 0.0625;
		double forwardCorrect = 0.0625;
		double walkingCorrect = -0.0625;

		double xcLeft = ((xLeft / 2) - (right * rightCorrect)) * 2;
		double zcLeft = ((zDistanceLeft / 2) - (forward * forwardCorrect)) * 2;

		double rotLeftSideX = xcLeft * cosine - zcLeft * sine;
		double yCornerTL = ((-yHeight) - (-up * upCorrect + (walking * walkingCorrect))) * 2;
		double yCornerBL = ((0.5 - yHeight) - (-up * upCorrect + (walking * walkingCorrect))) * 2;
		double rotLeftSideZ = zcLeft * cosine + xcLeft * sine;

		double xcRight = ((xRight / 2) - (right * rightCorrect)) * 2;
		double zcRight = ((zDistanceRight / 2) - (forward * forwardCorrect)) * 2;

		double rotRightSideX = xcRight * cosine - zcRight * sine;
		double yCornerTR = ((-yHeight) - (-up * upCorrect + (walking * walkingCorrect))) * 2;
		double yCornerBR = ((0.5 - yHeight) - (-up * upCorrect + (walking * walkingCorrect))) * 2;
		double rotRightSideZ = zcRight * cosine + xcRight * sine;

		double tex30 = 0;
		double tex40 = 16;
		double clip = 0.5;

		if (rotLeftSideZ < clip && rotRightSideZ < clip) {

			return;
		}

		if (rotLeftSideZ < clip) {
			double clip0 = (clip - rotLeftSideZ) / (rotRightSideZ - rotLeftSideZ);
			rotLeftSideZ = rotLeftSideZ + (rotRightSideZ - rotLeftSideZ) * clip0;
			rotLeftSideX = rotLeftSideX + (rotRightSideX - rotLeftSideX) * clip0;
			tex30 = tex30 + (tex40 - tex30) * clip0;
		}
		if (rotRightSideZ < clip) {
			double clip0 = (clip - rotLeftSideZ) / (rotRightSideZ - rotLeftSideZ);
			rotRightSideZ = rotLeftSideZ + (rotRightSideZ - rotLeftSideZ) * clip0;
			rotRightSideX = rotLeftSideX + (rotRightSideX - rotLeftSideX) * clip0;
			tex30 = tex30 + (tex40 - tex30) * clip0;
		}

		double xPixelLeft = (rotLeftSideX / rotLeftSideZ * height + width / 2);
		double xPixelRight = (rotRightSideX / rotRightSideZ * height + width / 2);

		if (xPixelLeft >= xPixelRight) {

			return;
		}
		int xPixelLeftInt = (int) (xPixelLeft);
		int xPixelRightInt = (int) (xPixelRight);

		if (xPixelLeftInt < 0) {
			xPixelLeftInt = 0;
		}
		if (xPixelRightInt > width) {
			xPixelRightInt = width;
		}
		double yPixelLeftTop = (yCornerTL / rotLeftSideZ * height + height / 2.0);
		double yPixelLeftBottom = (yCornerBL / rotLeftSideZ * height + height / 2.0);
		double yPixelRightTop = (yCornerTR / rotRightSideZ * height + height / 2.0);
		double yPixelRightBottom = (yCornerBR / rotRightSideZ * height + height / 2.0);

		double tex1 = 1 / rotLeftSideZ;
		double tex2 = 1 / rotRightSideZ;
		double tex3 = tex30 / rotLeftSideZ;
		double tex4 = tex40 / rotRightSideZ - tex3;

		for (int x = xPixelLeftInt; x < xPixelRightInt; x++) {
			double pixelRotation = (x - xPixelLeft) / (xPixelRight - xPixelLeft);
			double zWall = (tex1 + (tex2 - tex1) * pixelRotation);

			if (zBufferWall[x] > zWall) {

				continue;
			}
			zBufferWall[x] = zWall;

			int xTexture = (int) ((tex3 + tex4 * pixelRotation) / zWall);

			double yPixelTop = yPixelLeftTop + (yPixelRightTop - yPixelLeftTop) * pixelRotation;
			double yPixelBottom = yPixelLeftBottom + (yPixelRightBottom - yPixelLeftBottom) * pixelRotation;

			int yPixelTopInt = (int) yPixelTop;
			int yPixelBottomInt = (int) yPixelBottom;

			if (yPixelTopInt < 0) {

				yPixelTopInt = 0;
			}
			if (yPixelBottomInt > height) {

				yPixelBottomInt = height;
			}
			for (int y = yPixelTopInt; y < yPixelBottomInt; y++) {

				double pixelRotationY = (y - yPixelTop) / (yPixelBottom - yPixelTop);
				int yTexture = (int) (16 * pixelRotationY);
				pixels[x + y * width] = Texture.wall.pixels[(xTexture & 7) + (yTexture & 7) * Texture.wall.height];
				zBuffer[x + y * width] = 1 / (tex1 + (tex2 - tex1) * pixelRotation) * 8;
			}
		}
	}

	public void renderDistanceLimiter() {

		for (int i = 0; i < width * height; i++) {

			int colour = pixels[i];
			int brightness = (int) (renderDistance / zBuffer[i]);
			if (brightness < 0) {

				brightness = 0;
			}
			if (brightness > 255) {
				brightness = 255;
			}
			int r = (colour >> 16) & 0xff;
			int g = (colour >> 8) & 0xff;
			int b = (colour) & 0xff;
			r = r * brightness / 255;
			g = g * brightness / 255;
			b = b * brightness / 255;
			pixels[i] = r << 16 | g << 8 | b;
		}
	}

}
