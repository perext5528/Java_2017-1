import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_05 extends JFrame {
	JLabel jl = new JLabel("�Է��� �� �ٸ� â�� ���콺 Ŭ���ϸ� �빮�ڷ� ���մϴ�.");
	JTextField jtf = new JTextField(20);

	Practice_05() {
		this.setTitle("�ǽ����� 5��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(jl);
		c.add(jtf);
		jtf.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if (e.getSource() == jtf) {
					jtf.setText(jtf.getText().toUpperCase());
				}
			}
		});

		this.setSize(500, 150);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Practice_05();

	}

}