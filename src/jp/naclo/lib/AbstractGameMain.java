package jp.naclo.lib;

import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class AbstractGameMain{

	private JFrame mainwindow;
	protected BufferStrategy strategy;
	protected Canvas myCanvas;
	protected ShareInfo sinfo = new ShareInfo();
	protected BaseSequence display;

	//コンストラクタ
	protected AbstractGameMain(String gameName, int width, int height){
		this.mainwindow = new JFrame(gameName);
		this.mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainwindow.setSize(width, height);
		this.mainwindow.setLocationRelativeTo(null);
		this.mainwindow.doLayout();
		this.mainwindow.setVisible(true);
		this.mainwindow.setResizable(false);

		//キャンバス
		JPanel p = (JPanel)this.mainwindow.getContentPane();
		p.setLayout(new FlowLayout());
		this.myCanvas = new Canvas();
		this.myCanvas.setSize(this.mainwindow.getWidth(), this.mainwindow.getHeight());
		sinfo.canvasWidth = myCanvas.getWidth();
		sinfo.canvasHeight = myCanvas.getHeight();
		this.myCanvas.setVisible(true);
		p.add(this.myCanvas);
		this.myCanvas.createBufferStrategy(2);
		this.strategy = this.myCanvas.getBufferStrategy();
		this.myCanvas.requestFocusInWindow();

		//キーアダプター
		this.myCanvas.addKeyListener(new MyKeyAdapter());
	}

	protected void start(){
		Timer t = new Timer();
		t.schedule(new RenderTask(), 0, 16);
	}

	protected abstract void render();

	class RenderTask extends TimerTask{
		@Override
		public void run() {
			AbstractGameMain.this.render();
		}
	}
	protected boolean[] newKeystate = new boolean[8];

	class MyKeyAdapter extends KeyAdapter{	//キーボードの入力を取得するクラス

		@Override
		public void keyPressed(KeyEvent e) {
			this.setValue(e.getKeyCode(), true);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			this.setValue(e.getKeyCode(), false);
		}

		private void setValue(int keycode, boolean b){
			switch(keycode){
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				newKeystate[KEY_STATE.LEFT] = b;
				break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				newKeystate[KEY_STATE.RIGHT] = b;
				break;
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
				newKeystate[KEY_STATE.UP] = b;
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				newKeystate[KEY_STATE.DOWN] = b;
				break;
			case KeyEvent.VK_Z:
			case KeyEvent.VK_SHIFT:
				newKeystate[KEY_STATE.Z] = b;
				break;
			case KeyEvent.VK_X:
				newKeystate[KEY_STATE.X] = b;
				break;
			case KeyEvent.VK_C:
			case KeyEvent.VK_CONTROL:
				newKeystate[KEY_STATE.C] = b;
				break;
			case KeyEvent.VK_SPACE:
				newKeystate[KEY_STATE.SPACE] = b;
				break;
			case KeyEvent.VK_ESCAPE:

				break;
			}
		}

	}
}

