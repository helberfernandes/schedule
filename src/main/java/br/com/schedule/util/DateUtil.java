package br.com.schedule.util;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class DateUtil {


	/**
	 * Recuperar a quantidade de dias no m�s
	 * 
	 * @param mes
	 *            M�s que deseja saber a quantidade de dias
	 * @return quantidade de dias
	 */
	public static int getQuantidadeDiasByMes(int mes) {

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2017);
		c.set(Calendar.MONTH, mes - 1);
		c.set(Calendar.DAY_OF_MONTH, 20);

		int quantidadeDias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return quantidadeDias;
	}

	public static int getDiaDaSemana(int dia) {

		Calendar c = Calendar.getInstance();		
		c.set(Calendar.DAY_OF_MONTH, dia);

		int quantidadeDias = c.get(Calendar.DAY_OF_WEEK);
		return quantidadeDias;
	}
	
	public static int getDiaAtual() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.DAY_OF_MONTH);
	}

	public static int getTotalDiasdoMesAtual() {
		Calendar c = Calendar.getInstance();
		int quantidadeDias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return quantidadeDias;
	}
	
	public static int getUltimoDiaDoMesAnterior() {
		Calendar c = Calendar.getInstance();	
	    c.add(Calendar.MONTH, -1);	
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));	   
	    int quantidadeDias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return quantidadeDias;
	}
	
	
	public static int getMesAnterior() {
		Calendar c = Calendar.getInstance();	
	    c.add(Calendar.MONTH, -1);
		return c.get(Calendar.MONTH);
	}
	
	public static int getMesProximo() {
		Calendar c = Calendar.getInstance();	
	    c.add(Calendar.MONTH, 1);
		return c.get(Calendar.MONTH);
	}
	
	public static Date getDiaMesAtual(int day){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,day);
		return c.getTime();
	}
	
	public static Date getDiaMesAnterior(int day){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,day);
		c.set(Calendar.MONTH,getMesAnterior());
		return c.getTime();
	}
	
	public static Date getDiaMesProximo(int day){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,day);
		c.set(Calendar.MONTH,getMesProximo());
		return c.getTime();
	}
	
	public static int getUltimoDiaDoProximoMes() {
		Calendar c = Calendar.getInstance();	
	    c.add(Calendar.MONTH, +1);	
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));	   
	    int quantidadeDias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return quantidadeDias;
	}
	
	public static Queue<Integer> getAllDaysOfMonth(){
		Queue<Integer> days = new LinkedList();

		for (int d = 0; d < getTotalDiasdoMesAtual(); d++) {
			days.offer((d + 1));
		}
		return days;
	}
}
