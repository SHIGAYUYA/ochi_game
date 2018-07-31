package jp.naclo.lib;


import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class ShareInfo {
	//グラフィックス
	public Graphics2D g;

	//現在のミリ秒数
	private long currenttime;

	//描画領域サイズ
	public int canvasWidth, canvasHeight;

	//キーステート
	private boolean[][] keystate;

	//コンストラクタ
	public ShareInfo(){
		//キーステートの初期化
		this.keystate = new boolean[2][8];
		for(int j = 0; j < 2; j++){
			for(int i=0; i<8; i++){
				this.keystate[j][i] = false;
			}
		}
	}

	//キー押したとき
	public boolean getKeyPress(int key){
		return ((this.keystate[0][key] == true) && (this.keystate[1][key] == false));
	}

	//キー離した
	public boolean getKeyRepeat(int key){
		return ((this.keystate[0][key] == true) && (this.keystate[1][key] == true));
	}

	//キー押した
	public boolean getKeyRelease(int key){
		return ((this.keystate[0][key] == false) && (this.keystate[1][key] == true));
	}

	public void updateKeyState(boolean[] newKeystate) {	//キー入力更新
		for(int i=0; i<8; i++){
			this.keystate[1][i] = this.keystate[0][i];
			this.keystate[0][i] = newKeystate[i];
		}
	}

	public long getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(long currenttime) {
		this.currenttime = currenttime;
	}

	public void drawCenterString(String text,int  x, int y){
		FontMetrics fm = g.getFontMetrics();
		int w = fm.stringWidth(text);
		g.drawString(text, x - w / 2, y);
	}
}
