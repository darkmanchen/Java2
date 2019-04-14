package test;

import java.util.ArrayList;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import utils.DataLoading;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<Eleve> eleves = DataLoading.loadingEleve("res/csv/eleves.csv");
		ArrayList<Promotion> promotions = new ArrayList<Promotion>();
		for (int i = 1; i < 4; ++i) {
			promotions.add(DataLoading.loadingPromotion("res/csv/promotion" + i + ".csv", eleves));
		}
		ArrayList<Professeur> professeurs = DataLoading.loadingProfesseurs("res/csv/professeurs.csv");
		
		for (int j = 1; j < 5; ++j) {
			DataLoading.loadingNotes("res/csv/notes" + j + ".csv", promotions, professeurs);
		}
		
		System.out.println("---------------Professeurs---------------");
		System.out.println(professeurs);
		System.out.println("---------------Eleves---------------");
		System.out.println(eleves);
		System.out.println("---------------Promotions---------------");
		System.out.println(promotions);
	}

}
