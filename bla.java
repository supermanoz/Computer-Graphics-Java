import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;

public class bla extends JFrame implements ActionListener{
    JButton jb;
    Graphics g;
    int x1,y1,x2,y2;
    public bla()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter x1 and y1 co-ordinates: ");
        x1=s.nextInt();
        y1=s.nextInt();
        System.out.println("Enter x2 and y2 co-ordinates: ");
        x2=s.nextInt();
        y2=s.nextInt();
        this.setTitle("BLA Algorithm");
        this.setSize(600,400);
        jb=new JButton("Draw");
        jb.setBounds(10,20,80,25);
        jb.addActionListener(this);
        this.add(jb);
        
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        g=this.getGraphics();
    }
    
    public static void main(String[] args)
    {
        new  bla();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {   
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
