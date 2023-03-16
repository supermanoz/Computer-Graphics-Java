import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class G2DTransformation extends JFrame implements ActionListener{
    JTextField tf1,tf2,tf3,tf4,transx,transy,tfdeg,tfsx,tfsy;
    JLabel lbl1,lbl2,lbl3,lbl4,lbltx,lblty,lbldeg,lblsx,lblsy;
    JButton jb1,jb2,jb3,jb4,jb5,jb6;
    Graphics2D gtd;
    int x1,x2,y1,y2;
    String command;
    int tx,ty,sx,sy;
    double deg;
    public G2DTransformation()
    {
        this.setTitle("Manoj G2DTransformation Algorithm");
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
        
        
        lbltx=new JLabel("Tx:");
        lbltx.setBounds(250,10,30,25);
        lblty=new JLabel("Ty:");
        lblty.setBounds(250,40,30,25);
        transx=new JTextField();
        transx.setBounds(290,10,100,25);
        transy=new JTextField();
        transy.setBounds(290,40,100,25);
        
        jb2=new JButton("Translate");
        jb2.setBounds(290,70,100,25);
        jb2.addActionListener(this);
        jb2.setActionCommand("translate");
        
        lbldeg=new JLabel("Theta:");
        lbldeg.setBounds(490,10,75,25);
        tfdeg=new JTextField();
        tfdeg.setBounds(550,10,100,25);
        
        jb3=new JButton("Rotate");
        jb3.setBounds(550,40,100,25);
        jb3.addActionListener(this);
        jb3.setActionCommand("rotate");
        
        lblsx=new JLabel("Sx:");
        lblsx.setBounds(750,10,30,25);
        lblsy=new JLabel("Sy:");
        lblsy.setBounds(750,40,30,25);
        tfsx=new JTextField();
        tfsx.setBounds(790,10,100,25);
        tfsy=new JTextField();
        tfsy.setBounds(790,40,100,25);
        
        jb4=new JButton("Scale");
        jb4.setBounds(790,70,100,25);
        jb4.addActionListener(this);
        jb4.setActionCommand("scale");

        jb5=new JButton("Reflect X");
        jb5.setBounds(950,10,100,25);
        jb5.addActionListener(this);
        jb5.setActionCommand("reflectx");

        jb6=new JButton("Reflect Y");
        jb6.setBounds(950,40,100,25);
        jb6.addActionListener(this);
        jb6.setActionCommand("reflecty");
        
        this.add(lbl1);
        this.add(lbl2);
        this.add(lbl3);
        this.add(lbl4);
        this.add(lbltx);
        this.add(lblty);
        this.add(lbldeg);
        this.add(lblsx);
        this.add(lblsy);
        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(tf4);
        this.add(transx);
        this.add(transy);
        this.add(tfdeg);
        this.add(tfsx);
        this.add(tfsy);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jb6);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        gtd=(Graphics2D)g;
        
        if(command.equals("draw"))
        {
            gtd.drawLine(x1, y1, x2, y2);
        }
        
        if(command.equals("translate"))
        {
            gtd.setColor(Color.red);
            gtd.translate(tx, ty);
            gtd.drawLine(x1, y1, x2, y2);
        }
        
        if(command.equals("rotate"))
        {
            gtd.setColor(Color.blue);
            gtd.rotate(Math.toRadians(deg));
            gtd.drawLine(x1, y1, x2, y2);
        }
        
        if(command.equals("scale"))
        {
            gtd.setColor(Color.green);
            gtd.scale(sx, sy);
            gtd.drawLine(x1, y1, x2, y2);
        }

       if(command=="reflectx"){
           gtd.setColor(Color.black);
           gtd.drawLine(x1, y1, x2, y2);
           gtd.setColor(Color.red);
           gtd.translate(0,y1+y1);
           gtd.scale(1, -1);    
           gtd.drawLine(x1, y1, x2, y2); 
           
       }
       
       if(command=="reflecty"){
           gtd.setColor(Color.black);
           gtd.drawLine(x1, y1, x2, y2);
           gtd.setColor(Color.red);
           gtd.translate(x1+x1,0);
           gtd.scale(-1, 1);    
           gtd.drawLine(x1, y1, x2, y2); 
           
       }
        
    }
    
    public static void main(String[] args)
    {
        new G2DTransformation();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    { 
        if(ae.getActionCommand().equals("draw"))
        {
            x1=Integer.parseInt(tf1.getText());
            y1=Integer.parseInt(tf2.getText());
            x2=Integer.parseInt(tf3.getText());
            y2=Integer.parseInt(tf4.getText());
            System.out.println("X1: "+x1+" Y1: "+y1+" X2: "+x2+" Y2: "+y2);
            command="draw";
        } 
        
        if(ae.getActionCommand().equals("translate"))
        {
            tx=Integer.parseInt(transx.getText());
            ty=Integer.parseInt(transy.getText());
        }
        
        if(ae.getActionCommand().equals("rotate"))
        {
            deg=Double.parseDouble(tfdeg.getText());
        }
        
        if(ae.getActionCommand().equals("scale"))
        {
            sx=Integer.parseInt(tfsx.getText());
            sy=Integer.parseInt(tfsy.getText());
        }
        
        command=ae.getActionCommand();
        super.repaint();
    }
}



