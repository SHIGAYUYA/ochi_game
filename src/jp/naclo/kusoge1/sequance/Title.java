package jp.naclo.kusoge1.sequance;

import java.awt.Color;
import java.awt.Font;

import jp.naclo.lib.BaseSequence;
import jp.naclo.lib.KEY_STATE;
import jp.naclo.lib.ShareInfo;

public class Title extends BaseSequence {
	private Font font = new Font("MSゴシック", Font.BOLD, 96);
	public Title(BaseSequence parent){
		super(parent);
	}

	@Override
	public BaseSequence show(ShareInfo sinfo) {
		super.show(null);

		sinfo.g.setFont(font);
		sinfo.g.setColor(Color.GREEN);
		sinfo.drawCenterString("よけろ！！ メロンパン！！", sinfo.canvasWidth / 2, 320);

		if(sinfo.getKeyRepeat(KEY_STATE.SPACE)) {
			return new Game(mParent);
		}
		return this;
	}

	@Override
	protected int myLayerNumber() {
		// TODO 自動生成されたメソッド・スタブ
		return 1;
	}
}
