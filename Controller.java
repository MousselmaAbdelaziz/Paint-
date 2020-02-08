
package Paint_New_Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javafx.scene.Cursor;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.undo.UndoManager;



public class Controller extends JComponent implements ActionListener {
     Model model;
     Vue vue;
   
    
    public Controller(Model m , Vue v){
        model=m;
        vue=v;
    }
    
    public void initConttroller(){
      
        
      pencile();
      model.setSize(Integer.parseInt(vue.getChoiceSize().getSelectedItem().toString()) );
      vue.getPencilButton().addActionListener(this);
      vue.getCollorButton().addActionListener(this);
      vue.getEnre().addActionListener(this);
      vue.getEnreS().addActionListener(this);
      vue.getOuvImage().addActionListener(this);
      vue.getNvImage().addActionListener(this);
      vue.getQuitter().addActionListener(this);
      vue.getFermerImage().addActionListener(this);
      vue.getRubberButton().addActionListener(this);
      vue.getCaréeButton().addActionListener(this);
      vue.getChoiceSize().addActionListener(this);
      vue.getPleinEcran().addActionListener(this);
      vue.getAide_().addActionListener(this);
      vue.getRotationDroit().addActionListener(this);
      vue.getBrushButton().addActionListener(this);
      vue.getEllipseButton().addActionListener(this);
      vue.getReturnbButton().addActionListener(this);
      vue.getPleinEcran().addActionListener(this);
      vue.getOvale().addActionListener(this);
      vue.getEmpty().addActionListener(this);
      vue.getImprimer().addActionListener(this);
      vue.getAjusterImg().addActionListener(this);
      vue.getRotationGauche().addActionListener(this);
      vue.getDrawAreaw().addMouseMotionListener(new MouseAdapter() { // pour aficher le positionnement de cursuer 
          public void  mouseMoved(MouseEvent e){
              model.setPosX(e.getX());
              model.setPosY(e.getY());
             vue.getPosLabel().setText(e.getX()+", "+e.getY()+"px" );
             
          }
      }); 
   vue.getDrawAreaw().addMouseMotionListener(new MouseAdapter() {// pour aficher le positionnement de cursuer 
          public void  mouseDragged(MouseEvent e){
              model.setPosX(e.getX());
              model.setPosY(e.getY());
             vue.getPosLabel().setText(e.getX()+", "+e.getY()+"px" );
             
          }
      
      });
    
    vue.getDrawAreaw().addMouseListener(new MouseAdapter() { // pour effacer les positionement du cuseur si il exite Draw area 
        public void mouseExited(MouseEvent e){
          vue.getPosLabel().setText("");
         
        }
    
    });
    
    }  
    //************************************************************************************************************************ 
      public void colorselection(Color color) { // pour selectionner les couleur 
          vue.getDrawAreaw().getG2().setPaint(color);
      }
      
 
         //************************************************************************************************************************    

