import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

class SnakeGameFrame extends JFrame {
	Thread snakeThread;
	GroundPanel p;
	int direction;

	public SnakeGameFrame() {
		this.setTitle("Actual_09");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new GroundPanel();
		this.setContentPane(p);
		this.setVisible(true);
		this.setSize(300, 300);
		p.requestFocus();
		snakeThread = new Thread(p);
		snakeThread.start();
	}

	class GroundPanel extends JPanel implements Runnable {
		static final int LEFT = 0;
		static final int RIGHT = 1;
		static final int UP = 2;
		static final int DOWN = 3;
		int direction;
		SnakeBody snakeBody;

		public GroundPanel() {
			this.setLayout(null);
			snakeBody = new SnakeBody();
			snakeBody.addIn(this);
			direction = LEFT;
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						direction = UP;
						break;
					case KeyEvent.VK_DOWN:
						direction = DOWN;
						break;
					case KeyEvent.VK_LEFT:
						direction = LEFT;
						break;
					case KeyEvent.VK_RIGHT:
						direction = RIGHT;
						break;
					}
				}
			});
		}

		public void paninComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon icon = new ImageIcon("a.png");
			Image img = icon.getImage();
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		}

		public void run() {
			while (true) {
				
				try {
					Thread.sleep(20);
					snakeBody.move(direction);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}

	class SnakeBody {
		Vector<JLabel> v = new Vector<JLabel>();

		public SnakeBody() {
			ImageIcon head = new ImageIcon("a.png");
			JLabel la = new JLabel(head);
			la.setSize(head.getIconWidth(), head.getIconHeight());
			la.setLocation(100, 100);
			v.add(la);
			ImageIcon body = new ImageIcon("a.png");
			for (int i = 1; i < 10; i++) {
				la = new JLabel(body);
				la.setSize(body.getIconWidth(), body.getIconHeight());
				la.setLocation(100 + i * 20, 100);
				v.addElement(la);
			}
		}

		public void addIn(JPanel p) {
			for (int i = 0; i < v.size(); i++)
				p.add(v.get(i));
		}

		public void move(int direction) {
			for (int i = v.size() - 1; i > 0; i--) {
				JLabel b = v.get(i);
				JLabel a = v.get(i - 1);
				b.setLocation(a.getX(), a.getY());
			}
			JLabel head = v.get(0);
			switch (direction) {
			case GroundPanel.LEFT:
				head.setLocation(head.getX() - 20, head.getY());
				break;
			case GroundPanel.RIGHT:
				head.setLocation(head.getX() + 20, head.getY());
				break;
			case GroundPanel.UP:
				head.setLocation(head.getX(), head.getY() - 20);
				break;
			case GroundPanel.DOWN:
				head.setLocation(head.getX(), head.getY() + 20);
				break;

			}
		}
	}
}

public class Actual_09 {

	public static void main(String[] args) {
		new SnakeGameFrame();
	}

}
