package com.ocr.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

import com.ocr.model.TypePoint;



@SuppressWarnings("serial")
public class MagicDraw extends JFrame {
	//container
	private JPanel containerPanel; 
	//MenuBar
	private JMenuBar menuBar = new JMenuBar();
	// Menu
	private JPanel menu = new JPanel();
	//Toolbar
	private JToolBar toolbar = new JToolBar();
	//Menu
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuEdition = new JMenu("Edition");
	private JMenu menuFormePointeur = new JMenu("Forme du pointeur");
	private JMenu menuCouleurPointeur = new JMenu("Couleur du pointeur");
	private JMenu menuTaillePointeur = new JMenu("Taille du pointeur");
	//ItemMenu
	private JMenuItem menuItemEffacer = new JMenuItem("Effacer");
	private JMenuItem menuItemQuitter = new JMenuItem("Quitter");
	private JMenuItem menuItemRond = new JMenuItem("Rond");
	private JMenuItem menuItemCarre = new JMenuItem("Carré");
	private JMenuItem menuItemRouge = new JMenuItem("Rouge");
	private JMenuItem menuItemVert = new JMenuItem("Vert");
	private JMenuItem menuItemBleu = new JMenuItem("Bleu");
	private JMenuItem menuItemTaille5 = new JMenuItem("5px");
	private JMenuItem menuItemTaille10 = new JMenuItem("10px");
	private JMenuItem menuItemTaille15 = new JMenuItem("15px");
	private JMenuItem menuItemTaille20 = new JMenuItem("20px");

	//Background
	private static Color customColor = new Color(239,245,255);
	//Toolbar button 
	private JButton squareDrawButton = new JButton(new ImageIcon("img/square.png"));
	private JButton circleDrawButton = new JButton(new ImageIcon("img/circle.png"));
	
	private JButton squareBlackButton = new JButton(new ImageIcon("img/square_black.jpg"));
	private JButton squareRedButton = new JButton(new ImageIcon("img/square_red.jpg"));
	private JButton squareBlueButton = new JButton(new ImageIcon("img/square_blue.jpg"));
	private JButton squareGreenButton = new JButton(new ImageIcon("img/square_green.jpg"));
	
	//Drawer
	private Drawer drawer;
	
	public MagicDraw() {
		this.setTitle("MyMagicDraw");
		this.setSize(960, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		containerPanel = new JPanel();
		containerPanel.setBackground(customColor);
		containerPanel.setLayout(new BorderLayout());
		menu.setLayout(new BorderLayout());
		
		//Initialisation des menus
		menuItemEffacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuItemEffacer.addActionListener(new ResetItemListener());
		menuFichier.add(menuItemEffacer);
		menuFichier.addSeparator();
		menuFichier.add(menuItemQuitter);
		menuItemQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		menuItemQuitter.addActionListener(new CloseItemListener());
		menuItemRond.addActionListener(new TypeCursorItemListener());
		menuItemCarre.addActionListener(new TypeCursorItemListener());
		menuFormePointeur.add(menuItemRond);
		menuFormePointeur.add(menuItemCarre);
		menuItemRouge.addActionListener(new ColorItemListener());
		menuCouleurPointeur.add(menuItemRouge);	
		menuCouleurPointeur.add(menuItemVert);
		menuItemVert.addActionListener(new ColorItemListener());
		menuCouleurPointeur.add(menuItemBleu);	
		menuItemBleu.addActionListener(new ColorItemListener());
		menuEdition.add(menuFormePointeur);
		menuEdition.addSeparator();
		menuEdition.add(menuCouleurPointeur);
		menuEdition.addSeparator();
		menuTaillePointeur.add(menuItemTaille5);
		menuItemTaille5.addActionListener(new SizeItemListener());
		menuTaillePointeur.add(menuItemTaille10);
		menuItemTaille10.addActionListener(new SizeItemListener());
		menuTaillePointeur.add(menuItemTaille15);
		menuItemTaille15.addActionListener(new SizeItemListener());
		menuTaillePointeur.add(menuItemTaille20);
		menuItemTaille20.addActionListener(new SizeItemListener());
		menuEdition.add(menuTaillePointeur);
		menuBar.add(menuFichier);
		menuBar.add(menuEdition);
		Border borderGray = BorderFactory.createLineBorder(new Color(222,228,237));
		menuBar.setBorder(borderGray);
		
		toolbar.add(squareDrawButton);
		squareDrawButton.addActionListener(new TypeCursorItemListener());
		toolbar.add(circleDrawButton);
		circleDrawButton.addActionListener(new TypeCursorItemListener());
		toolbar.addSeparator();
		
		toolbar.add(squareBlackButton);
		squareBlackButton.addActionListener(new ColorItemListener());
		toolbar.add(squareRedButton);
		squareRedButton.addActionListener(new ColorItemListener());
		toolbar.add(squareBlueButton);
		squareBlueButton.addActionListener(new ColorItemListener());
		toolbar.add(squareGreenButton);
		squareGreenButton.addActionListener(new ColorItemListener());
		menu.add(menuBar, BorderLayout.NORTH);
		menu.add(toolbar, BorderLayout.CENTER);
		
		drawer = new Drawer();
		
		containerPanel.add(menu, BorderLayout.NORTH);
		containerPanel.add(drawer, BorderLayout.CENTER);
		this.setContentPane(containerPanel);
	}
	
	public void run() {
		this.setVisible(true);
	} 
	
	class CloseItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
	class ResetItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			drawer.clear();
		}	
	} 
	
	class ColorItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if((e.getSource() == menuItemRouge) || (e.getSource() == squareRedButton)) {
				drawer.setPointerColor(Color.RED);
			} else if((e.getSource() == menuItemVert) || (e.getSource() == squareGreenButton)) {
				drawer.setPointerColor(Color.GREEN);
			} else if((e.getSource() == menuItemBleu) || (e.getSource() == squareBlueButton)) {
				drawer.setPointerColor(Color.BLUE);
			} else if((e.getSource() == squareBlackButton)) {
				drawer.setPointerColor(Color.BLACK);
			}	
		}
	}
	
	class TypeCursorItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if((e.getSource() == menuItemRond) || (e.getSource() == circleDrawButton)) {
				drawer.setPointerType(TypePoint.CIRCLE);
			} else if ((e.getSource() == menuItemCarre ) || (e.getSource() == squareDrawButton)) {
				drawer.setPointerType(TypePoint.SQUARE);
			}
		}
	}
	
	class SizeItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == menuItemTaille5) {
				drawer.setPointerSize(5);
			} else if(e.getSource() == menuItemTaille10) {
				drawer.setPointerSize(10);
			} else if(e.getSource() == menuItemTaille15) {
				drawer.setPointerSize(15);
			}  else if(e.getSource() == menuItemTaille20) {
				drawer.setPointerSize(20);
			} 
		}
		
	}
}

