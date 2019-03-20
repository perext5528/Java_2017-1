package actual_04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Actual_04 extends JFrame {
	Actual_04() {
		this.setTitle("Actual_04");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread th = new Thread(new VibeThread(this));
		this.setSize(300, 300);
		this.setVisible(true);
		this.setLocation(700, 400);
		th.start();

	}

	class VibeThread implements Runnable {
		Actual_04 f;
		boolean flag = false;
		int cnt = 0;

		VibeThread(Actual_04 obj) {
			f = obj;
		}

		public void run() {
			while (cnt++ < 10000) {
				if (flag) {
					f.setLocation(f.getLocation().x + 180, f.getLocation().y + 190);
					f.setLocation(f.getLocation().x - 150, f.getLocation().y - 150);
					f.setLocation(f.getLocation().x + 170, f.getLocation().y);
					f.setLocation(f.getLocation().x, f.getLocation().y + 170);
					flag = false;
				} else {
					f.setLocation(f.getLocation().x - 180, f.getLocation().y - 190);
					f.setLocation(f.getLocation().x + 150, f.getLocation().y + 150);
					f.setLocation(f.getLocation().x - 170, f.getLocation().y);
					f.setLocation(f.getLocation().x, f.getLocation().y - 170);
					flag = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Actual_04();
	}

}
