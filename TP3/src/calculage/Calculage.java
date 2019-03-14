package calculage;

import java.util.Calendar;

public class Calculage {
	public Calculage() {	
	}
	
	public int calculAge(int annee) {
		return Calendar.getInstance().get(Calendar.YEAR) - annee;
	}
	
}
