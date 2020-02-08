
package Paint_New_Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class drawArea extends JComponent{
      private BufferedImage image,scalled;
      private Graphics2D g2;
      private int w,h;
      
public drawArea(){
     setDoubleBuffered(false);
    }

 protected void paintComponent(Graphics g) {
    if (image == null) {
      image=(BufferedImage) createImage(getSize().width, getSize().height);
      g2 = (Graphics2D) image.getGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
        
      
      clear();
    }
    
    else {
    g2=image.createGraphics();
    
    }
     // Dimension dim = getPreferredSize();
     setW(this.getWidth());
     setH(this.getHeight());
     
     g.drawImage(image, 0, 0, null);
  }
 
   public void clear() {
    g2.setPaint(Color.white);
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setPaint(Color.black);
    repaint();
  }
   
   
   
   
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Graphics2D getG2() {
        return g2;
    }

    public void setG2(Graphics2D g2) {
        this.g2 = g2;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }



    
}
