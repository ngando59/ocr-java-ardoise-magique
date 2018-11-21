package com.ocr.model;

import java.awt.Color;

public class Point {
	
	private Color color = Color.BLACK;
	private int size = 10;
	private int posX = -10;
	private int posY = -10;
	private int oldX = 0;
	private int oldY = 0;
	private TypePoint type = TypePoint.CIRCLE;

	public Point(){}

	public Point(int x, int y, int size, Color color, TypePoint type){
		this.size = size;
		this.posX = x;
		this.posY = y;
		this.color = color;
		this.type = type;
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

	public TypePoint getType() {
		return type;
	}

	public void setType(TypePoint type) {
		this.type = type;
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
	
}