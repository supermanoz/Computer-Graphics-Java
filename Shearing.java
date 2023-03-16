import java.awt.Graphics;
import javax.swing.JFrame;
class Shearing extends JFrame
{
  int x1 = 200; int y1 = 100; int x2 = 300;
  int y2 = 100; int x3 = 300; int y3 = 300;
  int x4 = 200; int y4 = 300; int sfact = 2;
  int sx1,sx2,sx3,sx4;
  public Shearing()
  {
    setTitle("Manoj Shearing");
    setSize(2000,2000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    sx1 = x1 + y1*sfact;
    sx2 = x2 + y2*sfact;
    sx3 = x3+  y3*sfact;
    sx4 = x4+  y4*sfact;
    setVisible(true);
  }
  public void paint(Graphics g)
  {
    g.drawLine(x1, y1, x2, y2);
    g.drawLine(x2, y2, x3, y3);
    g.drawLine(x3, y3, x4, y4);
    g.drawLine(x4, y4, x1, y1);

    g.drawLine(sx1, y1, sx2, y2);
    g.drawLine(sx2, y2, sx3, y3);
    g.drawLine(sx3, y3, sx4, y4);
    g.drawLine(sx4, y4, sx1, y1);
  }
  public static void main(String args[])
  {
    new Shearing();
  }
}
