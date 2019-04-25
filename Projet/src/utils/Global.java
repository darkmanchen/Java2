package utils;

import java.awt.Font;
import java.util.ArrayList;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

public class Global {

	private static Global global = new Global();
	public static Font font;
	public static ArrayList<Eleve> eleves;
	public static ArrayList<Promotion> promotions;
	public static ArrayList<Professeur> professeurs;

	private Global() {
		font = new Font("TimesRoman", Font.PLAIN, 40);
	}

	public static Global getInstance() {
		return global;
	}

}
