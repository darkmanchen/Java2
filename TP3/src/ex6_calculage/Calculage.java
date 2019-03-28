package ex6_calculage;

import java.util.Calendar;

//---Singleton---
public class Calculage {
	private Calculage() {}
	
	public static int calculAge(int annee) {
		return Calendar.getInstance().get(Calendar.YEAR) - annee;
	}
	
}
