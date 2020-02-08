
package Paint_New_Project;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Color;              
import javax.swing.ImageIcon;          
import javax.swing.JButton;            
import javax.swing.JFrame;        
import javax.swing.JMenu;           
import javax.swing.JMenuBar;          
import javax.swing.JMenuItem;          
import javax.swing.JPanel;




public class Vue extends JFrame{
    
    private JMenuBar menuBar;
    private JMenu fichier,edition,affichage,aide
                    ,selection,coller
                    , rotation,zoom;
    private JMenuItem nvImage,ouvImage,enre,enreS,imprimer,misEnPage,fermerImage,quitter,
                        detectionContour,selectTout,selectParCouleur,selectRectongulaire,selectMainElv,effacerContour,copier,couper,coller_,collerCmNvImg,dupliqueImg,annuler,histAnnul
                        ,ajusterImg,pleinEcran,tailleImpression,tailleImage,rotationDroit,rotationGauche,zoomAvant,zoomArrière,préférence
                        ,aide_,aideContext,collerCommeNvImg;
    private ImageIcon iconNouveau,iconOuvrire,iconSave,iconSaveas,iconClose,iconPrint,iconMep,iconcloseImage,iconselectButton,iconReturn,iconCollerChooser,
                      iconPencil,iconBrush,iconRubber,iconCrée,iconCircle,iconEllipse  ;   
    private JPanel panalsouth,main_panel,radioPanel ;
    private JToolBar accueiltoolbar;
    private JButton returnbButton,pencilButton,brushButton,rubberButton,caréeButton,circleButton,ellipseButton,collorButton;
    private JPanel p=new JPanel();
    private drawArea drawAreaw = new drawArea();
    private String size[]={"2","5","10","15","20","25"};
    private JComboBox choiceSize = new JComboBox(size);
    private JLabel prgtxt= new JLabel("");
    private JLabel sizelabel = new JLabel("Size"),posLabel= new JLabel("");
    private JScrollPane jsp ;
    private JRadioButton ovale ,empty;
    private ButtonGroup bgroup;
    private static JProgressBar prog;
     

  
    
