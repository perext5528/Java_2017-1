package actual_03;


import java.awt.*;
import javax.swing.*;
import java.util.*;

class DigitalClockThread extends Thread {
	JLabel Clock;
	int hour, min, second;

	public DigitalClockThread(JLabel Clock) {
		this.Clock = Clock;
	}

	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int min = cal.get(Calendar.MINUTE);
			int second = cal.get(Calendar.SECOND);

			String clockText = Integer.toString(hour);
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			Clock.setText(clockText);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}

		}
	}
}

public class Actual_03 extends JFrame {
	JLabel Clock;

	public Actual_03() {
		this.setTitle("Actual_03");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = this.getContentPane();
		this.setLayout(new FlowLayout());
		JLabel Clock = new JLabel();
		Clock.setFont(new Font("Arial", Font.PLAIN, 50));
		DigitalClockThread dct = new DigitalClockThread(Clock);
		c.add(Clock);

		this.setSize(300, 300);
		this.setVisible(true);
		dct.start();
	}

	public static void main(String[] args) {
		new Actual_03();

	}

}
