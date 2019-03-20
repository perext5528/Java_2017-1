import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_03 extends JFrame {
	JPanel jp = new JPanel();
	JTextField jtf = new JTextField(10);
	JButton btn = new JButton("계산");
	JLabel[] la_moneytype = new JLabel[8];
	String[] moneytype = { "5만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원" };
	JTextField[] cal_result = new JTextField[8];

	Practice_03() {
		this.setTitle("실습문제 3번");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.add(jp);
		jp.setLayout(new FlowLayout());
		jp.add(new JLabel("금액"));
		jp.add(jtf);
		jp.add(btn);
		jp.setSize(300, 50);
		jp.setBackground(Color.PINK);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int temp = Integer.parseInt(jtf.getText());
				int[] cal_money = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };
				for (int i = 0; i < la_moneytype.length; i++) {
					if (temp == 0)
						cal_result[i].setText("0");
					else {
						cal_result[i].setText(Integer.toString(temp / cal_money[i]));
						temp = temp % cal_money[i];
					}
				}
			}
		});

		for (int i = 0; i < la_moneytype.length; i++) {
			la_moneytype[i] = new JLabel(moneytype[i]);
			la_moneytype[i].setLocation(50, 50 + i * 20);
			la_moneytype[i].setSize(50, 20);

			cal_result[i] = new JTextField(8);
			cal_result[i].setLocation(120, 50 + i * 20);
			cal_result[i].setSize(70, 20);
			cal_result[i].setHorizontalAlignment(JTextField.CENTER);
			cal_result[i].setEditable(false);
			c.add(la_moneytype[i]);
			c.add(cal_result[i]);
		}
		c.setBackground(Color.PINK);
		this.setSize(300, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Practice_03();
	}
}
