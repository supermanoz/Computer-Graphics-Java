import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.image.BufferedImage; 
import java.awt.image.WritableRaster;
import javax.swing.JFrame; 
public class BoundaryFill extends JFrame {
    public static int width = 750; 
    public static int height = 750; 
    public void BoundaryFilling(int x, int y, Color fill, Color Boundary, WritableRaster raster)
    { 
       int[] fillColor = {fill.getRed(), fill.getGreen(), fill.getBlue(),fill.getAlpha()}; 
       int[] BoundaryColor = {Boundary.getRed(), Boundary.getGreen(),Boundary.getBlue(), Boundary.getAlpha()}; 
       int[] curColor = raster.getPixel(x,y,new int[]{255,255,255,255}) ; 
       if ((!isEqualRgba(curColor, BoundaryColor)) && (!isEqualRgba(curColor,fillColor)))
       { 
           raster.setPixel(x, y, fillColor); 
           BoundaryFilling(x + 1, y, fill, Boundary, raster); 
           BoundaryFilling(x - 1, y, fill, Boundary, raster); 
           BoundaryFilling(x, y + 1, fill, Boundary, raster); 
           BoundaryFilling(x, y - 1, fill, Boundary, raster);  } } 
           private boolean isEqualRgba(int[] pix1, int[] pix2) {  
            return pix1[0] == pix2[0] && pix1[1] == pix2[1] && pix1[2] == pix2[2] && pix1[3] == pix2[3];
        } 
        @Override 
        public void paint(Graphics g){ 
         Graphics2D g2d = (Graphics2D) g; 
         BufferedImage bi= new   BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB); 
         Graphics2D big2d = bi.createGraphics(); 
         big2d.setColor(Color.BLACK); 
         big2d.drawRect(250, 250, 40, 40); 
         WritableRaster raster = bi.getRaster(); 
         BoundaryFilling(251, 251, Color.GREEN,Color.BLACK, raster); 
         g2d.drawImage(bi, 0, 0, null); } 
         public static void main(String[] args) { 
             BoundaryFill frame = new BoundaryFill(); 
             frame.setTitle("Boundary Fill"); 
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setSize(800,600); 
             frame.setVisible(true); 
         }
    }
