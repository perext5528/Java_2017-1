import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_07 extends JFrame {
	JLabel jl = new JLabel("I Love Java");
	JSlider js = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);

	Practice_07() {
		this.setTitle("실습문제 7번");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		js.setPaintTicks(true);
		js.setPaintLabels(true);
		js.setPaintTrack(true);
		js.setMajorTickSpacing(20);
		js.setMinorTickSpacing(5);

		js.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jl.setFont(new Font("Arial", Font.PLAIN, js.getValue()));
			}
		});

		c.add(js, BorderLayout.NORTH);
		c.add(jl, BorderLayout.CENTER);
		this.setSize(600, 500);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Practice_07();

	}

}