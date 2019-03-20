import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_06 extends JFrame {
	JSlider js = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
	JLabel jl = new JLabel("100");

	Practice_06() {
		this.setTitle("실습문제 6번");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		js.setPaintTicks(true);
		js.setPaintLabels(true);
		js.setPaintTrack(true);
		js.setMajorTickSpacing(50);
		js.setMinorTickSpacing(10);

		js.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jl.setText(Integer.toString(js.getValue()));
			}
		});

		c.add(js);
		c.add(jl);
		this.setSize(300, 100);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Practice_06();

	}

}