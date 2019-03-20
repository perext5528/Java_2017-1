import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_08 extends JFrame {
	JTextArea jta = new JTextArea(10, 10);
	JSlider js = new JSlider(0, 100, 0);
	int count = 0;

	Practice_08() {
		this.setTitle("실습문제 8번");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		jta.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (e.getSource() == jta)
					count++;
				js.setValue(count);
				if (count > 100)
					jta.setEditable(false);
			}

		});

		js.setPaintTicks(true);
		js.setPaintLabels(true);
		js.setPaintTrack(true);
		js.setMajorTickSpacing(50);
		js.setMinorTickSpacing(10);
		js.setEnabled(false);

		c.add(jta, BorderLayout.NORTH);
		c.add(new JScrollPane(jta));
		c.add(js, BorderLayout.SOUTH);
		this.setSize(300, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Practice_08();
	}

}
