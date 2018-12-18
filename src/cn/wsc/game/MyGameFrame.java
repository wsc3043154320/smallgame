package cn.wsc.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;


public class MyGameFrame extends Frame {

	Image planeImg = GameUtils.getImage("images/plane.png");
	Image bg = GameUtils.getImage("images/bg.jpg");

	Plane plane = new Plane(planeImg, 251, 251);
	Shell[] shells = new Shell[50];
	Explode bao;
	Date start=new Date();
	Date end;
	int period;
	@Override
	public void paint(Graphics g) {// 自动调用
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);

		// 画出所有炮弹
		for (int i = 0; i < shells.length; i++) {
			shells[i].draw(g);
			
			boolean peng=shells[i].getRect().intersects(plane.getRect());
			if(peng) {
				plane.live=false;
				
				if(bao==null) {
					bao=new Explode(plane.x,plane.y);
					end=new Date();
					period=(int)(end.getTime()-start.getTime())/1000;
				}
				
				bao.draw(g);
			}
			if(!plane.live) {
				Font font =new Font("宋体",Font.BOLD,40);
				g.setColor(Color.white);
				g.setFont(font);
				g.drawString("时间："+period+"秒", 200, 250);
			}
		}
	}

	/**
	 * 内部类可以直接使用外部类的属性 帮我们反复重画窗口
	 */
	class PaintThread extends Thread {
		@Override
		public void run() {
			while (true) {
				repaint();// 重画
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 定义键盘监听的内部类
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}

	}

	/**
	 * 初始化窗口
	 */
	public void launchFrame() {
		// 初始化50颗炮弹
		for (int i = 0; i < shells.length; i++) {
			shells[i] = new Shell();
		}
		
		this.setTitle("打飛機");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(600, 300);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new PaintThread().start();// 启动重画窗口的线程
		addKeyListener(new KeyMonitor());// 给窗口增加键盘的监听
	}

	public static void main(String[] args) {
		MyGameFrame mgf = new MyGameFrame();
		mgf.launchFrame();
	}

	// 双缓冲
	private Image offScreenImage = null;

	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);

	}

}
