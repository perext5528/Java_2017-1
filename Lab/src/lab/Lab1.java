package lab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab1 extends JFrame {
	int click;

	Lab1() {
		this.setTitle("Lab");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(null);
		JLabel jl = new JLabel();
		jl.setBackground(Color.ORANGE);
		jl.setOpaque(true);
		jl.setLocation(50, 50);
		jl.setSize(150, 100);
		jl.setFont(new Font("Arial", Font.PLAIN, 30));
		jl.setHorizontalAlignment(JLabel.CENTER);

		JButton jb = new JButton("Start");
		jb.setLocation(50, 180);
		jb.setSize(150, 50);

		c.add(jl);
		c.add(jb);

		this.setVisible(true);
		this.setSize(300, 300);
		jl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				click = e.getClickCount();
			}
		});
		jb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Thread369 th = new Thread369(jl, jb, click);
				th.start();
				jb.setEnabled(false);
			}
		});
	}

	class Thread369 extends Thread {
		JLabel jl;
		JButton jb;
		int click;

		Thread369(JLabel jl, JButton jb, int click) {
			this.jl = jl;
			this.jb = jb;
			this.click = click;
		}

		public void run() {
			int n = 0;
			jl.setText(Integer.toString(n));
			while (true) {
				try {
					sleep(700);

					int k1 = n % 10;
					int k2 = n / 10;

					if (k1 == 3 || k1 == 6 || k1 == 9 || k2 == 3 || k2 == 6 || k2 == 9) {
						if (click != 1) {
							jl.setText("Fail");
							return;
						}
					} else if ((k1 == 3 || k1 == 6 || k1 == 9) && (k2 == 3 || k2 == 6 || k2 == 9)) {
						if (click != 2) {
							jl.setText("Fail");
							return;
						}
					} else {
						if (click > 0) {
							jl.setText("Fail");
							return;

						}
					}

					if (n > 100) {
						jl.setText("Win");
					} else {
						n++;
						jl.setText(Integer.toString(n));
					}

				} catch (InterruptedException e) {
					return;
				}
			}

		}
	}

	public static void main(String[] args) {
		new Lab1();
	}
}