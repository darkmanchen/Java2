/**
 * 
 */
package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author MO Fei
 *
 */
interface EleveComparator {

	public abstract void classerParMoyenneDesNotes(Ordre ordre);

	public abstract void classerParMedianeDesNotes(Ordre ordre);

	public abstract void classerParMatiere();
}

public class Eleve extends Personnes implements Comparable<Eleve> {

	public class Naissance {
		public static final int NB_EVALUATIONS = 10;

		private int jour;
		private int mois;
		private int annee;

		/**
		 * @param jour
		 * @param mois
		 * @param annee
		 */
		public Naissance(int jour, int mois, int annee) {
			super();
			this.jour = jour;
			this.mois = mois;
			this.annee = annee;
		}

		/**
		 * @return the jour
		 */
		public int getJour() {
			return jour;
		}

		/**
		 * @return the mois
		 */
		public int getMois() {
			return mois;
		}

		/**
		 * @return the annee
		 */
		public int getAnnee() {
			return annee;
		}

		/* 
		 * 
		 */
		@Override
		public String toString() {
			return "Naissance [jour=" + jour + ", mois=" + mois + ", annee=" + annee + "]";
		}

	}

	private static int nombreTotal;
	private final int numeroID;
	private Naissance naissance;
	private ArrayList<Evaluation> evaluations;
	private Promotion promotion;

	/**
	 * @param nom
	 * @param prenom
	 * @param jour
	 * @param mois
	 * @param annee
	 */
	public Eleve(String prenom, String nom, int jour, int mois, int annee) {
		this.setPrenom(prenom);
		this.setNom(nom);
		this.naissance = new Naissance(jour, mois, annee);
		evaluations = new ArrayList<Evaluation>();
		numeroID = nombreTotal;
		nombreTotal += 1;
	}

	/**
	 * @return the numeroID
	 */
	public int getNumeroID() {
		return numeroID;
	}

	/**
	 * @return the naissance
	 */
	public Naissance getNaissance() {
		return naissance;
	}

	/**
	 * @return the evaluations
	 */
	public ArrayList<Evaluation> getEvaluations() {
		return evaluations;
	}

	/**
	 * @param evaluations the evaluations to set
	 */
	public void setEvaluations(ArrayList<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	/**
	 * @return the promotion
	 */
	public Promotion getPromotion() {
		return promotion;
	}

	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	/**
	 * 
	 */
	public void tousLesNotes() {
		getEvaluations();
	}

	/**
	 * 
	 */
	public int moyenne() throws IllegalStateException {
		int moyenne = 0;
		if (getEvaluations().isEmpty()) {
			throw new IllegalStateException();
		}
		for (Evaluation evaluation : getEvaluations()) {
			moyenne += evaluation.getNote();
		}
		moyenne /= evaluations.size();
		return moyenne;
	}

	/**
	 * 
	 */
	public float mediane() throws IllegalStateException {
		Collections.sort(getEvaluations());
		if (getEvaluations().isEmpty()) {
			throw new IllegalStateException();
		}
		if (getEvaluations().size() % 1 == 1) {
			return getEvaluations().get(getEvaluations().size() / 2 + 1).getNote();
		} else {
			return (float) (getEvaluations().get(getEvaluations().size() / 2).getNote()
					+ getEvaluations().get(getEvaluations().size() / 2 + 1).getNote()) / 2.0f;
		}
	}

	public Set<Professeur> getCorrecteurs() {
		HashSet<Professeur> correcteurs = new HashSet<Professeur>();
		for (Evaluation evaluation : getEvaluations()) {
			if (!correcteurs.contains(evaluation.getCorrecteur())) {
				correcteurs.add(evaluation.getCorrecteur());
			}
		}
		return correcteurs;
	}

	@Override
	public int compareTo(Eleve eleve) {
		if (this.getNumeroID() < eleve.getNumeroID()) {
			return -1;
		} else if (this.getNumeroID() > eleve.getNumeroID()) {
			return 1;
		} else {
			return 0;
		}
	}

	/* 
	 * 
	 */
	@Override
	public String toString() {
		String information = super.toString() + " id: " + getNumeroID() + "\npromotion: "
				+ getPromotion().getPromotionNom() + "\nnotes: ";
		for (Evaluation evaluation : getEvaluations()) {
			information += "\nMatiereConcernee: " + evaluation.getMatiereConcernee() + "\tnote: "
					+ evaluation.getNote();

		}
		information += "\nmoyenne = " + moyenne() + "\nmediane = " + mediane() + "\ncorrecteur(s): " + getCorrecteurs()
				+ "\n";
		return information;
	}

	/* 
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (getNumeroID() == ((Eleve) obj).getNumeroID()) {
			return true;
		} else {
			return false;
		}
	}

	/* 
	 * 
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
