import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class gcda extends JFrame implements ActionListener{
    JTextField tf1,tf2,tf3;
    JLabel lb1,lb2,lb3;
    JButton jb;
    Graphics g;
    public gcda(){
        this.setTitle("Manoj's General Circle Drawing Algorithm");
        this.setSize(800,800);
        lb1=new JLabel("Radius ");
        lb1.setBounds(10,10,50,25);
        lb2=new JLabel("X Co: ");
        lb2.setBounds(10,40,50,25);
        lb3=new JLabel("Y Co: ");
        lb3.setBounds(10,70,50,25);
        tf1=new JTextField();
        tf1.setBounds(70,10,80,25); 
        tf2=new JTextField();
        tf2.setBounds(70,40,80,25);
        tf3=new JTextField();
        tf3.setBounds(70,70,80,25);
        jb=new JButton("Draw");
        jb.setBounds(70,100,80,25);
        jb.addActionListener(this);
        
        this.add(lb1);
        this.add(lb2);
        this.add(lb3);
        this.add(tf1);
        this.add(tf2);
        this.add(tf3); this.add(jb);
        
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        g=this.getGraphics();
    }
    
    public static void main(String[] args)
    {
        new gcda();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        int r=Integer.parseInt(tf1.getText());
        int h=Integer.parseInt(tf2.getText());
        int k=Integer.parseInt(tf3.getText());
        
        System.out.println("Radius:"+r+" h: "+h+" k: "+k);
        
        int xk=r;
        int yk=0;
        
       while(xk>=yk)
        {
            g.fillRect(xk+h, yk+k, 1, 1);
            g.fillRect(-xk+h, yk+k, 1, 1);
            g.fillRect(-xk+h, -yk+k, 1, 1);
            g.fillRect(xk+h, -yk+k, 1, 1);
            g.fillRect(yk+k,xk+h, 1, 1);
            g.fillRect(yk+k,-xk+h,  1, 1);
            g.fillRect(-yk+k,-xk+h,  1, 1);
            g.fillRect(-yk+k,xk+h, 1, 1);
            System.out.println("xk: "+(xk+h)+" yk: "+(yk+k)+" || "+"xk: "+(-xk+h)+" -yk: "+(yk+k)+" || "+"xk: "+(-xk+h)+" yk: "+(-yk+k)+" || "+"xk: "+(xk+h)+" yk: "+(-yk+k)+" || ");
            xk--;
            yk=(int)Math.round(Math.sqrt((r*r)-(xk*xk)));
        }
    }
}