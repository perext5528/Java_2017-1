import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class temp extends JFrame{
    JPanel contentPane = new JPanel();
    JLabel la = new JLabel("C");
    
    temp(){
        this.setTitle("클릭 연습용 응용프로그램");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(contentPane);
        contentPane.setLayout(null);
        la.setLocation(100,100);
        la.setSize(10,10);
        
        contentPane.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                la.setLocation((int)(Math.random()*300),(int)(Math.random()*300));
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
        contentPane.add(la);
        
        this.setSize(300,300);
        this.setVisible(true);
        
        contentPane.requestFocus();
    }

//public class JavaApplication25 {

    public static void main(String[] args) {
        new temp();
    }
    
}

