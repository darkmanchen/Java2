/**
 * 
 */
package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * @author MO Fei
 *
 */
interface EleveComparator {
	public abstract void classerParMoyenneDesNotes();

	public abstract void classerParMedianeDesNotes();

	public abstract void classerParMatiere();
}

public class Eleve extends Personnes implements Comparable<Eleve> {

	private long numeroID;
	private Date naissance;
	private ArrayList<Evaluation> evaluations;
	private Promotion promotion;

	/**
	 * 
	 */
	private Eleve() {
		evaluations = new ArrayList<Evaluation>();
	}

	/**
	 * @param prenom
	 * @param nom
	 * @param numeroID
	 * @param naissance
	 * @param promotion
	 */
	public Eleve(String prenom, String nom, long numeroID, Date naissance, Promotion promotion) {
		this();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setNumeroID(numeroID);
		this.setNaissance(naissance);
		this.setPromotion(promotion);
	}

	/**
	 * @return the numeroID
	 */
	public long getNumeroID() {
		return numeroID;
	}

	/**
	 * @param numeroID the numeroID to set
	 */
	public void setNumeroID(long numeroID) {
		this.numeroID = numeroID;
	}

	/**
	 * @return the naissance
	 */
	public Date getNaissance() {
		return naissance;
	}

	/**
	 * @param naissance the naissance to set
	 */
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
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
	public int moyenne() {
		int moyenne = 0;
		for (Evaluation evaluation : getEvaluations()) {
			moyenne += evaluation.getNote();
		}
		moyenne /= evaluations.size();
		return moyenne;
	}

	/**
	 * 
	 */
	public int mediane() {
		Collections.sort(getEvaluations());
		if (getEvaluations().size() % 1 == 1) {
			return getEvaluations().get(getEvaluations().size() / 2 + 1).getNote();
		} else {
			return (getEvaluations().get(getEvaluations().size() / 2).getNote()
					+ getEvaluations().get(getEvaluations().size() / 2 + 1).getNote()) / 2;
		}
	}

	@Override
	public int compareTo(Eleve eleve) {
		if (this.getNumeroID()<eleve.getNumeroID()) {
			return -1;
		} else if (this.getNumeroID()>eleve.getNumeroID()) {
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
		return "("+getPrenom()+", "+getNom()+")";
	}

	
}
