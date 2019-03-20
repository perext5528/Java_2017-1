import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Actual_10_2 extends JFrame {
	JPanel c = new JPanel();

	Actual_10_2() {
		this.setTitle("실습문제 2번");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(c);

		c.addMouseListener(new lis());
		c.addMouseMotionListener(new lis());

		this.setBackground(Color.GREEN);
		this.setSize(300, 300);
		this.setVisible(true);

	}

	class lis implements MouseListener, MouseMotionListener {

		public void mouseDragged(MouseEvent e) {
			// JPanel a = (JPanel)e.getSource();
			c.setBackground(Color.YELLOW);

		}

		public void mouseMoved(MouseEvent e) {
			c.setBackground(Color.GREEN);
		}

		public void mouseClicked(MouseEvent e) {
			c.setBackground(Color.GREEN);
		}

		public void mouseEntered(MouseEvent e) {
			c.setBackground(Color.GREEN);
		}

		public void mouseExited(MouseEvent e) {
			c.setBackground(Color.GREEN);
		}

		public void mousePressed(MouseEvent e) {
			c.setBackground(Color.GREEN);
		}

		public void mouseReleased(MouseEvent e) {
			c.setBackground(Color.GREEN);
		}

	}

	public static void main(String[] args) {
		new Actual_10_2();

	}

}
