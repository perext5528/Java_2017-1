import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TestEx extends JFrame{
	String[] menuarr= {"a", "b", "c", "d"};
	String[] menubararr = {"qwe", "rty", "yui", "iop"};
	String[] menubaritem= {"A", "B", "C", "D"};
	TestEx(){
		this.setTitle("Á¦¸ñ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		createMenu();
		this.setSize(300,300);
		this.setVisible(true);
		
	}
	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu menu= new JMenu("asdsa");
		for(int i=0;i<4;i++) {
			menu.add(new JMenuItem(menubaritem[i]));
			mb.add(new JMenu(menuarr[i]));
		}
		mb.add(menu);
		
		
		setJMenuBar(mb);
	}
	
	
	public static void main(String[] args) {
		new TestEx();

	}

}
