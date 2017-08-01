package br.com.schedule.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Date;
import java.util.Queue;


import javax.swing.JPanel;

import br.com.schedule.util.DateUtil;

public class SchedulePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5776232631669338344L;
	private String[] daysOfMonth = { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado" };
	private int boxWidth = 100;
	private int boxHeight = 100;
	private int boxNumDayMonth = (int) ((boxWidth / 2) + ((boxWidth / 2) / 2) + (((boxWidth / 2) / 2) / 2));
	private Box[][] grid = new Box[6][7];
	private int positionX = 0, positionY = 10;
	private Color colorDay=new Color(106,90,205);
	
	/**
	 * Create the panel.
	 */
	public SchedulePanel() {
		
	}

	public SchedulePanel(int boxWidth, int boxHeight) {
		super();
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		grid(g);
		printHeader(g);
		makeCalendar();
		printgrid(g2);
		printDaysOfMonth(g);
		
	}

	private void grid(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		
		// Header with names of the week
		for (int x = 0; x < 7; x++) {
			g.drawRect(positionX, positionY, boxWidth, 20);
			positionX += boxWidth;
		}

		positionX = 0;
		positionY = 30;
		// days of month
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 7; y++) {				
				grid[x][y] = new Box(positionX, positionY, boxWidth, boxHeight);
				positionX += boxWidth;
			}
			positionX = 0;
			positionY += boxHeight;
		}
	}
	
	private void printgrid(Graphics2D g2){
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 7; y++) {
				if(grid[x][y].isDiaAtual()){
					g2.setColor(colorDay);
					g2.fill(grid[x][y]);
					g2.setColor(new Color(0,0,0));
				}else{
				g2.draw(grid[x][y]);
				}
				positionX += boxWidth;
			}
			positionX = 0;
			positionY += boxHeight;
		}
	}

	private void printHeader(Graphics g) {
		int positionX = 10, positionY = 25;
		// Header with names of the week
		for (int x = 0; x < 7; x++) {
			g.drawString(daysOfMonth[x], positionX, positionY);
			positionX += boxWidth;
		}
	}

	private void printDaysOfMonth(Graphics g) {
		int positionX = boxNumDayMonth, positionY = 45;
		

		// days of month
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 7; y++) {
				g.drawString(String.valueOf(grid[x][y].getDayOfMonth()), positionX, positionY);
				positionX += boxWidth;
			}
			positionX = boxNumDayMonth;
			positionY += boxHeight;
		}
	}

	private Queue<Integer> makeCalendar() {
		Queue<Integer> days =DateUtil.getAllDaysOfMonth();

		int diaSemana = DateUtil.getDiaDaSemana(1);// primeiro dia do mes
													// corresponde a qual dia da
													// semana?
		qtdDiasAnteriores(diaSemana);
		int day=0;
		int y = diaSemana - 1;
		int diaProximoMes = 1;
		for (int x = 0; x < 6; x++) {
			for (; y < 7; y++) {
				if (!days.isEmpty()) {		
					day=days.poll();
					if(DateUtil.getDiaAtual()==day){
						grid[x][y].setDiaAtual(true);
						
					}
					
					grid[x][y].setDay(DateUtil.getDiaMesAtual(day));
					grid[x][y].setDayOfMonth(day);
				} else {					
					grid[x][y].setDay(DateUtil.getDiaMesProximo(diaProximoMes));
					grid[x][y].setDayOfMonth(diaProximoMes++);
				}
			}
			y = 0;
		}
		return days;
	}

	/**
	 * 
	 * @param diaSemana
	 * @return retorna os dias anteriores para que se possa preencher a grade
	 */
	public void qtdDiasAnteriores(int diaSemana) {
		for (int i = 0, x = diaSemana - 2; i < (diaSemana - 1); i++, x--) {
			//month[0][i] = DateUtil.getUltimoDiaDoMesAnterior() - x;
			grid[0][i].setDayOfMonth(DateUtil.getUltimoDiaDoMesAnterior() - x);
			grid[0][i].setDay(DateUtil.getDiaMesAnterior(DateUtil.getUltimoDiaDoMesAnterior() - x));
			
		}		
	}
	
	
	public int getSelectedDayOfMonth(Point p){
		int day=0;
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 7; y++) {
				if (grid[x][y].contains(p)) {
					day=grid[x][y].getDayOfMonth();
				}
			}
		}
		return day;
	}
	
	public Date getSelectedDay(Point p){
		Date date=null;
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 7; y++) {
				if (grid[x][y].contains(p)) {
					date=grid[x][y].getDay();
				}
			}
		}
		return date;
	}

}
