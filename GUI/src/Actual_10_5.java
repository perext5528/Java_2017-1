import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Actual_10_5 extends JFrame {
	JPanel c = new JPanel();
	JLabel jl = new JLabel("Love Java");

	Actual_10_5() {
		this.setTitle("실습문제 5번");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(c);
		c.addKeyListener(new MyKeyListener());

		jl.setFont(new Font("Arial", Font.PLAIN, 10));

		c.add(jl);
		this.setSize(300, 300);
		this.setVisible(true);

		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {

		Font f = jl.getFont();
		int size = f.getSize();

		public void keyPressed(KeyEvent e) {

			int keyCode = e.getKeyCode();

			if (keyCode == KeyEvent.VK_ADD) {
				jl.setFont(new Font("Arial", Font.PLAIN, size + 5));
				size += 5;
			}
			if (keyCode == KeyEvent.VK_SUBTRACT && size > 16) {
				jl.setFont(new Font("Arial", Font.PLAIN, size - 5));

				size -= 5;
			}

		}

		public void keyReleased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) {

		}
	}

	public static void main(String[] args) {
		new Actual_10_5();

	}

}
