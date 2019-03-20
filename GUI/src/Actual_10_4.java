import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Actual_10_4 extends JFrame {
	JPanel c = new JPanel();
	JLabel jl = new JLabel();
	String st = new String("Love Java");

	Actual_10_4() {
		this.setTitle("실습문제 4번");
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

		int count = 0;

		public void keyPressed(KeyEvent e) {

			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_LEFT)
				count++;
			jl.setText(st.substring(count) + st.substring(0, count));
			if (count == 9)
				count = 0;
		}

		public void keyReleased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) {

		}
	}

	public static void main(String[] args) {
		new Actual_10_4();

	}

}
