package actual_05;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Actual_05 extends JFrame {
	public Actual_05() {
		this.setTitle("Actual_05");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel p = new GamePanel();
		this.setContentPane(p);
		this.setSize(500, 500);
		this.setResizable(false);
		this.setVisible(true);
		p.startGame();
	}

	public static void main(String[] args) {
		new Actual_05();
	}
}

class GamePanel extends JPanel {
	TargetThread targetThread = null;
	JLabel baseLabel = new JLabel();
	JLabel bulletLabel = new JLabel();
	JLabel targetLabel;

	public GamePanel() {
		this.setLayout(null);

		baseLabel.setSize(40, 40);
		baseLabel.setOpaque(true);
		baseLabel.setBackground(Color.BLACK);

		ImageIcon img = new ImageIcon("a.png");
		targetLabel = new JLabel(img);
		targetLabel.setSize(img.getIconWidth(), img.getIconWidth());

		bulletLabel.setSize(10, 10);
		bulletLabel.setOpaque(true);
		bulletLabel.setBackground(Color.RED);

		this.add(baseLabel);
		this.add(targetLabel);
		this.add(bulletLabel);
	}

	public void startGame() {
		baseLabel.setLocation(this.getWidth() / 2 - 20, this.getHeight() - 40);
		bulletLabel.setLocation(this.getWidth() / 2 - 5, this.getHeight() - 50);
		targetLabel.setLocation(0, 0);
		targetThread = new TargetThread(targetLabel);
		targetThread.start();
		baseLabel.requestFocus();
		baseLabel.addKeyListener(new KeyAdapter() {
			BulletThread bulletThread = null;

			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '\n') {
					if (bulletThread == null || !bulletThread.isAlive()) {
						bulletThread = new BulletThread(bulletLabel, targetLabel, targetThread);
						bulletThread.start();
					}
				}
			}
		});
	}

	class TargetThread extends Thread {
		JComponent target;

		public TargetThread(JComponent target) {
			this.target = target;
			target.setLocation(0, 0);
		}

		public void run() {
			while (true) {
				int x = target.getX() + 10;
				int y = target.getY();

				if (x > GamePanel.this.getWidth())
					target.setLocation(0, 0);
				else
					target.setLocation(x, y);

				try {
					sleep(20);
				} catch (InterruptedException e) {

					target.setLocation(0, 0);

					try {
						sleep(10);
					} catch (InterruptedException e2) {
					}
				}
			}
		}
	}

	class BulletThread extends Thread {
		JComponent bullet, target;
		Thread targetThread;

		public BulletThread(JComponent bullet, JComponent target, Thread targetThread) {
			this.bullet = bullet;
			this.target = target;
			this.targetThread = targetThread;
		}

		public void run() {
			while (true) {
				if (hit()) {
					targetThread.interrupt();
					bullet.setLocation(bullet.getParent().getWidth() / 2 - 5, bullet.getParent().getHeight() - 50);

					return;
				} else {
					int x = bullet.getX();
					int y = bullet.getY() - 15;
					if (y < 0) {
						bullet.setLocation(bullet.getParent().getWidth() / 2 - 5, bullet.getParent().getHeight() - 50);
						return;
					}
					bullet.setLocation(x, y);
				}

				try {
					sleep(20);
				} catch (InterruptedException e) {
				}
			}
		}

		private boolean hit() {
			if (targetContains(bullet.getX(), bullet.getY())
					|| targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY())
					|| targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY() + bullet.getHeight() - 1)
					|| targetContains(bullet.getX(), bullet.getY() + bullet.getHeight() - 1))
				return true;
			else
				return false;
		}

		private boolean targetContains(int x, int y) {
			if (((target.getX() <= x) && (x < target.getX() + target.getWidth()))
					&& ((target.getY() <= y) && (y < target.getY() + target.getHeight())))
				return true;
			else
				return false;
		}
	}
}