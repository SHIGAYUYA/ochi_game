package jp.naclo.lib;

public abstract class BaseSequence {
	protected BaseSequence mChild;
	protected BaseSequence mParent;

	public BaseSequence(BaseSequence parent) {
		if(parent != null) {
			while((this.myLayerNumber() - parent.myLayerNumber()) != 1) {
				parent = parent.mParent;
			}
			this.mParent = parent;
		}
	}

	//このディスプレイを表示
	public BaseSequence show(ShareInfo sinfo) {
		//System.out.println(this.getClass().getName());
		return null;
	}
	//自分の階層番号を返す
	protected abstract int myLayerNumber();


}
