import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math;

public class DDAAlgorithm extends JFrame implements ActionListener{
    JTextField tf1,tf2,tf3,tf4;
    JLabel lbl1,lbl2,lbl3,lbl4;
    JButton jb;
    Graphics g;
    double xk;
    double yk;
    public DDAAlgorithm(){
        this.setSize(600,400);
        this.setTitle("DDA Algorithm");
        
        lbl1=new JLabel("X1: ");
        lbl1.setBounds(10,10,30,25);
        lbl2=new JLabel("Y1: ");
        lbl2.setBounds(10,40,30,25);
        lbl3=new JLabel("X2: ");
        lbl3.setBounds(10,70,30,25);
        lbl4=new JLabel("Y2: ");
        lbl4.setBounds(10,100,30,25);
        tf1=new JTextField();
        tf1.setBounds(70,10,80,25); 
        tf2=new JTextField();
        tf2.setBounds(70,40,80,25);
        tf3=new JTextField();
        tf3.setBounds(70,70,80,25);
        tf4=new JTextField();
        tf4.setBounds(70,100,80,25);
        jb=new JButton("Draw");
        jb.setBounds(70,140,80,25);
        jb.addActionListener(this);
        
        
        this.add(lbl1);
        this.add(lbl2);
        this.add(lbl3);
        this.add(lbl4);
        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(tf4);
        this.add(jb);
        
        
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        g=this.getGraphics();
    }
    
    public static void main(String[] args)
    {
       DDAAlgorithm obj= new DDAAlgorithm();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        int x1=Integer.parseInt(tf1.getText());
        int y1=Integer.parseInt(tf2.getText());
        int x2=Integer.parseInt(tf3.getText());
        int y2=Integer.parseInt(tf4.getText());
        int delx=x2-x1;
        int dely=y2-y1;
        double m=(double)dely/delx;
        
        System.out.println("x1: "+x1+" y1: "+y1+" x2: "+x2+" y2: "+y2+" delx: "+delx+" dely: "+dely);
        System.out.println("m: "+m);
        
        if(Math.abs(delx)>=Math.abs(dely))
        {
            xk=x1;
            yk=y1;
            
            if(x1>x2 && m>0)
            {
                xk=x2;
                yk=y2;
                for(int j=x2;j>x1;j++)
                {
                    g.fillRect((int) xk, (int) Math.round(yk),1,1);
                    xk++;
                    yk=yk+m;
                    System.out.println("xk: "+xk+" and yk:"+yk+" and ykk: "+Math.round(yk));
                }
            }
            
            if(x1>x2)
            {
                for(int j=x1;j>x2;j--)
                {
                    g.fillRect((int) xk, (int) Math.round(yk),1,1);
                    xk--;
                    yk=yk+m;
                    System.out.println("xk: "+xk+" and yk:"+yk+" and ykk: "+Math.round(yk));
                }
            }
            
            else{
            for(int i=x1;i<x2;i++)
              {
                g.fillRect((int) xk, (int) Math.round(yk),1,1);
                xk++;
                yk=yk+m;
                System.out.println("xk: "+xk+" and yk:"+yk+" and ykk: "+Math.round(yk));
              }
            }
        }
        if(Math.abs(dely)>Math.abs(delx))
        {
            xk=x1;
            yk=y1;
            
            if(y1>y2 && m>0)
            {
                xk=x2;
                yk=y2;
                for(int j=y2;j>y1;j++)
                {
                    g.fillRect((int) xk, (int) Math.round(yk),1,1);
                    yk++;
                    xk=xk+(1/m);
                    System.out.println("xk: "+xk+" and yk:"+yk+" and ykk: "+Math.round(yk));
                }
            }
            
            if(y1>y2)
            {
                for(int j=y1;j>y2;j--)
                {
                    g.fillRect((int) xk, (int) Math.round(yk),1,1);
                    yk--;
                    xk=xk+(1/m);
                    System.out.println("xk: "+xk+" and yk:"+yk+" and ykk: "+Math.round(xk));
                }
            }
            else{
                 for(int i=y1;i<y2;i++)
                   {
                    g.fillRect((int) xk, (int) Math.round(yk),1,1);
                    yk++;
                    xk=xk+(1/m);
                    System.out.println("xk: "+xk+" and yk:"+yk+" and ykk: "+Math.round(xk));
                 }
            }
        }
    }
}
