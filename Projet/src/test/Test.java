/**
 * 
 */
package test;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

/**
 * @author MO Fei
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Eleve eleve1 = new Eleve("eleve1", "ELEVE1", 1, 1, 2011);
		Eleve eleve2 = new Eleve("eleve2", "ELEVE2", 2, 2, 2012);
		Eleve eleve3 = new Eleve("eleve3", "ELEVE3", 3, 3, 2013);
		Eleve eleve4 = new Eleve("eleve4", "ELEVE4", 4, 4, 2014);

		Promotion promotion1 = new Promotion("promotion1");
		Promotion promotion2 = new Promotion("promotion2");

		Professeur professeur1 = new Professeur("professeur1", "PROFESSEUR1");
		Professeur professeur2 = new Professeur("professeur2", "PROFESSEUR2");

		eleve1.setPromotion(promotion1);
		eleve2.setPromotion(promotion1);
		eleve3.setPromotion(promotion2);
		eleve4.setPromotion(promotion2);

		int matiereConcernee1 = 1;
		int matiereConcernee2 = 2;
		int matiereConcernee3 = 3;

		professeur1.setNote(promotion1, eleve1.getNumeroID(), 11, matiereConcernee1);
		professeur1.setNote(promotion1, eleve1.getNumeroID(), 12, matiereConcernee2);
		professeur1.setNote(promotion1, eleve1.getNumeroID(), 13, matiereConcernee3);
		professeur1.setNote(promotion1, eleve2.getNumeroID(), 21, matiereConcernee1);
		professeur1.setNote(promotion1, eleve2.getNumeroID(), 22, matiereConcernee2);
		professeur1.setNote(promotion1, eleve2.getNumeroID(), 23, matiereConcernee3);
		professeur2.setNote(promotion2, eleve3.getNumeroID(), 31, matiereConcernee1);
		professeur2.setNote(promotion2, eleve3.getNumeroID(), 32, matiereConcernee2);
		professeur2.setNote(promotion2, eleve3.getNumeroID(), 33, matiereConcernee3);
		professeur2.setNote(promotion2, eleve4.getNumeroID(), 41, matiereConcernee1);
		professeur2.setNote(promotion2, eleve4.getNumeroID(), 42, matiereConcernee2);
		professeur2.setNote(promotion2, eleve4.getNumeroID(), 43, matiereConcernee3);

		System.out.println(eleve1);
		System.out.println(promotion1);
		System.out.println(promotion1.rechercher(eleve1.getNumeroID()));
	}

}
