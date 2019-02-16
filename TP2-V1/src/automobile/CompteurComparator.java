package automobile;

import java.util.Comparator;

public class CompteurComparator implements Comparator<Vehicule>{

	@Override
	public int compare(Vehicule vehicule1, Vehicule vehicule2) {
		if (vehicule1.getCompteur().getTotalisateur() < vehicule2.getCompteur().getTotalisateur()) {
			return -1;
		} else if (vehicule1.getCompteur().getTotalisateur() > vehicule2.getCompteur().getTotalisateur()) {
			return 1;
		} else {
			return 0;
		}
	}

}
