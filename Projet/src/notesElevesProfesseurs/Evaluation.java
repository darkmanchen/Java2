/**
 * 
 */
package notesElevesProfesseurs;

/**
 * @author MO Fei
 *
 */
public class Evaluation implements Comparable<Evaluation>{
	
	private String matiereConcernee;
	private int note;
	private Eleve corrige;
	private Professeur correcteur;
	
	/**
	 * @return the matiereConcernee
	 */
	public String getMatiereConcernee() {
		return matiereConcernee;
	}
	
	/**
	 * @param matiereConcernee the matiereConcernee to set
	 */
	public void setMatiereConcernee(String matiereConcernee) {
		this.matiereConcernee = matiereConcernee;
	}
	
	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}
	
	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
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
	
	
}
