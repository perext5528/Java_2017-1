import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_01 extends JFrame {
	JCheckBox[] setbtn = new JCheckBox[2];
	String[] names = { "버튼 비활성화", "버튼 숨기기" };
	JButton btn = new JButton("test button");

	Practice_01() {
		this.setTitle("실습문제 1번");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		for (int i = 0; i < names.length; i++) {
			setbtn[i] = new JCheckBox(names[i]);
			c.add(setbtn[i]);
			setbtn[i].addItemListener(new IL());
		}

		c.add(btn);

		this.setSize(300, 300);
		this.setVisible(true);
	}

	class IL implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int sw = 0;
			if (e.getItem() == setbtn[0]) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					btn.setEnabled(false);
				else
					btn.setEnabled(true);
			}
			if (e.getItem() == setbtn[1]) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					btn.setVisible(false);
				else
					btn.setVisible(true);
			}

		}

	}

	public static void main(String[] args) {
		new Practice_01();

	}

}
