package com.ocr.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.ocr.model.*;

/**
 * Component for drawing
 * @author Ngando
 * */
@SuppressWarnings("serial")
public class Drawer extends JComponent {
	  
	private Color pointerColor = Color.BLACK;
	private TypePoint pointerType = TypePoint.CIRCLE;
	private boolean clear = true;
	private int pointerSize = 15;
	private ArrayList<Point> points = new ArrayList<Point>();  
	  
	  
	public Drawer() {
	    addMouseListener(new MouseAdapter() {
	      public void mousePressed(MouseEvent e) {
	    	  points.add(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
	          repaint();
	      }
	    });
	 
	    addMouseMotionListener(new MouseMotionAdapter() {
	      public void mouseDragged(MouseEvent e) {
	    	  points.add(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
	          repaint(); 
	      }
	    });
	}
	
	protected void paintComponent(Graphics g) {
	  g.setColor(Color.WHITE);
	  g.fillRect(0, 0, this.getWidth(), this.getHeight());
	  if(this.clear) {
		  clear = false;
	  }
	  for(Point p : this.points) {
		  g.setColor(p.getColor());
		  if(p.getType().equals(TypePoint.CIRCLE)) {
			  g.fillOval(p.getPosX(), p.getPosY(), p.getSize(), p.getSize());
		  } else {
			  g.fillRect(p.getPosX(), p.getPosY(), p.getSize(), p.getSize());
		  }
	  }
	}
	 
	public void clear() {
		this.clear = true;
	    this.points = new ArrayList<Point>();
	    repaint();
	}
	 
	public void setPointerColor(Color color) {
		this.pointerColor = color;
	}
	  
	public void setPointerType(TypePoint pointerType) {
		this.pointerType = pointerType;
	}
	 
	public void setPointerSize(int size) {
		this.pointerSize = size;
	}
}
