package actual_02;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TimerThread extends Thread {
	JLabel timer;

	public TimerThread(JLabel timer) {
		this.timer = timer;
	}

	public void run() {
		int n = 0;
		while (true) {
			timer.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				n = 0;
				return;
			}
		}
	}
}

public class Actual_02 extends JFrame {
	TimerThread th;

	public Actual_02() {
		this.setTitle("Actual_02");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		JLabel timer = new JLabel("0");
		timer.setFont(new Font("Arial", Font.PLAIN, 50));

		c.add(timer);

		th = new TimerThread(timer);
		timer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (th.isAlive())
					th.interrupt();
				else {
					th = new TimerThread(timer);
					th.start();
				}
			}
		});

		this.setSize(300, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Actual_02();
	}

}