    public Vue(){
        
      
         setTitle("Paint");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         Toolkit tk = Toolkit.getDefaultToolkit();
         setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight());
         setBackground(Color.WHITE);
         setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight());
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("paint.png")));
      
         setLayout(new BorderLayout());
         iconNouveau = new ImageIcon("src/image/new1.png");
         iconOuvrire = new ImageIcon("src/image/open.png");
         iconSave = new ImageIcon("src/image/save1.png");
         iconSaveas = new ImageIcon("src/image/saveas.png");
         iconClose = new ImageIcon("src/image/close.png");
         iconPrint = new ImageIcon("src/image/print.png");
         iconMep = new ImageIcon("src/image/layout.png");
         iconcloseImage = new ImageIcon("src/image/close_image.png");
         iconselectButton = new ImageIcon("src/image/select.png");
         iconReturn = new ImageIcon("src/image/return.png");
         iconPencil = new ImageIcon("src/image/pencil.png");
         iconBrush = new ImageIcon("src/image/brush.png");
         iconRubber = new ImageIcon("src/image/rubber.png");
         iconCrée = new ImageIcon("src/image/carée.png");
         iconCircle = new ImageIcon("src/image/circle.png");
         iconEllipse = new ImageIcon("src/image/ellipse.png");
         iconCollerChooser = new ImageIcon("src/image/colorChooser.png");
         
         
         
         // Bar menue  ***************************************************************************************

         
         menuBar = new JMenuBar();

         //*********************************************************
         fichier = new JMenu("Fichier");
          fichier.setMnemonic(KeyEvent.VK_F);
         nvImage = new JMenuItem("Nouveau");nvImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK,true));
        nvImage.setIcon(iconNouveau);
        ouvImage = new JMenuItem("Ouvrire..."); ouvImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK,true));
        ouvImage.setIcon(iconOuvrire);

        enre = new JMenuItem("Enregister..."); enre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK,true));
        enre.setIcon(iconSave);
        enreS = new JMenuItem("Enregistrer Sous...");
        enreS.setIcon(iconSaveas);
        imprimer = new JMenuItem("Imprimer...");
        imprimer.setIcon(iconPrint);
        misEnPage = new JMenuItem("Mise en Page");
        misEnPage.setIcon(iconMep);
       
        fermerImage = new JMenuItem("Fermer Image");
        fermerImage.setEnabled(false);
        fermerImage.setIcon(iconcloseImage);
        quitter = new JMenuItem("Quiter");
        quitter.setIcon(iconClose);

         fichier.add(nvImage);
         fichier.add(ouvImage);
         fichier.add(enre);
         fichier.add(enreS);
         fichier.addSeparator();
         fichier.add(imprimer);
         fichier.add(misEnPage);
         fichier.addSeparator();
         fichier.add(fermerImage);
         fichier.add(quitter);
         //****************************************************************
         edition = new JMenu("Edition");
         
         selection = new JMenu("Sélection");
         detectionContour = new JMenuItem("Détection Contour");
         selectTout = new JMenuItem("Selectionner Tout");
         selectParCouleur = new JMenuItem("Selectionner par Couleur");
         selectRectongulaire = new JMenuItem("Selectionner Rectongulaire");
         selectMainElv = new JMenuItem("Selectionner à main levée");
         effacerContour = new JMenuItem("Effacer Countour Image");
         copier = new JMenuItem("Copier");
         couper = new JMenuItem("Couper");
         coller = new JMenu("Coller");
         coller_ = new JMenuItem("Coller");
         collerCmNvImg = new JMenuItem("Coller comme Nouvelle Image");
         dupliqueImg = new JMenuItem("Dupliquer Image");
         annuler = new JMenuItem("Annuler");
         histAnnul = new JMenuItem("Historique d'annulation");
         
         edition.add(selection);
         selection.add(detectionContour);
         selection.add(selectTout);
         selection.add(selectParCouleur);
         selection.add(selectRectongulaire);
         selection.add(selectMainElv);
         edition.add(effacerContour);
         edition.addSeparator();
         edition.add(copier);
         edition.add(couper);
         edition.add(coller);
         edition.addSeparator();
         edition.add(dupliqueImg);
         edition.addSeparator();
         
         coller.add(coller_);
         coller.add(collerCmNvImg);
         edition.add(annuler);
         edition.add(histAnnul);
         //*************************************************
         affichage = new JMenu("Affichage");
         
         ajusterImg = new JMenuItem("Ajuster l’image à la fenêtre");
         pleinEcran = new JMenuItem("Plein d'ecran");
         tailleImpression = new JMenuItem("Taille de l’impression");
         tailleImage = new JMenuItem("Taille Image");
         rotation = new JMenu("Rotation");
         rotationDroit = new JMenuItem("Rotation Droit");
         rotationGauche = new JMenuItem("Rotation Gauche");
         zoom= new JMenu("Zoom");
         zoomAvant = new JMenuItem("Zoom Avant");
         zoomArrière = new JMenuItem("Zoom Arrière");
         préférence = new JMenuItem("Préférence");
         
         affichage.add(ajusterImg);
         affichage.add(pleinEcran);
         affichage.add(tailleImpression);
         affichage.add(tailleImage);
         affichage.addSeparator();
         affichage.add(rotation);
         rotation.add(rotationDroit);
         rotation.add(rotationGauche);
         affichage.addSeparator();
         affichage.add(zoom);
         zoom.add(zoomAvant);
         zoom.add(zoomArrière);
         affichage.add(préférence);
         //***************************************
         aide = new JMenu("Aide");
         aide_ = new JMenuItem("Aide");
         aideContext = new JMenuItem("Aide Contextuelle");
         aide.add(aide_);
         aide.add(aideContext);
         //****************************************
         
         menuBar.add(fichier);
         menuBar.add(edition);
         menuBar.add(affichage);
         menuBar.add(aide);
        setJMenuBar( menuBar);
         
         //*****************************************************
         
        //Acceuile Panal 
        accueiltoolbar = new JToolBar();
        accueiltoolbar.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(2, 2, 2, 2);

        //*********************
        returnbButton = new JButton(); 
        returnbButton.setEnabled(false);
        returnbButton.setPreferredSize(new Dimension(iconReturn.getIconWidth()+10,iconReturn.getIconHeight()+10));
        returnbButton.setIcon(iconReturn);
        JLabel l1 = new JLabel("Return");
        gc.gridx = 0;
        gc.gridy = 0;
        accueiltoolbar.add(returnbButton,gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        accueiltoolbar.add(l1,gc);
        //****************************************
        accueiltoolbar.addSeparator();

        
           //******************************************
        pencilButton = new JButton();
        pencilButton.setIcon(iconPencil);
        pencilButton.setPreferredSize(new Dimension(iconPencil.getIconWidth()+10,iconPencil.getIconHeight()+10));
        gc.gridx = 2;
        gc.gridy = 0;
        accueiltoolbar.add(pencilButton,gc); 
        //*****************************************
        brushButton = new JButton();
        brushButton.setIcon(iconBrush);
        brushButton.setPreferredSize(new Dimension(iconBrush.getIconWidth()+10,iconBrush.getIconHeight()+10));
        gc.gridx = 3;
        gc.gridy = 0;
        accueiltoolbar.add(brushButton,gc);
        //*****************************************
        rubberButton = new JButton();
        rubberButton.setIcon(iconRubber);
        rubberButton.setPreferredSize(new Dimension(iconRubber.getIconWidth()+10,iconRubber.getIconHeight()+10));
        gc.gridx = 4;
        gc.gridy = 0;
        accueiltoolbar.add(rubberButton,gc);
        //******************************************
          accueiltoolbar.addSeparator();

        //******************************************
        
        gc.gridx = 5;
        gc.gridy = 0;
        choiceSize.setSelectedIndex(3);
        accueiltoolbar.add(choiceSize,gc);

        gc.gridx = 5;
        gc.gridy = 1;
        accueiltoolbar.add(sizelabel,gc);        
        
        //*********************************************
          accueiltoolbar.addSeparator();
        
        //*****************************************
        caréeButton = new JButton();
        caréeButton.setBackground(Color.WHITE);
        caréeButton.setIcon(iconCrée);
        caréeButton.setPreferredSize(new Dimension(iconCrée.getIconWidth()+10,iconCrée.getIconHeight()+10));
        gc.gridx = 6;
        gc.gridy = 0;
        accueiltoolbar.add(caréeButton,gc);
        //*****************************************
      /*  circleButton = new JButton();
        circleButton.setBackground(Color.WHITE);
        circleButton.setIcon(iconCircle);
        circleButton.setPreferredSize(new Dimension(iconCircle.getIconWidth()+10,iconCircle.getIconHeight()+10));
        gc.gridx = 7;
        gc.gridy = 0;
        accueiltoolbar.add(circleButton,gc);*/
        //***************************************
        ellipseButton = new JButton();
        ellipseButton.setBackground(Color.WHITE);
        ellipseButton.setIcon(iconEllipse);
        ellipseButton.setPreferredSize(new Dimension(iconEllipse.getIconWidth()+10,iconEllipse.getIconHeight()+10));
        gc.gridx = 7;
        gc.gridy = 0;
        accueiltoolbar.add(ellipseButton,gc);
        //**********************************
        accueiltoolbar.addSeparator();
        //***********************************
        collorButton  = new JButton();
        collorButton.setIcon(iconCollerChooser);
        collorButton.setPreferredSize(new Dimension(iconCollerChooser.getIconWidth()+10,iconCollerChooser.getIconHeight()+10));
        gc.gridx = 8;
        gc.gridy = 0;
        accueiltoolbar.add(collorButton,gc);
     //   collorButton.addActionListener(this);
     //**************************** 
       ovale   = new JRadioButton("Fill");
       empty    = new JRadioButton("Empty");
       bgroup = new ButtonGroup();
      bgroup.add(ovale);
      bgroup.add(empty);
      radioPanel = new JPanel();
      radioPanel.setLayout(new GridLayout(2, 1));
      radioPanel.add(ovale);
      radioPanel.add(empty);
      gc.gridx = 9;
      gc.gridy = 0;
      
     accueiltoolbar.add(radioPanel,gc);
     
       add(accueiltoolbar,BorderLayout.NORTH);
       accueiltoolbar.setBackground(new Color(192, 192, 192));
       
      main_panel=new JPanel(new BorderLayout());
      drawAreaw.setDoubleBuffered(false);
       main_panel.add(drawAreaw,BorderLayout.CENTER);
       jsp= new JScrollPane(main_panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       add(jsp,BorderLayout.CENTER);
       
       panalsouth = new JPanel();
       panalsouth.setLayout(new FlowLayout(FlowLayout.LEFT));
       prog = new JProgressBar();
       
       prog.setVisible(true);
       panalsouth.add(posLabel);
       panalsouth.add(prgtxt);
       // panalsouth.add(prog);
       add(panalsouth,BorderLayout.SOUTH);

       
       
       setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public JComboBox getChoiceSize() {
        return choiceSize;
    }

    public JMenuItem getNvImage() {
        return nvImage;
    }


    public JMenuItem getOuvImage() {
        return ouvImage;
    }

    public JMenuItem getEnre() {
        return enre;
    }

    public JMenuItem getEnreS() {
        return enreS;
    }

    public JMenuItem getImprimer() {
        return imprimer;
    }

    public JMenuItem getMisEnPage() {
        return misEnPage;
    }

    public JMenuItem getFermerImage() {
        return fermerImage;
    }

    public JMenuItem getQuitter() {
        return quitter;
    }

    public JMenuItem getDetectionContour() {
        return detectionContour;
    }

    public JMenuItem getSelectTout() {
        return selectTout;
    }

    public JMenuItem getSelectParCouleur() {
        return selectParCouleur;
    }

    public JMenuItem getSelectRectongulaire() {
        return selectRectongulaire;
    }


    public JMenuItem getSelectMainElv() {
        return selectMainElv;
    }

    public JMenuItem getEffacerContour() {
        return effacerContour;
    }

    public JMenuItem getCopier() {
        return copier;
    }

    public JMenuItem getCouper() {
        return couper;
    }

    public JMenuItem getColler_() {
        return coller_;
    }

    public JMenuItem getCollerCmNvImg() {
        return collerCmNvImg;
    }

    public JMenuItem getDupliqueImg() {
        return dupliqueImg;
    }

    public JMenuItem getAnnuler() {
        return annuler;
    }

    public JMenuItem getHistAnnul() {
        return histAnnul;
    }

    public JMenuItem getAjusterImg() {
        return ajusterImg;
    }

    public JMenuItem getPleinEcran() {
        return pleinEcran;
    }

    public JMenuItem getTailleImpression() {
        return tailleImpression;
    }

    public JMenuItem getTailleImage() {
        return tailleImage;
    }

    public JMenuItem getRotationDroit() {
        return rotationDroit;
    }

    public JMenuItem getRotationGauche() {
        return rotationGauche;
    }

    public JMenuItem getZoomAvant() {
        return zoomAvant;
    }

    public JMenuItem getZoomArrière() {
        return zoomArrière;
    }

    public JMenuItem getPréférence() {
        return préférence;
    }

    public JMenuItem getAide_() {
        return aide_;
    }

    public JMenuItem getAideContext() {
        return aideContext;
    }

    public JPanel getPanalsouth() {
        return panalsouth;
    }

    public JButton getReturnbButton() {
        return returnbButton;
    }
    public JButton getPencilButton() {
        return pencilButton;
    }

 
    public JButton getBrushButton() {
        return brushButton;
    }

    public JButton getRubberButton() {
        return rubberButton;
    }


    public JButton getCaréeButton() {
        return caréeButton;
    }

    public JButton getCircleButton() {
        return circleButton;
    }

    public JButton getEllipseButton() {
        return ellipseButton;
    }

    public JButton getCollorButton() {
        return collorButton;
    }

public JPanel getP() {
        return p;
    }

      public drawArea getDrawAreaw() {
        return drawAreaw;
    }

    public void setDrawAreaw(drawArea drawAreaw) {
        this.drawAreaw = drawAreaw;
    }
    
    
   /*  public void actionPerformed(ActionEvent e){
         if (e.getSource()== collorButton)
         {
             color = JColorChooser.showDialog(this, "Select Color", color);
             if (color != null){
                 accueiltoolbar.setBackground(color);
             }
         }
     }*/

    public JLabel getPosLabel() {
        return posLabel;
    }

    public JRadioButton getOvale() {
        return ovale;
    }

    public JRadioButton getEmpty() {
        return empty;
    }

    public JProgressBar getProg() {
        return prog;
    }

    public void setProg(JProgressBar prog) {
        this.prog = prog;
    }

    public JLabel getPrgtxt() {
        return prgtxt;
    }

    public void setPrgtxt(JLabel prgtxt) {
        this.prgtxt = prgtxt;
    }
    

    
}