    public void actionPerformed(ActionEvent e) { // pour selectionner les couleur 
      
     if (e.getSource() == vue.getCollorButton()){
             Color bgColor = JColorChooser.showDialog(vue, "Choose Color", vue.getBackground());
         if (bgColor != null){
             model.setColor(bgColor);
        } 
        }  
        //************************************************************************************************************************
        if (e.getSource() == vue.getOuvImage()){ //pour charger une image
         model.open();
         vue.getFermerImage().setEnabled(true);
         vue.getDrawAreaw().setImage(model.getScalled());
        } 
       //************************************************************************************************************************

        if (e.getSource() == vue.getEnre()){ // pour enregistrer 

            model.save(vue.getDrawAreaw().getImage());
   
              try {
                        for (int i=0 ; i<=100 ; i++){
                         vue.getDrawAreaw().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                         Thread.sleep(20);
                        }
                        
                     
                 } catch (InterruptedException ex) {
                 }
        }
        //************************************************************************************************************************
        if (e.getSource() == vue.getEnreS()){ //pour enregistrer sous 
         model.saveas(vue.getDrawAreaw().getImage());
         try {
                        for (int i=0 ; i<=100 ; i++){
                         vue.getDrawAreaw().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                         Thread.sleep(20);
                        }
                        
                     
                 } catch (InterruptedException ex) {
                 }
        }
        //************************************************************************************************************************
        if (e.getSource() == vue.getNvImage()){ // pour ouvrire une nouvel fenètre paint 
        
           // model.newimage(vue.getDrawAreaw().getImage());
           // vue.getDrawAreaw().setImage(null);
           // vue.getDrawAreaw().clear();
          vue.getDrawAreaw().clear();
            
        }
         
        
        //*************************************************************************************************************************
        if(e.getSource()==vue.getOvale()){ model.setChoixForm("fill");}
        if(e.getSource() == vue.getEmpty()){model.setChoixForm("empty");}
        //************************************************************************************************************************
 
        if (e.getSource() == vue.getQuitter()){ // pour fermrer la fenètre 
          model.quitter(vue.getDrawAreaw().getImage());
        }
        //************************************************************************************************************************
        if (e.getSource() == vue.getFermerImage()){ // pour fermer l'image courant et ouvrire une nouvel instatnce pour desinger
           
            model.newimage(vue.getDrawAreaw().getImage());
         if (model.getOpenfile()== null){
            // vue.getDrawAreaw().setImage(null);
             //vue.getDrawAreaw().clear();
         }
        }
        //************************************************************************************************************************    

      if (e.getSource() == vue.getPencilButton() ){ //pour desinger avec le crayon 
            model.setChoix("getPencilButton");
            model.setChoixCursor("getPencilButton");
            if(model.getColor().equals(Color.WHITE)){
               model.setColor(Color.BLACK);} 
           vue.getDrawAreaw().addMouseListener(new MouseAdapter() { // pour récuperer le postitionement de début 
           public void mousePressed(MouseEvent e) {
           if(model.getChoix()== "getPencilButton"){
           model.setOldX(e.getX());
           model.setOldY(e.getY());
            }
            }
            });
           vue.getDrawAreaw().addMouseMotionListener(new MouseMotionAdapter() {
             public void mouseDragged(MouseEvent e) { // pour récuperer le postitionement au fur et à mesure que le curseur move  
            if(model.getChoix()== "getPencilButton"){

            model.setCurrentX(e.getX());
            model.setCurrentY(e.getY());
            if (vue.getDrawAreaw().getG2() != null) {
        	colorselection(model.getColor());
           vue.getDrawAreaw().getG2().drawLine(model.getOldX(), model.getOldY(), model.getCurrentX(), model.getCurrentY());
            vue.repaint();
            
          model.setOldX(model.getCurrentX());
          model.setOldY(model.getCurrentY());}
        }
      }
    });
     
        vue.getDrawAreaw().addMouseMotionListener(new  MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) { // pour changer le curseur 
            if(model.getChoixCursor().equals("getPencilButton"))
            
             vue.getDrawAreaw().setCursor(model.custemCurserPencil());
             }
             });
 
                
        }
      
        
    //************************************************************************************************************************ 
        
        if (e.getSource() == vue.getBrushButton()){ // pour utiliser pinceau
           
            model.setChoix("getBrushButton");
            model.setChoixCursor("getBrushButton");
            if(model.getColor().equals(Color.WHITE)){
               model.setColor(Color.BLACK);} 
            vue.getDrawAreaw().addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
                    if(model.getChoix()== "getBrushButton"){

        model.setOldX(e.getX());
        model.setOldY(e.getY());}
      }
     });
    
         
       vue.getDrawAreaw().addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
       if(model.getChoix()== "getBrushButton"){
          model.setCurrentX(e.getX());
        model.setCurrentY(e.getY());
        if (vue.getDrawAreaw().getG2() != null) {
        	colorselection(model.getColor());
              vue.getDrawAreaw().getG2().fillOval(model.getOldX(), model.getOldY(),model.getSize(),model.getSize());
         vue.repaint();
          model.setOldX(model.getCurrentX());
          model.setOldY(model.getCurrentY());}
        }
        }
        });
       
        vue.getDrawAreaw().addMouseMotionListener(new  MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                 if(model.getChoixCursor().equals("getBrushButton"))
                vue.getDrawAreaw().setCursor(model.custemCurserBrush());
            }
        });

        }
        //************************************************************************************************************************ 
        if (e.getSource() == vue.getRubberButton()){ // pour utiliser la gomme
            model.setChoix("getRubberButton");
            model.setChoixCursor("getRubberButton");
            model.setColor(Color.WHITE);
             vue.getDrawAreaw().addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
       if(model.getChoix()== "getRubberButton"){
          model.setOldX(e.getX());
        model.setOldY(e.getY());}
      }
    });
     vue.getDrawAreaw().addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        if(model.getChoix()== "getRubberButton"){
         model.setCurrentX(e.getX());
        model.setCurrentY(e.getY());
        if (vue.getDrawAreaw().getG2() != null) {
        	colorselection(model.getColor());
          vue.getDrawAreaw().getG2().fillOval(model.getOldX(), model.getOldY(),model.getSize(),model.getSize());
          vue.repaint();
          model.setOldX(model.getCurrentX());
          model.setOldY(model.getCurrentY());
        }
      }}
    });
    vue.getDrawAreaw().addMouseMotionListener(new  MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
             if(model.getChoixCursor().equals("getRubberButton"))
                vue.getDrawAreaw().setCursor(model.custemCurserRubber());
            }
        });
        }
        
      //************************************************************************************************************************  
        if (e.getSource()== vue.getCaréeButton()){ // pour desinger un carée 
               if(model.getColor().equals(Color.WHITE)){
               model.setColor(Color.BLACK);}
                model.setChoix("getCaréeButton");
                vue.getDrawAreaw().addMouseListener(new MouseAdapter() {
                 @Override
                public void mousePressed(MouseEvent e) {
                   if(model.getChoix()== "getCaréeButton"){
                    model.setOldX(e.getX());
                    model.setOldY(e.getY()); }   }
            });
           vue.getDrawAreaw().addMouseListener(new MouseAdapter() {
              @Override
            public void mouseReleased(MouseEvent e) {
           if(model.getChoix()== "getCaréeButton"){
            model.setCurrentX(e.getX());
            model.setCurrentY(e.getY());    
            if (model.getOldX() > model.getCurrentX()){
                        int z= model.getOldX();
                        model.setOldX(model.getCurrentX());
                        model.setCurrentX(z);
                    }
                    if (model.getOldY() > model.getCurrentY()){
                        int z= model.getOldY();
                        model.setOldY(model.getCurrentY());
                        model.setCurrentY(z);
                    }
               colorselection(model.getColor());    
               if(model.getChoixForm().equals("fill")){
         vue.getDrawAreaw().getG2().fillRect(model.getOldX(), model.getOldY(), model.getCurrentX()-model.getOldX(), model.getCurrentY()-model.getOldY());
               }
               else {
         vue.getDrawAreaw().getG2().drawRect(model.getOldX(), model.getOldY(), model.getCurrentX()-model.getOldX(), model.getCurrentY()-model.getOldY());
               }
             vue.repaint();
            }}
                    });
            vue.getDrawAreaw().addMouseMotionListener(new  MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
               // Cursor crs = new Cursor(Cursor.);
                vue.getDrawAreaw().setCursor(model.defaultCursor());
            }
        });
        }          
        //************************************************************************************************************************
        if (e.getSource() == vue.getEllipseButton()){ // pour designer un cercle
        if(model.getColor().equals(Color.WHITE)){
               model.setColor(Color.BLACK);}         
            model.setChoixCursor("");
            model.setChoix("getEllipseButton");
             vue.getDrawAreaw().addMouseListener(new MouseAdapter() {
                 @Override
             public void mousePressed(MouseEvent e) {
             if(model.getChoix()== "getEllipseButton"){
                    model.setOldX(e.getX());
                    model.setOldY(e.getY()); }   }
            
            });
      
             vue.getDrawAreaw().addMouseListener(new MouseAdapter() {
                  @Override
             public void mouseReleased(MouseEvent e) {
                  if(model.getChoix()== "getEllipseButton"){
                     model.setCurrentX(e.getX());
                     model.setCurrentY(e.getY());    
                  if (model.getOldX() > model.getCurrentX()){
                        int z= model.getOldX();
                        model.setOldX(model.getCurrentX());
                        model.setCurrentX(z);
                    }
                    if (model.getOldY() > model.getCurrentY()){
                        int z= model.getOldY();
                        model.setOldY(model.getCurrentY());
                        model.setCurrentY(z);
                    }
                    if (model.getOldX() > model.getCurrentX() && model.getOldY() > model.getCurrentY()){
                        int z= model.getOldX();
                        int w= model.getOldY();
                        model.setOldX(model.getCurrentX());
                        model.setOldY(model.getCurrentY());
                        model.setCurrentX(z);
                        model.setCurrentY(w);
                    }
                    colorselection(model.getColor());
                     if(model.getChoixForm().equals("fill")){
                    vue.getDrawAreaw().getG2().fillOval(model.getOldX(), model.getOldY(), model.getCurrentX()-model.getOldX(), model.getCurrentY()-model.getOldY());
                   }
                   else {
                  vue.getDrawAreaw().getG2().drawOval(model.getOldX(), model.getOldY(), model.getCurrentX()-model.getOldX(), model.getCurrentY()-model.getOldY());
                  }
                   
                    
                  vue.repaint();
             }
             }
             });
             
                vue.getDrawAreaw().addMouseMotionListener(new  MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
               // Cursor crs = new Cursor(Cursor.);
                vue.getDrawAreaw().setCursor(model.defaultCursor());
            }
        });
           
            }
        
            //************************************************************************************************************************    

             if(e.getSource() == vue.getChoiceSize()){ // pour changer la taille de la ligne ( cette fonction march avec le pinceau et la gomme )
            model.setSize(Integer.parseInt(vue.getChoiceSize().getSelectedItem().toString()) );
                }
          //************************************************************************************************************************    

          if (e.getSource() == vue.getPleinEcran()){ 
              System.out.println("plein d'écran ");
             /*  //Toolkit tk = Toolkit.getDefaultToolkit();
               //vue.getDrawAreaw().setSize(1500,1500);
            BufferedImage before = vue.getDrawAreaw().getImage();
        int w = before.getWidth();
        int h = before.getHeight();
        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(2.0, 2.0);
        AffineTransformOp scaleOp =  new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(before, after);
        vue.getDrawAreaw().setImage(after);
        vue.repaint();*/
          }  
          //************************************************************************************************************************
          if (e.getSource() == vue.getAide_()){
              JFrame f = new JFrame();
              f.setTitle("Aide");
              f.setBounds(150, 150, 350, 100);
              JLabel l = new JLabel("This is A documentation for help... ");
              f.add(l,BorderLayout.CENTER);
              f.setVisible(true);
              
          }
              //************************************************************************************************************************    

          if (e.getSource() == vue.getRotationDroit()){
              System.out.println("RT pressed");
              /*      double sin = Math.abs(Math.sin(Math.toRadians(90))),
			cos = Math.abs(Math.cos(Math.toRadians(90)));
                    BufferedImage img = vue.getDrawAreaw().getImage();
                    int h = img.getHeight(null);
                    int w = img.getWidth(null);
                    int neww = (int) Math.floor(w*cos + h*sin),
			newh = (int) Math.floor(h*cos + w*sin);
                    BufferedImage bimg = new BufferedImage(neww, newh, BufferedImage.TYPE_3BYTE_BGR);
                    Graphics2D g = bimg.createGraphics();
              
              g.translate((neww-w)/2, (newh-h)/2);
              g.rotate(Math.toRadians(90), w/2, h/2);
              g.drawRenderedImage(img, null);
              g.dispose();
              
              vue.getDrawAreaw().setImage(img);
              vue.repaint();*/
             // paintComponant(vue.getDrawAreaw().getG2());
             // paint(vue.getDrawAreaw().getG2());
             //vue.getDrawAreaw().setImage(model.rotateImageByDegrees(vue.getDrawAreaw().getImage(), 90));
             rotateFix(90);
              
          }
          //*********************************************************************************
          
          if (e.getSource() == vue.getRotationGauche()){
             rotateFix(270);
          }
          
          //*************************************************************************************************************
          
          if (e.getSource() == vue.getReturnbButton()){
             // model.setSavingImage(model.getReturnList().get(5));
            // model.setScalled(model.getReturnList().get(5));
            
              vue.getDrawAreaw().setImage(model.getScalled());
             // vue.getDrawAreaw().setG2(graphicsBackup);
              vue.repaint();
             /* System.out.println("i = "+i);
              if(model.getScalled()==null)System.out.println("scalled null");
              if(model.getSavingImage()==null) System.out.println(" save imae null");
              System.out.println("retunr clicked");
              System.out.println(model.getReturnList().size());
              */
              
          }
          
       //***********************************************************************************************
           if ( e.getSource()==vue.getImprimer() ) // pour imprimer notre image 
	   {
    	        drawArea drawArea = vue.getDrawAreaw();
		model.Imprimer(vue.getDrawAreaw());
			 }
           if(e.getSource() == vue.getAjusterImg()){
               
           }
    
    }
    
    
    public void pencile(){ // cette fonction est pour que le pencile sera activer par défaut 
                    model.setChoix("getPencilButton");
            model.setChoixCursor("getPencilButton");
            if(model.getColor().equals(Color.WHITE)){
               model.setColor(Color.BLACK);} 
         vue.getDrawAreaw().addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
          if(model.getChoix()== "getPencilButton"){
          model.setOldX(e.getX());
        model.setOldY(e.getY());
          }
      }
    });
     vue.getDrawAreaw().addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
            if(model.getChoix()== "getPencilButton"){

        model.setCurrentX(e.getX());
        model.setCurrentY(e.getY());
        if (vue.getDrawAreaw().getG2() != null) {
        	colorselection(model.getColor());
         vue.getDrawAreaw().getG2().drawLine(model.getOldX(), model.getOldY(), model.getCurrentX(), model.getCurrentY());
         vue.repaint();
            
          model.setOldX(model.getCurrentX());
          model.setOldY(model.getCurrentY());}
        }
      }
    });
     
        vue.getDrawAreaw().addMouseMotionListener(new  MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
        if(model.getChoixCursor().equals("getPencilButton"))
            
        vue.getDrawAreaw().setCursor(model.custemCurserPencil());
            }
        });}
     //***************************************************************************************************
              
              public void rotateFix(double angle) {
            double currentAngle = angle;
             
       	    int w = vue.getDrawAreaw().getImage().getWidth(this);    
       	    int h = vue.getDrawAreaw().getImage().getHeight(this);
       	    double rads = Math.toRadians(angle);
               double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
               
       	    int newWidth = (int) Math.floor(w * cos + h * sin);        	    
               int newHeight = (int) Math.floor(h * cos + w * sin);
       	    BufferedImage rotated = new BufferedImage(newWidth, newHeight, vue.getDrawAreaw().getImage().getType());  

            
       	    Graphics2D graphic = rotated.createGraphics();

       	    graphic.rotate(Math.toRadians(angle), newWidth/2, newHeight/2);
       	  

       	    graphic.drawImage(vue.getDrawAreaw().getImage(),newWidth/2-w/2,newHeight/2-h/2, this);
       	   

       	    graphic.dispose();
          	
       	    
       	    //history
       	  //  past();
       	    vue.getDrawAreaw().setImage(rotated) ;
            vue.repaint();

       
     
}
      
}
 


    
