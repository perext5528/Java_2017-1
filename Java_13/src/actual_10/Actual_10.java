package actual_10;

import java.awt.*;
import java.awt.Event;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Actual_10 extends JFrame{
	
	Actual_10(){
		this.setTitle("Actual_10");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(null);
		this.setVisible(true);
		this.setSize(300,  300);
		
	}
	public static void main(String[] args) {
		new Actual_10();

	}

}
class SnowThread extends Thread{
	Vector<Point> snowVector= new Vector<Point>();
	public void snow(Graphics g) {
		g.setColor(Color.WHITE);
		for(int i=0;i<snowVector.size();i++) {
			Point p = snowVector.get(i);
			g.fillOval(p.x, p.y, 10, 10);
		}
	}
	public void changeSnowPosition() {
		for(int i =0;i<snowVector.size();i++) {
			Point p = snowVector.get(i);
			p.x+=(int)(Math.random()*2);
			p.y+=(int)(Math.random()*2);
			if(p.x>500)p.x=0;
			if(p.y>500)p.y=0;
			snowVector.set(i, p);
		}
	}
	public void run() {
		while(true) {
			try {
				sleep(20);
				
			}catch(InterruptedException e) {
				return;
			}
			changeSnowPosition();
			
		}
	}
}