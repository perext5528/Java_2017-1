package actual_06;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class BubbleThread extends Thread {
	Thread th = null;
	JLabel b = null;

	BubbleThread(JLabel b) {
		this.b = b;
	}

	public void run() {
		while (true) {
			int x = b.getX();
			int y = b.getY()-5;
			
			if (y <= 0) {
				b.setVisible(false);
				Thread.interrupted();
				
			} else
				b.setLocation(x, y);
			try {
				sleep(20);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}

public class Actual_06 extends JFrame {
	ImageIcon img = new ImageIcon("a.png");
	JLabel b;
	public Actual_06() {
		this.setTitle("Actual_06");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(null);		
		
		
		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				b = new JLabel(img);
				b.setSize(img.getIconWidth(),img.getIconHeight() );
				c.add(b);
				b.setLocation(e.getPoint());
				if(b!=null){
					BubbleThread bth = new BubbleThread(b);
					bth.start();
				}
			}
		});
		
		this.setVisible(true);
		this.setSize(500, 800);
	}

	public static void main(String[] args) {
		new Actual_06();
	}
}
