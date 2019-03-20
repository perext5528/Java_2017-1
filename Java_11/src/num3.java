import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class num3 extends JFrame{
   JPanel pane_north = new JPanel();
   JPanel pane_center = new JPanel();
   String []won = {"오만원","만원","천원","오백원","백원","오십원","십원","일원"};
   JLabel []la = new JLabel[won.length];
   JLabel mon= new JLabel("금액");
   JTextField[] tf = new JTextField[won.length];
   JButton calcul = new JButton("계산");
   
   num3(){
      this.setLayout(new BorderLayout());
      JTextField input = new JTextField(10);
      pane_north.add(mon);
      pane_north.add(input);
      
      pane_center.setLayout(new GridLayout(8,2));
      for (int i=0;i<won.length;i++){
         la[i] = new JLabel(won[i]);
         tf[i]=new JTextField(6);
         pane_center.add(la[i]);
         pane_center.add(tf[i]);
      }
      
      calcul.addMouseListener(new MouseAdapter(){
         public void mouseClicked(MouseEvent e){
            int money = Integer.parseInt(input.getText());
            int temp =0;
            int [] arr={50000,10000,1000,500,100,50,10,1};
            
            if (e.getSource()==calcul){
               for (int i=0;i<won.length;i++){
                  temp=money;
                  if (temp/arr[i]>0){
                     temp/=arr[i];
                     tf[i].setText(Integer.toString(temp));
                     money-=(temp*arr[i]);
                  }
               }
            }
         }
      });
      pane_north.add(calcul);
      pane_north.setBackground(Color.PINK);
      pane_center.setBackground(Color.PINK);
      this.add(pane_north,BorderLayout.NORTH);
      this.add(pane_center,BorderLayout.CENTER);
      this.setTitle("Money Changer");
      this.setSize(300,400);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public static void main(String[] args) {
      new num3();
   }
}