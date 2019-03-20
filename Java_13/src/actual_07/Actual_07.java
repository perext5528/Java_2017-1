package actual_07;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Thread369 extends Thread {
	Thread th;
	JLabel jl;
	JButton jb;
	boolean single_c = true;
	boolean double_c = true;

	Thread369(JLabel jl, JButton jb, boolean single_c, boolean double_c) {
		this.jl = jl;
		this.jb = jb;
		this.single_c=single_c;
		this.double_c=double_c;
	}

	public void run() {
		int n = 0;
		while (true) {
			if (n < 101) {
				jl.setText(Integer.toString(n));
				n++;
			} else {
				jl.setText("Win");
				interrupt();
				jb.setEnabled(true);
			}
			try {
				sleep(700);

			} catch (InterruptedException e) {
				return;
			}
		}
	}

}

public class Actual_07 extends JFrame {
	Thread369 th;
	boolean single_c = true;
	boolean double_c = true;

	Actual_07() {
		this.setTitle("Actual_07");
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
				if (jl.getText() != "Fail") {
					int n = Integer.parseInt(jl.getText());
					int k1 = n % 10;
					int k2 = n / 10;
					if (k1 == 3 || k1 == 6 || k1 == 9 || k2 == 3 || k2 == 6 || k2 == 9) {
						if (e.getClickCount() == 1) {
							single_c = true;
						} else if(e.getClickCount()!=1){
							single_c = false;
						}

					} else if ((k1 == 3 || k1 == 6 || k1 == 9) && (k2 == 3 || k2 == 6 || k2 == 9)) {
						if (e.getClickCount() == 2) {
							double_c = true;
						} else {
							double_c = false;
						}
					} else {
						single_c = false;
						double_c = false;
					}
					if (single_c == false || double_c == false) {
						jl.setText("Fail");
						th.interrupt();
						jb.setEnabled(true);
					}
				}
			}
		});
		jb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (jb.isEnabled()) {
					th = new Thread369(jl, jb, single_c, double_c);
					th.start();
					jb.setEnabled(false);
				}

			}
		});

		this.setVisible(true);
		this.setSize(300, 300);

	}

	public static void main(String[] args) {
		new Actual_07();
	}
}