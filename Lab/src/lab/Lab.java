package lab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Thread369 extends Thread {
	JLabel jl;
	JButton jb;
	int click = 0;
	int n = 0;
	boolean single_c = true;
	boolean double_c = true;

	Thread369(JLabel jl, JButton jb, int click) {
		this.jl = jl;
		this.jb = jb;
		this.click = click;
	}

	public void run() {

		while (true) {

			try {

				sleep(700);

				int k1 = n % 10;
				int k2 = n / 10;
				if ((k1 == 3 || k1 == 6 || k1 == 9 || k2 == 3 || k2 == 6 || k2 == 9)) {
					if (click == 1) {
						single_c = true;
					}else {
						jl.setText("Fail");
						break;
					}
				} else if ((k1 == 3 || k1 == 6 || k1 == 9) && (k2 == 3 || k2 == 6 || k2 == 9)) {
					if (click == 2) {
						double_c = true;
					}else {
						jl.setText("Fail");						
						break;
					}
				}

				if (n>100) {
					jl.setText("Win");					
				}else {
					n++;
					jl.setText(Integer.toString(n));
				}
			} catch (InterruptedException e) {
				return;
			}
		}
		jb.setEnabled(true);
	}

}

public class Lab extends JFrame {
	Thread369 th;

	int click;

	Lab() {
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

		jl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				click = e.getClickCount();
			}
		});
		jb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (jb.isEnabled()) {
					th = new Thread369(jl, jb, click);
					th.start();					
					jb.setEnabled(false);
				}
			}
		});

		this.setVisible(true);
		this.setSize(300, 300);
	}

	public static void main(String[] args) {
		new Lab();
	}
}