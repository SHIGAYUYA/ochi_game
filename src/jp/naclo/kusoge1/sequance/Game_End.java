package jp.naclo.kusoge1.sequance;

import java.awt.Color;
import java.awt.Font;

import jp.naclo.lib.BaseSequence;
import jp.naclo.lib.ShareInfo;

public class Game_End extends BaseSequence {
	private long startTime;

	private Font font = new Font("MSゴシック", Font.BOLD, 72);
	public Game_End(BaseSequence parent, ShareInfo sinfo) {
		super(parent);

		startTime = sinfo.getCurrenttime();
	}

	@Override
	public BaseSequence show(ShareInfo sinfo) {
		//終了画面
		((Game)mParent).myStage.draw(sinfo);

		sinfo.g.setFont(font);
		sinfo.g.setColor(Color.RED);
		sinfo.drawCenterString("GAME OVER", sinfo.canvasWidth / 2, 320);

		if(sinfo.getCurrenttime() - startTime > 1500) {
			return new Title(mParent);
		}

		return this;
	}

	@Override
	protected int myLayerNumber() {
		// TODO 自動生成されたメソッド・スタブ
		return 2;
	}

}
