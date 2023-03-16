import java.util.Scanner;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
public class reflec extends JFrame
{
	static int x1=300;
	static int y1=400;
	static int x2=500;
	static int y2=600;
	Graphics2D gtd;
	public reflec()
	{
		this.setSize(1000,1000);
		this.setTitle("Reflection");
		this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void paint(Graphics g)
	{
		super.repaint();
		gtd=(Graphics2D)g;
		gtd.drawLine(100,200,500,600);
		gtd.translate(0,y1+y1);
        gtd.scale(1, -1); 
        gtd.setColor(Color.red);
        gtd.drawLine(100,200,500,600);
	}
	public static void main(String [] args)
	{
		new reflec();
	}
}