import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;

public class BLAAlgorithm extends JFrame implements ActionListener{
    JTextField tf1,tf2,tf3,tf4;
    JLabel lbl1,lbl2,lbl3,lbl4;
    JButton jb;
    Graphics g;
    public BLAAlgorithm()
    {
        this.setTitle("Manoj BLA Algorithm");
        this.setSize(600,400);
        
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
        new BLAAlgorithm();
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
        int dx=Math.abs(delx);
        int dy=Math.abs(dely);
        int Pk,xk=x1,yk=y1;
        
        if(dx>dy)
            {
                Pk=2*dy-dx;
                do{
                    System.out.println("xk: "+xk+" yk: "+yk+" Pk: "+Pk);
                    g.fillRect(xk, yk, 1, 1);
                    if(Pk>=0)
                    {
                        if(delx>0)
                            xk=xk+1;
                        if(delx<=0)
                            xk=xk-1;
                        
                        if(dely>0)
                            yk=yk+1;
                        if(dely<=0)
                            yk=yk-1;
                        
                        Pk=Pk+(2*dy)-(2*dx);
                    }
                    else{
                        if(delx>0)
                            xk=xk+1;
                        if(delx<=0)
                            xk=xk-1;
                        
                        yk=yk;
                        Pk=Pk+(2*dy);
                    }  
                }while(xk!=x2);
                System.out.println("xk: "+xk+" yk: "+yk+" Pk: "+Pk);
                g.fillRect(xk, yk, 1, 1);
            }

            else{
                Pk=2*dx-dy;
                do{
                    System.out.println("xk: "+xk+" yk: "+yk+" Pk: "+Pk);
                    g.fillRect(xk, yk, 1, 1);
                    if(Pk>=0)
                    {
                        if(delx>0)
                            xk=xk+1;
                        if(delx<=0)
                            xk=xk-1;
                        
                        if(dely>0)
                            yk=yk+1;
                        if(dely<=0)
                            yk=yk-1;
                        Pk=Pk+(2*dx)-(2*dy);
                    }
                    else{
                        xk=xk;
                        if(dely>0)
                            yk=yk+1;
                        if(dely<=0)
                            yk=yk-1;
                        Pk=Pk+(2*dx);
                    }
                }while(yk!=y2);
                System.out.println("xk: "+xk+" yk: "+yk+" Pk: "+Pk);
                g.fillRect(xk, yk, 1, 1);
            }
    }
}
