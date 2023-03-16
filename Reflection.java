
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;

public class Reflection extends JFrame implements ActionListener{
    JTextField tf1,tf2,tf3,tf4;
    JLabel lbl1,lbl2,lbl3,lbl4;
    JButton jb1,jb2;
    static Graphics g;
    public Reflection()
    {
        this.setTitle("Manoj Reflection Algorithm");
        this.setSize(1200,1000);
        
        lbl1=new JLabel("X1: ");
        lbl1.setBounds(10,10,30,25);
        lbl2=new JLabel("Y1: ");
        lbl2.setBounds(10,40,30,25);
        lbl3=new JLabel("X2: ");
        lbl3.setBounds(10,70,30,25);
        lbl4=new JLabel("Y2: ");
        lbl4.setBounds(10,100,30,25);
        
        tf1=new JTextField();
        tf1.setBounds(70,10,100,25); 
        tf2=new JTextField();
        tf2.setBounds(70,40,100,25);
        tf3=new JTextField();
        tf3.setBounds(70,70,100,25); 
        tf4=new JTextField();
        tf4.setBounds(70,100,100,25);
        
        jb1=new JButton("Draw");
        jb1.setBounds(70,130,100,25);
        jb1.addActionListener(this);
        jb1.setActionCommand("draw");
        
        jb2=new JButton("Reflect(X)");
        jb2.setBounds(290,70,100,25);
        jb2.addActionListener(this);
        jb2.setActionCommand("transform");
        
        this.add(lbl1);
        this.add(lbl2);
        this.add(lbl3);
        this.add(lbl4);
        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(tf4);
        this.add(jb1);
        this.add(jb2);
        
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        g=this.getGraphics();
    }
    
    public static void main(String[] args)
    {
        new Reflection();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        int x1=Integer.parseInt(tf1.getText());
        int y1=Integer.parseInt(tf2.getText());
        int x2=Integer.parseInt(tf3.getText());
        int y2=Integer.parseInt(tf4.getText());
        if(ae.getActionCommand().equals("draw"))
        {
            System.out.println("X1: "+x1+" Y1: "+y1+" X2: "+x2+" Y2: "+y2);
            g.drawLine(x1, y1, x2, y2);
        }
        
        if(ae.getActionCommand().equals("transform"))
        { 
            int line[][]={{x1,x2},{y1,y2},{1,1}};
            int transform[][]={{1,0,0},{0,-1,0},{0,0,1}};
            int reflectedLine[][]=matrixMult(transform,line);
            int translate[][]={{1,0,500},{0,1,500},{0,0,1}};
            int finalLine[][]=matrixMult(translate,reflectedLine);
            
            System.out.println("X1: "+finalLine[0][0]+" Y1: "+finalLine[1][0]+" X2: "+finalLine[0][1]+" Y2: "+finalLine[1][1]);
            g.drawLine(finalLine[0][0],finalLine[1][0],finalLine[0][1],finalLine[1][1]);
        }
    }
    
    public int[][] matrixMult(int transform[][],int line[][])
    {
        int temp=0;
        int res[][]=new int[3][2];
        for(int i=0;i<3;i++)
            {
                for(int j=0;j<2;j++)
                {
                    for(int k=0;k<3;k++)
                    {
                        temp=(transform[i][k]*line[k][j])+temp;
                    }
                    res[i][j]=temp;
                    temp=0;
                }
            }
        return res;
    }
}



