package automobile;

public class Compteur {

	private static final int MILLE = 1000;

	private int totalisateur;
	private int partiel;

	public Compteur() {
		super();
		setTotalisateur(0);
		setPartiel(0);
	}

	public int getTotalisateur() {
		return totalisateur;
	}

	public int getPartiel() {
		return partiel;
	}

	public void resetPartiel() {
		setPartiel(0);
	}

	private void setTotalisateur(int totalisateur) {
		this.totalisateur = totalisateur;
	}

	public void setPartiel(int partiel) {
		this.partiel = partiel;
	}

	public void add(double distance) {
		setTotalisateur((int)(getTotalisateur() + distance));
		if ((getPartiel() + distance) > Compteur.MILLE) {
			setPartiel((int)(getPartiel() + distance - Compteur.MILLE));
		} else {
			setPartiel((int)(getPartiel() + distance));
		}
	}

	@Override
	public String toString() {
		return "compteur = [Totalisateur = " + getTotalisateur() + " | partiel = " + getPartiel() + "];";
	}

}
