import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_05 extends JFrame {
	JLabel jl = new JLabel("입력한 후 다른 창에 마우스 클릭하면 대문자로 변합니다.");
	JTextField jtf = new JTextField(20);

	Practice_05() {
		this.setTitle("실습문제 5번");
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