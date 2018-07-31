package jp.naclo.kusoge1.charactor;

import java.io.IOException;

import jp.naclo.lib.ShareInfo;

public class UnchiChara extends GameChara{

	private double v;	//速度
	private boolean visible;

	public UnchiChara() {
		visible = false;
		try {
			this.loadImage("media/unchi.png");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void init(int sx) {
		x = sx;
		y = -200;

		v = 1.0;
		visible = true;
		//System.out.println(x+" "+ y);
	}

	@Override
	public void update(ShareInfo sinfo) {
		v = v + 0.2;
		y = y + (int)v;
		if(y > sinfo.canvasHeight) {
			visible = false;
		}
	}

	@Override
	public void draw(ShareInfo sinfo) {
		sinfo.g.drawImage(charaImg, x, y, null);
	}

	public boolean isVisible() {
		// TODO 自動生成されたメソッド・スタブ
		return visible;
	}

}
