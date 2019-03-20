import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Actual_10_1 extends JFrame {
	Actual_10_1() {
		this.setTitle("실습문제 1번");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel jl = new JLabel("      ");
		MyMouseListener lis = new MyMouseListener();
		jl.addMouseListener(lis);

		add(jl);

		this.setSize(300, 250);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Actual_10_1();
	}

	class MyMouseListener implements MouseListener {
		public void mouseEntered(MouseEvent e) {
			JLabel jl = (JLabel) e.getSource();
			if (jl.getText().equals("      ")) {
				jl.setText("Love Java");
			}
		}

		public void mouseExited(MouseEvent e) {
			JLabel jl = (JLabel) e.getSource();
			if (jl.getText().equals("Love Java")) {
				jl.setText("사랑해");
			}
		}

		public void mouseClicked(MouseEvent arg0) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}
}
