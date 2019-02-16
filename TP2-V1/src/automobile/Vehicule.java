package automobile;

interface VehiculeComparator {
	abstract public void triNoImmatriculion();

	abstract public void triCompteur();
}

public class Vehicule implements Comparable<Vehicule> {

	private static int registre = 0;
	private int noImmatriculation;
	private Compteur compteur;
	private double capacite;
	private double jauge;
	private double consommation;

	private Vehicule() {
		setRegistre(getRegistre() + 1);
		setNoImmatriculation(getRegistre() - 1);
		compteur = new Compteur();
		setCapacite(50);
	}

	public Vehicule(double consommation) {
		this();
		setConsommation(consommation);
	}

	private static int getRegistre() {
		return registre;
	}

	private static void setRegistre(int registre) {
		Vehicule.registre = registre;
	}

	public int getNoImmatriculation() {
		return noImmatriculation;
	}

	private void setNoImmatriculation(int noImmatriculation) {
		this.noImmatriculation = noImmatriculation;
	}

	public Compteur getCompteur() {
		return compteur;
	}

	public double getCapacite() {
		return capacite;
	}

	private void setCapacite(double capacite) {
		this.capacite = capacite;
	}

	private void setJauge(double jauge) {
		this.jauge = jauge;
	}

	public double getJauge() {
		return jauge;
	}

	public void setConsommation(double consommation) {
		this.consommation = consommation;
	}

	public double getConsommation() {
		return consommation;
	}

	public void mettreDeLessence(double carburant) throws CapaciteDepasseeException {
		if ((getJauge() + carburant) > getCapacite()) {
			throw new CapaciteDepasseeException(carburant);
		} else {
			setJauge(getJauge() + carburant);
		}
	}

	public void faireLePlein() {
		setJauge(getCapacite());
	}

	public double rouler(double distance) {
		double distanceParcourue = 0.0;
		if ((getJauge() - distance / 100 * getConsommation()) > 0) {
			getCompteur().add(distance);
			setJauge(getJauge() - (double) distance / 100 * getConsommation());
			distanceParcourue = distance;
			return distanceParcourue;
		} else {
			distanceParcourue = getJauge() / getConsommation() * 100.0;
			getCompteur().add((int) distanceParcourue);
			faireLePlein();
			return distanceParcourue;
		}
	}

	@Override
	public int compareTo(Vehicule vehicule) {
		if (this.getNoImmatriculation() < vehicule.getNoImmatriculation()) {
			return -1;
		} else if (this.getNoImmatriculation() > vehicule.getNoImmatriculation()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Vehicule " + this.getNoImmatriculation() + " : compteur = [Totalisateur = "
				+ this.getCompteur().getTotalisateur() + " | Partiel = " + this.getCompteur().getPartiel()
				+ "];; jauge = " + getJauge();
	}

}
