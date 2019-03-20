import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Practice_09 extends JFrame {
	ImageIcon[] im = { new ImageIcon("Image/2.png"), new ImageIcon("Image/1.png"),
			new ImageIcon("Image/3.png") };

	MenuPanel menuPanel = new MenuPanel();
	GamePanel gamePanel = new GamePanel();

	public Practice_09() {
		setTitle("실습문제 9번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(menuPanel, BorderLayout.NORTH);
		add(gamePanel, BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);
	}

	class MenuPanel extends JPanel {
		JButton[] jb = new JButton[3];

		public MenuPanel() {
			setBackground(Color.GRAY);
			for (int i = 0; i < jb.length; i++) {
				jb[i] = new JButton(im[i]);
				add(jb[i]);

				jb[i].addActionListener(new RPSListener());
			}
		}
	}

	class GamePanel extends JPanel {
		JLabel me = new JLabel("me");
		JLabel com = new JLabel("com");
		JLabel win = new JLabel("Winner");

		public GamePanel() {
			setBackground(Color.YELLOW);
			add(me);
			add(com);
			add(win);
			win.setForeground(Color.RED);
		}

		public void draw(Icon myImage, Icon computerImage, String w) {
			me.setIcon(myImage);
			com.setIcon(computerImage);
			win.setText(w);
		}
	}

	class RPSListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton) e.getSource();
			int comv = (int) (Math.random() * 3);

			String win;

			if (jb.getIcon() == im[0] && comv == 2 || jb.getIcon() == im[1] && comv == 0
					|| jb.getIcon() == im[2] && comv == 1)
				win = "ME !!!";
			else if (jb.getIcon() == im[0] && comv == 1 || jb.getIcon() == im[1] && comv == 2
					|| jb.getIcon() == im[2] && comv == 0)
				win = "Computer !!!";
			else
				win = "Same !!!";

			gamePanel.draw(jb.getIcon(), im[comv], win);
		}
	}

	public static void main(String[] args) {
		new Practice_09();
	}
}