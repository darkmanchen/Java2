/**
 * 
 */
package notesElevesProfesseurs;

/**
 * @author MO Fei
 *
 */
public class Evaluation implements Comparable<Evaluation> {

	private int matiereConcernee;
	private float note;
	private Eleve corrige;
	private Professeur correcteur;

	/**
	 * @param matiereConcernee
	 * @param note
	 * @param corrige
	 * @param correcteur
	 */
	public Evaluation(int matiereConcernee, float note, Eleve corrige, Professeur correcteur) {
		this.matiereConcernee = matiereConcernee;
		this.note = note;
		this.corrige = corrige;
		this.correcteur = correcteur;
	}

	/**
	 * @return the matiereConcernee
	 */
	public int getMatiereConcernee() {
		return matiereConcernee;
	}

	/**
	 * @param matiereConcernee the matiereConcernee to set
	 */
	public void setMatiereConcernee(int matiereConcernee) {
		this.matiereConcernee = matiereConcernee;
	}

	/**
	 * @return the note
	 */
	public float getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(float note) {
		this.note = note;
	}

	/**
	 * @return the corrige
	 */
	public Eleve getCorrige() {
		return corrige;
	}

	/**
	 * @param corrige the corrige to set
	 */
	public void setCorrige(Eleve corrige) {
		this.corrige = corrige;
	}

	/**
	 * @return the correcteur
	 */
	public Professeur getCorrecteur() {
		return correcteur;
	}

	/**
	 * @param correcteur the correcteur to set
	 */
	public void setCorrecteur(Professeur correcteur) {
		this.correcteur = correcteur;
	}

	@Override
	public int compareTo(Evaluation evaluation) {
		if (this.getNote() < evaluation.getNote()) {
			return -1;
		} else if (this.getNote() < evaluation.getNote()) {
			return 1;
		} else {
			return 0;
		}
	}

	/* 
	 * 
	 */
	@Override 
	public String toString() {	// ((Jean, Duval) (Soleil, Tournesol) math¨¦matiques 12.0)
		return "(" + getCorrige() + "  " + getCorrecteur() + " " + getMatiereConcernee() + " " + getNote() + ")";
	}

}
