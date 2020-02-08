
package Paint_New_Project;

          
import java.awt.Color;             
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;            
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;      
import java.awt.event.ActionListener;      
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;           
import javax.swing.JButton;             
import javax.swing.JFileChooser;
import javax.swing.JFrame;         
import javax.swing.JLabel;

import javax.swing.filechooser.FileNameExtensionFilter;



public class Model {
      private int currentX, currentY, oldX, oldY,posX=0,posY=0;
      private Color color = Color.BLACK ;
      private File openfile=null;
      private String order="";
      private BufferedImage scalled;
      private BufferedImage savingImage=null;
      private int size;
      private String choix="";
      private String choixCursor="";
      private int saved=0;
      private String choixForm="";
      private  ArrayList<BufferedImage> returnList =new ArrayList<>();

    
    public Model(){
    
    }
    
     public void open(){
         JFileChooser f=new JFileChooser();
         f.setSize(300, 250);
 		int r=f.showOpenDialog(null);
 		FileNameExtensionFilter filter =new FileNameExtensionFilter("images files", "jpg","png");
 		f.setFileFilter(filter);
 		if(r==JFileChooser.APPROVE_OPTION) {
 			 openfile=f.getSelectedFile();
 			
 			
 			try {
 				FileInputStream input =new FileInputStream(openfile);
 				try {
 					BufferedImage image =ImageIO.read(input);
 					scalled=image;
                                         order="drawimage";
 				} catch (IOException e) {
 					e.printStackTrace();
 					
 				}
 			}
 			catch (FileNotFoundException e) {
 				e.printStackTrace();
 			}}
     }
    
    
    //*********************************************************************************
    public void save (BufferedImage saveimage) {
	if(openfile==null) {

		JFileChooser ch =new JFileChooser();
                int r=ch.showSaveDialog(null);
		if(r==JFileChooser.APPROVE_OPTION) {
			try {
			openfile=new File(ch.getSelectedFile().getAbsolutePath());
			try {
          
            ImageIO.write(saveimage,"png",openfile);
			}
			catch (IOException e) {
            System.out.println("error"+e.getMessage());			}}
			catch (Exception e) {
			System.out.println("file error"+e.getMessage());
			}}}
	else {
		
		
		 try {
			ImageIO.write(saveimage,"png",openfile);
		} catch (IOException e) {
			e.printStackTrace();
		}}
           
    
    }

    //*********************************************************************************
    public void saveas(BufferedImage saveimage ) {
	
		JFileChooser ch =new JFileChooser();
                int r=ch.showSaveDialog(null);
		if(r==JFileChooser.APPROVE_OPTION) {
			try {
			File myfile=new File(ch.getSelectedFile().getAbsolutePath());
			try {
            ImageIO.write(saveimage,"png",myfile);
            System.out.println("saved");    
			}
			catch (IOException e) {
            System.out.println("error"+e.getMessage());			}}
			catch (Exception e) {
			System.out.println("file error"+e.getMessage());
			}}	
}
    
