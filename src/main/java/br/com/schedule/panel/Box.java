package br.com.schedule.panel;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Date;

public class Box extends Rectangle {
	private static int width = 100;
	private static int height = 100;
	private Point point;
	private int dayOfMonth;
	private Date day;
	private boolean diaAtual=false;
	
	public Box(Point point) {
		super((int)point.getX(), (int)point.getY(), width, height);
		this.point = point;
	}



	public Box(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.point = new Point(x, y);
		this.width=width;
		this.height=height;
	}



	public int getDayOfMonth() {
		return dayOfMonth;
	}



	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}



	public Date getDay() {
		return day;
	}



	public void setDay(Date day) {
		this.day = day;
	}



	public boolean isDiaAtual() {
		return diaAtual;
	}



	public void setDiaAtual(boolean diaAtual) {
		this.diaAtual = diaAtual;
	}	

	
}
