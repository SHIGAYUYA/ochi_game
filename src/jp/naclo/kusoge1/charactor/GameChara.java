package jp.naclo.kusoge1.charactor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.naclo.lib.ShareInfo;

public abstract class GameChara {
	protected int x, y;

	protected BufferedImage charaImg;

	public abstract void update(ShareInfo sinfo);

	public abstract void draw(ShareInfo sinfo);

	protected void loadImage(String name) throws IOException {
		charaImg = ImageIO.read(new File(name));
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return charaImg.getWidth();
	}
	public int getH() {
		return charaImg.getHeight();
	}
}
