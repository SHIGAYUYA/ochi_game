package jp.naclo.kusoge1.charactor;

import java.io.IOException;

import jp.naclo.lib.KEY_STATE;
import jp.naclo.lib.ShareInfo;

public class MelonChara extends GameChara{

	private double v;	//速度
	public MelonChara() {
		x = 640;
		y = 520;

		v = 1.0;

		try {
			this.loadImage("media/tixtupu.png");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@Override
	public void update(ShareInfo sinfo) {
		//押し続けで加速
		if(sinfo.getKeyRepeat(KEY_STATE.LEFT) || sinfo.getKeyRepeat(KEY_STATE.RIGHT)) {
			v = v + 0.5;
		}

		//離したら速度ゼロ
		if(sinfo.getKeyRelease(KEY_STATE.LEFT) || sinfo.getKeyRelease(KEY_STATE.RIGHT)) {
			v = 1.0;
		}

		//最低速　最大速
		if(v < 1.0) {
			v = 1.0;
		}else if(v > 10.0){
			v = 10.0;
		}

		if(sinfo.getKeyRepeat(KEY_STATE.LEFT)) {
			x = x - (int)v;
		}
		if(sinfo.getKeyRepeat(KEY_STATE.RIGHT)) {
			x = x + (int)v;
		}

		//画面外へ出ない処理
		if(x < 0) {
			x = 0;
		}else if(x > sinfo.canvasWidth - this.charaImg.getWidth()) {
			x = sinfo.canvasWidth - this.charaImg.getWidth();
		}


	}

	@Override
	public void draw(ShareInfo sinfo) {
		sinfo.g.drawImage(charaImg, x, y, null);
	}

}
