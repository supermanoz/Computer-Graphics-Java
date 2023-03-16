import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;

public class MPDAlgorithm extends JFrame implements ActionListener{
    JTextField tf1,tf2,tf3;
    JLabel lbl1,lbl2,lbl3;
    JButton jb;
    Graphics g;
    public MPDAlgorithm()
    {
        this.setTitle("Manoj MPD Algorithm");
        this.setSize(600,400);
        
        lbl1=new JLabel("Radius ");
        lbl1.setBounds(10,10,50,25);
        lbl2=new JLabel("X Co-ord: ");
        lbl2.setBounds(10,40,50,25);
        lbl3=new JLabel("Y Co-ord: ");
        lbl3.setBounds(10,70,50,25);
        tf1=new JTextField();
        tf1.setBounds(70,10,80,25); 
        tf2=new JTextField("0");
        tf2.setBounds(70,40,80,25);
        tf3=new JTextField("0");
        tf3.setBounds(70,70,80,25);
        jb=new JButton("Draw");
        jb.setBounds(70,100,80,25);
        jb.addActionListener(this);
        
        this.add(lbl1);
        this.add(lbl2);
        this.add(lbl3);
        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(jb);
        
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        g=this.getGraphics();
    }
    
    public static void main(String[] args)
    {
        new MPDAlgorithm();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        int r=Integer.parseInt(tf1.getText());
        int h=Integer.parseInt(tf2.getText());
        int k=Integer.parseInt(tf3.getText());
        
        System.out.println("Radius:"+r+" h: "+h+" k: "+k);
        
        int xk=0;
        int yk=r;
        int pk=1-r;
        while(xk<=yk)
        {
            g.fillRect(xk+h, yk+k, 1, 1);
            g.fillRect(yk+h, xk+k, 1, 1);
            g.fillRect(-xk+h, yk+k, 1, 1);
            g.fillRect(-yk+h, xk+k, 1, 1);
            g.fillRect(-xk+h, -yk+k, 1, 1);
            g.fillRect(-yk+h, -xk+k, 1, 1);
            g.fillRect(xk+h, -yk+k, 1, 1);
            g.fillRect(yk+h, -xk+k, 1, 1);

            
            
            if(pk<0){
                System.out.println("xk: "+(xk+h)+" yk: "+(yk+k)+" Pk: "+pk);
                pk=pk+(2*xk)+3;
                xk=xk+1;
                yk=yk;
            }

            if(pk>=0){
                System.out.println("xk: "+(xk+h)+" yk: "+(yk+k)+" Pk: "+pk);
                pk=pk+(2*(xk-yk))+5;
                xk=xk+1;
                yk=yk-1;
            }
        }
    }
}