    //*********************************************************************************
     public void newimage (BufferedImage saveimage) {
 	
             JFrame f =new JFrame("Save ?");
             f.setSize(350, 100);
             f.setLocationRelativeTo(null);
             f.setResizable(false);
             f.setVisible(true);
             f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             JLabel l = new JLabel("Would You Save Your Work ?");
             JButton b1 = new JButton("Yes");
             JButton b2 = new JButton("No");
             f.setLayout(new FlowLayout(FlowLayout.LEFT));
             f.add(l);f.add(b1);f.add(b2);
             b1.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     JFileChooser ch =new JFileChooser();
                 int r=ch.showSaveDialog(null);
 		if(r==JFileChooser.APPROVE_OPTION) {
 			try {
 			openfile=new File(ch.getSelectedFile().getAbsolutePath());
 			try {
             ImageIO.write(saveimage,"png",openfile);
             saved=1;
 			}
 			catch (IOException ex) {
             System.out.println("error"+ex.getMessage());			}}
 			catch (Exception ex) {
 			System.out.println("file error"+ex.getMessage());
 			}}
                 f.setVisible(false);
                  saved=1;
                 }
             });
             b2.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);
                 }
             });
         
 	
 }
    //*********************************************************************************
    public void quitter(BufferedImage saveimage){
    
            JFrame f =new JFrame("Save ?");
            f.setSize(350, 100);
            f.setLocationRelativeTo(null);
            f.setResizable(false);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel l = new JLabel("Would You Save Your Work ?");
            JButton b1 = new JButton("Yes");
            JButton b2 = new JButton("No");
            f.setLayout(new FlowLayout(FlowLayout.LEFT));
            f.add(l);f.add(b1);f.add(b2);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser ch =new JFileChooser();
                int r=ch.showSaveDialog(null);
		if(r==JFileChooser.APPROVE_OPTION) {
			try {
			File myfile=new File(ch.getSelectedFile().getAbsolutePath());
			try {
            ImageIO.write(saveimage,"png",myfile);
			}
			catch (IOException ex) {
            System.out.println("error"+ex.getMessage());			}}
			catch (Exception ex) {
			System.out.println("file error"+ex.getMessage());
			}}
                f.setVisible(false);
                System.exit(0);
                }
            });
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  System.exit(0);
                }
            });
        
    
    }
   //********************************************************************************* 
    public Graphics2D rotatImage (double degree , ImageObserver  o , BufferedImage img){
        ImageIcon icon = new ImageIcon(img);
        BufferedImage img2 = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) img2.getGraphics();
        g2.rotate(Math.toRadians(degree), icon.getIconWidth() / 2, icon.getIconHeight() /2);
        g2.drawImage(img, 0, 0,o);
        return g2;
    
    
    }
    //*********************************************************************************
    public void  Imprimer(drawArea drawArea) {
    	 PrinterJob job = PrinterJob.getPrinterJob();
         job.setJobName("Print Data");
         
         job.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
             pf.setOrientation(PageFormat.LANDSCAPE);
             if(pageNum>0){
                 return Printable.NO_SUCH_PAGE;
             }
             
             Graphics2D g2 = (Graphics2D)pg;
             g2.translate(pf.getImageableX(), pf.getImageableY());
             g2.scale(0.24,0.24);
             
             drawArea.paint(g2);
//

            return Printable.PAGE_EXISTS;
             });
      
          boolean ok = job.printDialog();
          if(ok){
             try{
         
          job.print();
              }
          catch (PrinterException ex){}
          }
             }
  
    
    //********************************************************************
        public Cursor custemCurserPencil(){
            Toolkit t1 = Toolkit.getDefaultToolkit();
            Image img   = t1.getImage("src/image/pencil1.png");
            Point p = new Point (0,0);
            Cursor c = t1.createCustomCursor(img, p, "src/image/pencil1.png");
           return c;
        }
        //******************************************************************
         public Cursor custemCurserBrush(){
            
            Toolkit t1 = Toolkit.getDefaultToolkit();
            Image img   = t1.getImage("src/image/brush1.png");
            Point p = new Point (0,0);
            Cursor c = t1.createCustomCursor(img, p, "src/image/brush1.png");
           return c;
        }
 
    //************************************************************************************************************************    
         public Cursor custemCurserRubber(){
             Cursor c1 = new Cursor(Cursor.DEFAULT_CURSOR);
            Toolkit t1 = Toolkit.getDefaultToolkit();
            Image img   = t1.getImage("src/image/rubber.png");
            Point p = new Point (0,0);
            Cursor c = t1.createCustomCursor(img, p, "src/image/rubber1.png");
           return c;
        }
 
    //************************************************************************************************************************    
         public Cursor defaultCursor(){
             Cursor c = new Cursor(Cursor.DEFAULT_CURSOR);
             return c;
        }
 
      //************************************************************************************************************************ 
public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {

            double rads = Math.toRadians(angle);
            double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
            int w = img.getWidth();
            int h = img.getHeight();
            int newWidth = (int) Math.floor(w * cos + h * sin);
            int newHeight = (int) Math.floor(h * cos + w * sin);

            BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = rotated.createGraphics();
            AffineTransform at = new AffineTransform();
            at.translate((newWidth - w) / 2, (newHeight - h) / 2);

            int x = w / 2;
            int y = h / 2;

            at.rotate(rads, x, y);
            g2d.setTransform(at);
            g2d.drawImage(img, 0, 0, (ImageObserver) this);
            g2d.setColor(Color.RED);
            g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
            g2d.dispose();

            return rotated;
        }
         
         
         
        //********************************************************************************************************************* 
    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    
    public File getOpenfile() {
        return openfile;
    }

    public void setOpenfile(File openfile) {
        this.openfile = openfile;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public BufferedImage getScalled() {
        return scalled;
    }

    public void setScalled(BufferedImage scalled) {
        this.scalled = scalled;
    }
      
      
      
      
    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getOldX() {
        return oldX;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSaved() {
        return saved;
    }

    public void setSaved(int saved) {
        this.saved = saved;
    }

    public String getChoixCursor() {
        return choixCursor;
    }

    public void setChoixCursor(String choixCursor) {
        this.choixCursor = choixCursor;
    }

    public BufferedImage getSavingImage() {
        return savingImage;
    }

    public void setSavingImage(BufferedImage savingImage) {
        this.savingImage = savingImage;
    }

    public ArrayList<BufferedImage> getReturnList() {
        return returnList;
    }

    public void setReturnList(ArrayList<BufferedImage> returnList) {
        this.returnList = returnList;
    }

    public String getChoixForm() {
        return choixForm;
    }

    public void setChoixForm(String choixForm) {
        this.choixForm = choixForm;
    }

    
    

    
  
    
  
}
