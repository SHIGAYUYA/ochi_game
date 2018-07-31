package jp.naclo.kusoge1.sequance;

import jp.naclo.lib.BaseSequence;
import jp.naclo.lib.ShareInfo;

public class Game_Main extends BaseSequence {

	public Game_Main(BaseSequence parent){
		super(parent);
	}

	@Override
	public BaseSequence show(ShareInfo sinfo) {
		super.show(null);

		BaseSequence next = this;
		//ステージ更新
		if(((Game)mParent).myStage.update(sinfo)) {
			next = new Game_End(mParent, sinfo);
		}

		//ステージ描画
		((Game)mParent).myStage.draw(sinfo);

		return next;
	}


	@Override
	protected int myLayerNumber() {
		// TODO 自動生成されたメソッド・スタブ
		return 2;
	}

}
