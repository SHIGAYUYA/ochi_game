package jp.naclo.kusoge1;

import java.awt.Color;
import java.awt.Graphics2D;

import jp.naclo.kusoge1.sequance.RootSequence;
import jp.naclo.lib.AbstractGameMain;

public class Kusoge1Main extends AbstractGameMain{

	public static void main(String args[]) {
		Kusoge1Main kusoge1Main = new Kusoge1Main();
		kusoge1Main.start();
	}

	public Kusoge1Main() {
		super("クソゲー", 1280, 720);

		this.display = new RootSequence(null);
	}

	@Override
	protected void render() {
		//時間計測
		long time = System.currentTimeMillis();
		sinfo.setCurrenttime(time);

		//マウスの入力反映
		sinfo.updateKeyState(this.newKeystate);

		//描画オブジェクト取得
		Graphics2D g = (Graphics2D)this.strategy.getDrawGraphics();

		//背景塗りつぶし
		g.setBackground(Color.DARK_GRAY);
		g.clearRect(0, 0, sinfo.canvasWidth, sinfo.canvasHeight);

		sinfo.g = g;

		//画面ごとの処理呼び出し
		this.display.show(sinfo);

		g.dispose();
		this.strategy.show();
	}

}
