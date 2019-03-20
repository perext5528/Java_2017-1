
import java.awt.*;
import javax.swing.*;

class TimerRunnable implements Runnable {
	JLabel timerLabel;

	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	public void run() {
		int n = 0;
		while (true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class ThreadEx_02 extends JFrame {
	public ThreadEx_02() {
		this.setTitle("TimerThread");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 180));
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable);
		c.add(timerLabel);
		this.setVisible(true);
		this.setSize(300, 300);
		th.start();
	}

	public static void main(String[] args) {
		new ThreadEx_02();

	}
}
