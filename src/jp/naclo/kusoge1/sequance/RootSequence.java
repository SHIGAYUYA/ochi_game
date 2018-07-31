package jp.naclo.kusoge1.sequance;

import jp.naclo.lib.BaseSequence;
import jp.naclo.lib.ShareInfo;

public class RootSequence extends BaseSequence{		//根

	public RootSequence(BaseSequence parent){
		super(null);
		mChild = new Title(this);
	}

	@Override
	public BaseSequence show(ShareInfo sinfo) {
		super.show(null);

		BaseSequence next;
		next = mChild.show(sinfo);
		if(next != mChild){
			mChild = next;
		}
		return null;
	}

	@Override
	protected int myLayerNumber() {
		return 0;
	}
}
