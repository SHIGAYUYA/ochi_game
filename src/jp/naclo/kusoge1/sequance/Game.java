package jp.naclo.kusoge1.sequance;

import jp.naclo.kusoge1.Stage;
import jp.naclo.lib.BaseSequence;
import jp.naclo.lib.ShareInfo;

public class Game extends BaseSequence {
	protected Stage myStage;

	public Game(BaseSequence parent){
		super(parent);
		myStage = new Stage();
		mChild = new Game_Main(this);
	}

	@Override
	public BaseSequence show(ShareInfo sinfo) {
		super.show(null);

		BaseSequence next;
		next = mChild.show(sinfo);
		if(next != mChild){
			mChild = next;
		}
		return this;
	}

	@Override
	protected int myLayerNumber() {
		// TODO 自動生成されたメソッド・スタブ
		return 1;
	}

}
