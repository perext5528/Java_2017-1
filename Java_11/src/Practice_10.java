import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_10 extends JFrame {
	int count = 0;
	JLabel[] jl = new JLabel[10];

	Practice_10() {
		setTitle("실습문제 10번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		setSize(300, 300);
		setVisible(true);
		for (int i = 0; i < jl.length; i++) {
			jl[i] = new JLabel("" + i + "");
			jl[i].setSize(15, 15);
			int x = (int) (Math.random() * 250);
			int y = (int) (Math.random() * 250);
			jl[i].setLocation(x, y);
			jl[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					JLabel la = (JLabel) e.getSource();
					if (count < 10 && la == jl[count]) {
						jl[count].setVisible(false);
						count++;
					}
					if (count > 9) {
						count = 0;
						for (int i = 0; i < jl.length; i++) {
							jl[i].setVisible(true);
							int x = (int) (Math.random() * 250);
							int y = (int) (Math.random() * 250);
							jl[i].setLocation(x, y);
						}
					}
				}
			});
			add(jl[i]);
		}
	}

	public static void main(String[] args) {
		new Practice_10();
	}
}
