import java.awt.*; 
import java.awt.event.*; 
import java.awt.image.BufferedImage; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
public class FloodFill extends JPanel
{ 
	private BufferedImage image; 
	private Graphics2D g2; 
	public static void main(String[] args)
	{ 
		JFrame frame = new JFrame("Manoj FloodFill"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		FloodFill fill=new FloodFill(); 
		frame.add(fill); 
		frame.pack(); 
		frame.setVisible(true); 
	} 
	public FloodFill()
	{ 
		image= new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB); 
		setPreferredSize(new Dimension(image.getWidth(), image.getHeight())); 
		setMinimumSize(getPreferredSize()); 
		g2=image.createGraphics(); 
		g2.setColor(Color.WHITE); 
		g2.drawRect(100, 100, 100, 100); 
		addMouseListener(new MouseAdapter(){ public void mouseClicked(MouseEvent e){ floodFill(e.getX(), e.getY(), image.getRGB(e.getX(), e.getY())); }});
	} 
	@Override 
	public void paintComponent(Graphics g)
	{ 
		g.drawImage(image, 0, 0, null);
	} 
	public void floodFill(int seedX, int seedY, int rgb)
	{ 
		if(image.getRGB(seedX, seedY)==rgb) { 
			image.setRGB(seedX,seedY,Color.PINK.getRGB()); 
			update(getGraphics()); 
			floodFill(seedX-1, seedY-1, rgb); 
			floodFill(seedX-1,seedY+1,rgb); 
			floodFill(seedX+1,seedY-1,rgb); 
			floodFill(seedX+1,seedY+1,rgb); 
			floodFill(seedX,seedY-1,rgb); 
			floodFill(seedX,seedY+1,rgb); 
			floodFill(seedX-1,seedY,rgb); 
			floodFill(seedX+1,seedY,rgb); 
		}
	}
}
