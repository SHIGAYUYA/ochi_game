package jp.naclo.kusoge1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import jp.naclo.kusoge1.charactor.GameChara;
import jp.naclo.kusoge1.charactor.MelonChara;
import jp.naclo.kusoge1.charactor.UnchiChara;
import jp.naclo.lib.ShareInfo;

public class Stage {
	private Random rnd;
	private MelonChara myChara;
	private UnchiChara myUChara[];
	private int unchiNum = 0;
	private double rate;

	private final int MAX_UNCHI_SIZE = 10;

	private BufferedImage backImg;

	public Stage() {
		myChara = new MelonChara();
		myUChara = new UnchiChara[MAX_UNCHI_SIZE];
		for(int i = 0; i < myUChara.length; i++) {
			myUChara[i] = new UnchiChara();
		}

		rnd = new Random(System.currentTimeMillis());

		try {
			backImg = ImageIO.read(new File("media/backImg.jpg"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public boolean update(ShareInfo sinfo) {
		//自機移動
		myChara.update(sinfo);


		if(unchiNum < myUChara.length) {
			if(rnd.nextDouble() < 0.05) {
				for(int i = 0; i < myUChara.length; i++) {
					//表示されていないものを探す
					if(!myUChara[i].isVisible()) {
						myUChara[i].init((int)(sinfo.canvasWidth * rnd.nextDouble()));
						break;
					}
				}
				unchiNum++;
			}
		}

		//敵移動
		for(int i = 0; i < myUChara.length; i++) {
			//unchi表示されてるときのみ
			if(myUChara[i].isVisible()) {
				myUChara[i].update(sinfo);
				if(!myUChara[i].isVisible()) {
					unchiNum--;
				}
			}
		}

		//当たり判定
		for(int i = 0; i < myUChara.length; i++) {
			//unchi表示されてるときのみ
			if(myUChara[i].isVisible()) {
				if(hitCheck(myChara, myUChara[i])) {
					return true;
				}
			}
		}

		return false;
	}

	public void draw(ShareInfo sinfo) {
		sinfo.g.drawImage(backImg, 0, 0, sinfo.canvasWidth, sinfo.canvasHeight, null);

		myChara.draw(sinfo);

		for(int i = 0; i < myUChara.length; i++) {
			//unchi表示されてるときのみ
			if(myUChara[i].isVisible()) {
				myUChara[i].draw(sinfo);
			}
		}
	}

	private boolean hitCheck(GameChara chara1, GameChara chara2){		//キャラクターとキャラクターの衝突
		int c1x, c1y;		//chara1の座標
		int c1w, c1h;		//chara1の幅

		c1w = chara1.getW();
		c1h = chara1.getH();

		c1x = chara1.getX() + (int)(c1w * 0.1);
		c1y = chara1.getY() + (int)(c1h * 0.1);

		c1w = (int)(c1w * 0.8);
		c1h = (int)(c1h * 0.8);

		int c2x, c2y;		//chara1の座標
		int c2w, c2h;		//chara1の幅

		c2w = chara2.getW();
		c2h = chara2.getH();

		c2x = chara2.getX() + (int)(c2w * 0.1);
		c2y = chara2.getY() + (int)(c2h * 0.1);

		c2w = (int)(c2w * 0.8);
		c2h = (int)(c2h * 0.8);

		if(c1x <= c2x + c2w && c1x + c1w >= c2x) {
			if(c1y <= c2y + c2h && c1y + c1h >= c2y) {
				return true;
			}
		}

		return false;
	}
}
