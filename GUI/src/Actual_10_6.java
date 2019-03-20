import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Actual_10_6 extends JFrame {
	JPanel c = new JPanel();
	JLabel jl = new JLabel("C");

	Actual_10_6() {
		this.setTitle("실습문제 6번");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(c);
		this.setLayout(null);
		jl.setLocation(100, 100);
		jl.setSize(20, 20);

		c.addMouseListener(new MyMouseListener());

		c.add(jl);
		this.setSize(310, 310);
		this.setVisible(true);

		c.requestFocus();
	}

	class MyMouseListener implements MouseListener {
		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			jl.setLocation((int) (Math.random() * 300), (int) (Math.random() * 300));

		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}

	public static void main(String[] args) {
		new Actual_10_6();

	}

}
