/**
 * 
 */
package utils;

import java.util.ArrayList;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

/**
 * @author MO Fei
 *
 */
public class DataSaving {
	public static void saveEleve(String filePath, ArrayList<Eleve> eleves) {
		ArrayList<ArrayList<String>> arrayLists = new ArrayList<ArrayList<String>>();
		for (Eleve eleve : eleves) {
			ArrayList<String> eleveInfo = new ArrayList<String>();
			eleveInfo.add(eleve.getPrenom());
			eleveInfo.add(eleve.getNom());
			eleveInfo.add(Integer.toString(eleve.getNaissance().getJour()));
			eleveInfo.add(Integer.toString(eleve.getNaissance().getMois()));
			eleveInfo.add(Integer.toString(eleve.getNaissance().getAnnee()));
			arrayLists.add(eleveInfo);
		}
		CSVIO.save(filePath, arrayLists);
	}

	public static void savePromotion(String filePath, Promotion promotion) {
		ArrayList<ArrayList<String>> arrayLists = new ArrayList<ArrayList<String>>();
		ArrayList<Eleve> eleves = promotion.getEleves();
		for (Eleve eleve : eleves) {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(Integer.toString(eleve.getNumeroID()));
			arrayLists.add(arrayList);
		}
		CSVIO.save(filePath, arrayLists);
	}

	public static void saveProfesseur(String filePath, ArrayList<Professeur> professeurs) {
		ArrayList<ArrayList<String>> arrayLists = new ArrayList<ArrayList<String>>();
		for (Professeur professeur : professeurs) {
			ArrayList<String> professeurInfo = new ArrayList<String>();
			professeurInfo.add(professeur.getPrenom());
			professeurInfo.add(professeur.getNom());
			arrayLists.add(professeurInfo);
		}
		CSVIO.save(filePath, arrayLists);
	}

	public static void saveNotes(String filePath, ArrayList<Promotion> promotions) {
		ArrayList<ArrayList<String>> arrayLists = new ArrayList<ArrayList<String>>();
		for (Promotion promotion : promotions) {
			ArrayList<Eleve> eleves = promotion.getEleves();
			for (Eleve eleve : eleves) {
				ArrayList<Evaluation> evaluations = eleve.getEvaluations();
				for (Evaluation evaluation : evaluations) {
					ArrayList<String> noteInfo = new ArrayList<String>();
					noteInfo.add(promotion.getPromotionNom());
					noteInfo.add(Integer.toString(eleve.getNumeroID()));
					noteInfo.add(Float.toString(evaluation.getNote()));
					noteInfo.add("MatiereConcernee"+Integer.toString(evaluation.getMatiereConcernee()));
					noteInfo.add(evaluation.getCorrecteur().getPrenom());
					noteInfo.add(evaluation.getCorrecteur().getNom());
					arrayLists.add(noteInfo);
				}
			}
		}
		CSVIO.save(filePath, arrayLists);
	}
}
