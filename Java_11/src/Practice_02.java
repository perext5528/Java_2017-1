import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_02 extends JFrame {

	JTextField jtf = new JTextField(10);
	JComboBox jcb = new JComboBox();

	Practice_02() {
		this.setTitle("�ǽ����� 2��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		jtf.addActionListener(new AL());
		jcb.addActionListener(new AL());

		c.add(jtf);
		c.add(jcb);

		this.setSize(300, 300);
		this.setVisible(true);
		jtf.requestFocus();
	}

	class AL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jtf)
				jcb.addItem(jtf.getText());

		}
	}

	public static void main(String[] args) {
		new Practice_02();

	}

}
