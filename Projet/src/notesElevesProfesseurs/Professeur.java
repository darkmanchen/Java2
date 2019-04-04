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
	 * @param prenom
	 * @param nom
	 */
	public Professeur(String prenom, String nom) {
		this.setPrenom(prenom);
		this.setNom(nom);
	}

	/**
	 * @param promotion
	 * @param numeroID
	 */
	public Eleve rechercher(Promotion promotion, int numeroID) {
		for (Eleve eleve : promotion.getEleves()) {
			if (eleve.getNumeroID() == numeroID) {
				return eleve;
			}
		}
		return null;
	}

	/**
	 * @param promotion
	 * @param numeroID
	 * @param note
	 * @param i index of the MatiereConcernee
	 * @throws IllegalStateException
	 */
	public void setNote(Promotion promotion, int numeroID, float note, int i) throws IllegalStateException {
		Eleve eleve = null;
		for (Eleve elv : promotion.getEleves()) {
			if (elv.getNumeroID() == numeroID) {
				eleve = elv;
			}
		}
		if (eleve == null) {
			throw new IllegalStateException();
		} else {
			for (Evaluation evaluation : eleve.getEvaluations()) {
				if (evaluation.getMatiereConcernee() == i) {
					evaluation.setNote(note);
					return;
				}
			}
			eleve.getEvaluations().add(new Evaluation(i, note, eleve, this));
		}
	}

}
