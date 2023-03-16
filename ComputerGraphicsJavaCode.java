import static java.awt.Color.*;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class ComputerGraphicsJavaCode extends JFrame implements ActionListener{
    Graphics g;
    JButton btn1,btn2;
    JLabel lbl;
    JTextField tf;
    Graphics2D gtd;
    public ComputerGraphicsJavaCode()
    {
           this.setTitle("Manoj's Computer Graphics");
           this.setSize(600,400);
           
           tf=new JTextField("Hi");
           tf.setBounds(110,30,70,25);
           lbl=new JLabel("Your Text");
           lbl.setBounds(20,30,70,25);
           btn1=new JButton("Draw String");
           btn1.setBounds(50,80,100,40);
           btn1.addActionListener(this);
           btn1.setActionCommand("drawstring");
           btn2=new JButton("Draw Line");
           btn2.setBounds(200,80,100,40);
           btn2.addActionListener(this);
           
           this.add(tf);
           this.add(lbl);
           this.add(btn1);
           this.add(btn2);
           
           this.setLayout(null);
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setVisible(true);
           
           
           g=this.getGraphics();
    }
    
    public static void main(String [] args)
    {
        new ComputerGraphicsJavaCode();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand()=="drawstring")
        {
            String str=tf.getText();
            Font f=new Font("Times New Roman",1,100);
            g.setFont(f);
            g.setColor(green);
            g.drawString(str, 200, 300);
        }
        else{
            //solid line
            gtd=(Graphics2D) g;
            gtd.setColor(red);
            Stroke strk=new BasicStroke(2f);
            gtd.setStroke(strk);
            gtd.drawLine(420,50,660,50);
            
            //dotted line
            float[] dashpattern={2f,2f};
            gtd.setColor(blue);
            Stroke strk1=new BasicStroke(2f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1.0f,dashpattern,2.0f);
            gtd.setStroke(strk1);
            gtd.drawLine(420,90,660,90);
            
            //dashed line
            gtd.setColor(yellow);
            float dashpattern2[]={10f,4f};
            gtd.setStroke(new BasicStroke(2f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1.0f,dashpattern2,0.0f));
            gtd.drawLine(420, 130, 660, 130);
            
            gtd.translate(100, 100);
            gtd.drawLine(420,50,660,50);
            
            /*gtd.rotate(-30);
            gtd.drawLine(420,50,660,50);*/
            
            gtd.scale(2, 3);
            gtd.drawLine(420,50,660,50);
        }
    }
    
}
