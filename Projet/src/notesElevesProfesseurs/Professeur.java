/**
 * 
 */
package notesElevesProfesseurs;

/**
 * @author MO Fei
 *
 */
public class Professeur extends Personnes {

	/**
	 * 
	 */
	public Professeur() {
		
	}

	/**
	 * @param prenom
	 * @param nom
	 */
	public Professeur(String prenom, String nom) {
		this();
		this.setPrenom(prenom);
		this.setNom(nom);
	}
	
	/**
	 * @param promotion
	 * @param numeroID
	 */
	public Eleve rechercherEleveParID(Promotion promotion, long numeroID) {
		for (Eleve eleve : promotion) {
			if (eleve.getNumeroID() == numeroID) {
				return eleve;
			}
		}
		return null;
	}
	
	/**
	 * @param eleve
	 * @param matiereConcernee
	 * @param note
	 * @return
	 */
	public boolean modifierNotes(Eleve eleve, String matiereConcernee, int note) {
		for (Evaluation evaluation : eleve.getEvaluations()) {
			if (evaluation.getMatiereConcernee() == matiereConcernee) {
				evaluation.setNote(note);
				return true;
			}
		}
		return false;
	}
	
}
