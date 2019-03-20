import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class EX extends JFrame 
{
    Container cp;
    int[] monnom = {50000, 10000, 1000, 500, 100, 50, 10, 1};
    String[] str = {"금액", "오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
    JLabel jl = new JLabel();
    JTextField[] jt = new JTextField[str.length];
    JButton jb = new JButton("계산");
    JCheckBox[] jc = new JCheckBox[monnom.length - 1];
    boolean bl = true;
    boolean[] jcbl = new boolean[monnom.length];
    
    EX() 
    {
        setTitle("Money Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = getContentPane();
        setLayout(null);
        
        jl = new JLabel(str[0]);
        jl.setSize(50, 20);
        jl.setLocation(20, 20);
        cp.add(jl);
        
        jt[0] = new JTextField(30);
        jt[0].setSize(100, 20);
        jt[0].setLocation(100, 20);
        cp.add(jt[0]);
        
        jb.setSize(70, 20);
        jb.setLocation(210, 20);
        jb.addActionListener(new actionjb());
        cp.add(jb);
        for(int i = 1; i < str.length; i++)
        {
            jcbl[i - 1] = true;
            jl = new JLabel(str[i]);
            jl.setHorizontalAlignment(JLabel.RIGHT);
            jl.setSize(50, 20);
            jl.setLocation(50, 50+(i*20));
            
            jt[i] = new JTextField(30);
            jt[i].setHorizontalAlignment(JTextField.CENTER);
            jt[i].setSize(70, 20);
            jt[i].setLocation(120, 50+(i*20));
            jt[i].setEditable(false);
            if(i < str.length - 1)
            {
                jc[i-1] = new JCheckBox();
                jc[i-1].addItemListener(new itemjc());
                jc[i-1].setHorizontalAlignment(JCheckBox.RIGHT);
                jc[i-1].setSize(20, 20);
                jc[i-1].setLocation(210, 50+(i*20));
                cp.add(jc[i-1]);
            }
            cp.add(jl);
            cp.add(jt[i]);
        }
        setSize(300, 300);
        setVisible(true);
    }
    
    public class actionjb implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            String mon = jt[0].getText();
            if(mon.length() == 0) return;
            
            int money = Integer.parseInt(mon);
            int m;
            
            for(int i=0; i<monnom.length; i++) 
            {
                if(jcbl[i]==true)
                {
                    m = money/monnom[i];
                    jt[i + 1].setText(Integer.toString(m));
                    if(m > 0) money = money % monnom[i];
                }
                else if (jcbl[i] == false)jt[i +1].setText("0");
            }
        }
    }
    public class itemjc implements ItemListener
    {
        public void itemStateChanged(ItemEvent e) 
        {
                if(e.getStateChange()==ItemEvent.SELECTED) bl = false;
                else bl = true;
                
                for(int i = 0; i < jcbl.length; i++)
                {
                    if (i == jcbl.length -1)
                    {
                        jcbl[i] = true;
                    }
                    else if(e.getItem() == jc[i])
                    {
                        jcbl[i] = bl;
                    }
                }
        }
        
    }
    public static void main(String[] args) 
    {
        new EX();
    }
}