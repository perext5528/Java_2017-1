import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Actual_10_3 extends JFrame {
	JPanel c = new JPanel();
	JLabel jl = new JLabel();
	int sw = 0;
	StringBuffer st = new StringBuffer("Love Java");;

	Actual_10_3() {
		this.setTitle("실습문제 3번");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(c);
		c.addKeyListener(new MyKeyListener());

		jl.setText("Love Java");
		c.add(jl);
		this.setSize(300, 300);
		this.setVisible(true);

		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (sw == 0) {
					sw = 1;
					jl.setText(st.reverse().toString());

				} else {
					sw = 0;
					jl.setText(st.reverse().toString());

				}
			}

		}

		public void keyReleased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) {

		}
	}

	public static void main(String[] args) {
		new Actual_10_3();

	}

}
