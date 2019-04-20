package test;

import java.util.ArrayList;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import utils.DataLoading;
import utils.DataSaving;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<Eleve> eleves = DataLoading.loadEleve("res/csv/eleves.csv");
		ArrayList<Promotion> promotions = new ArrayList<Promotion>();
		for (int i = 1; i < 4; ++i) {
			promotions.add(DataLoading.loadPromotion("res/csv/promotion" + i + ".csv", eleves));
		}
		ArrayList<Professeur> professeurs = DataLoading.loadProfesseurs("res/csv/professeurs.csv");
		DataLoading.loadNotes("res/csv/notes.csv", promotions, professeurs);
		
		System.out.println("---------------Professeurs---------------");
		System.out.println(professeurs + "\n");
		System.out.println("---------------Eleves---------------");
		System.out.println(eleves + "\n");
		System.out.println("---------------Promotions---------------");
		System.out.println(promotions + "\n");
		
		DataSaving.saveEleve("res/csv/eleves.csv", eleves);
		for (int i = 1; i < 4; ++i) {
			DataSaving.savePromotion("res/csv/promotion" + i + ".csv", promotions.get(i-1));
		}
		DataSaving.saveProfesseur("res/csv/professeurs.csv", professeurs);
		DataSaving.saveNotes("res/csv/notes2.csv", promotions);
	}

}
