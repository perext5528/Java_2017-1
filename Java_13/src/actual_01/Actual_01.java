package actual_01;

import java.awt.*;
import javax.swing.*;

class CounterThread implements Runnable {
	JLabel counter;

	public CounterThread(JLabel counter) {
		this.counter = counter;
	}

	public void run() {
		int n = 0;
		while (n<=100) {
			counter.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class Actual_01 extends JFrame {
	public Actual_01() {
		this.setTitle("Actual_01");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		Container c = this.getContentPane();
		JLabel counter = new JLabel();
		counter.setFont(new Font("Arial", Font.PLAIN, 50));

		CounterThread runnable = new CounterThread(counter);
		c.add(counter);
		Thread th = new Thread(runnable);
		this.setSize(300, 300);
		this.setVisible(true);
		th.start();
	}

	public static void main(String[] args) {
		new Actual_01();

	}
}
