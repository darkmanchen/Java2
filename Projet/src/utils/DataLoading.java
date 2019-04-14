/**
 * 
 */
package utils;

import java.util.ArrayList;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

/**
 * @author MO Fei
 *
 */
public class DataLoading {
	
	public static ArrayList<Eleve> loadingEleve(String filePath) {
		ArrayList<Eleve> eleves = new ArrayList<Eleve>();
		ArrayList<ArrayList<String>> elevesInfo = CSVIO.read(filePath);
		for (ArrayList<String> eleveInfo : elevesInfo) {
			Eleve eleve = new Eleve(eleveInfo.get(0), eleveInfo.get(1), Integer.parseInt(eleveInfo.get(2)),
					Integer.parseInt(eleveInfo.get(3)), Integer.parseInt(eleveInfo.get(4)));
			eleves.add(eleve);
		}
		return eleves;
	}

	public static Promotion loadingPromotion(String filePath, ArrayList<Eleve> eleves) {
		Promotion promotion = new Promotion(filePath.substring(8, filePath.lastIndexOf('.')));
		ArrayList<ArrayList<String>> ids = CSVIO.read(filePath);
		for (ArrayList<String> id : ids) {
			for (Eleve eleve : eleves) {
				if (eleve.getNumeroID() == Integer.parseInt(id.get(0))) {
					promotion.add(eleve);
				}
			}
		}
		return promotion;
	}

	public static ArrayList<Professeur> loadingProfesseurs(String filePath) {
		ArrayList<Professeur> professeurs = new ArrayList<Professeur>();
		ArrayList<ArrayList<String>> professeursInfo = CSVIO.read(filePath);
		for (ArrayList<String> professeurInfo : professeursInfo) {
			Professeur professeur = new Professeur(professeurInfo.get(0), professeurInfo.get(1));
			professeurs.add(professeur);
		}
		return professeurs;
	}

	public static void loadingNotes(String filePath, ArrayList<Promotion> promotions,
			ArrayList<Professeur> professeurs) {
		ArrayList<ArrayList<String>> notesInfo = CSVIO.read(filePath);
		for (ArrayList<String> noteInfo : notesInfo) {
			for (Professeur professeur : professeurs) {
				if (professeur.getPrenom().equals(noteInfo.get(4)) && professeur.getNom().equals(noteInfo.get(5))) {
					for (Promotion promotion : promotions) {
						if (promotion.getPromotionNom().equals(noteInfo.get(0))) {
							professeur.setNote(promotion, Integer.parseInt(noteInfo.get(1)),
									Float.parseFloat(noteInfo.get(2)), Integer.parseInt(noteInfo.get(3).substring(16)));
						}
					}

				}
			}
		}
	}

}
