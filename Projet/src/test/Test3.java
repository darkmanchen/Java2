package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import utils.DataLoading;

public class Test3 {

	public static void main(String[] args) {
		ArrayList<Eleve> eleves = DataLoading.loadEleve("res/csv/eleves.csv");
		ArrayList<Promotion> promotions = new ArrayList<Promotion>();
		for (int i = 1; i < 4; ++i) {
			promotions.add(DataLoading.loadPromotion("res/csv/promotion" + i + ".csv", eleves));
		}
		ArrayList<Professeur> professeurs = DataLoading.loadProfesseurs("res/csv/professeurs.csv");
		DataLoading.loadNotes("res/csv/notes.csv", promotions, professeurs);

		double promo1_matiere1_moyenne = 0.0;
		double promo1_matiere2_moyenne = 0.0;
		double promo1_matiere3_moyenne = 0.0;
		double promo1_matiere4_moyenne = 0.0;
		for (Eleve eleve : promotions.get(0).getEleves()) {
			for (Evaluation evaluation : eleve.getEvaluations()) {
				switch (evaluation.getMatiereConcernee()) {
				case 1:
					promo1_matiere1_moyenne += evaluation.getNote();
					break;
				case 2:
					promo1_matiere2_moyenne += evaluation.getNote();
					break;
				case 3:
					promo1_matiere3_moyenne += evaluation.getNote();
					break;
				case 4:
					promo1_matiere4_moyenne += evaluation.getNote();
					break;

				default:
					break;
				}
			}
		}
		promo1_matiere1_moyenne = promo1_matiere1_moyenne / promotions.get(0).getEleves().size();
		promo1_matiere2_moyenne = promo1_matiere2_moyenne / promotions.get(0).getEleves().size();
		promo1_matiere3_moyenne = promo1_matiere3_moyenne / promotions.get(0).getEleves().size();
		promo1_matiere4_moyenne = promo1_matiere4_moyenne / promotions.get(0).getEleves().size();
		
		double promo2_matiere1_moyenne = 0.0;
		double promo2_matiere2_moyenne = 0.0;
		double promo2_matiere3_moyenne = 0.0;
		double promo2_matiere4_moyenne = 0.0;
		for (Eleve eleve : promotions.get(1).getEleves()) {
			for (Evaluation evaluation : eleve.getEvaluations()) {
				switch (evaluation.getMatiereConcernee()) {
				case 1:
					promo2_matiere1_moyenne += evaluation.getNote();
					break;
				case 2:
					promo2_matiere2_moyenne += evaluation.getNote();
					break;
				case 3:
					promo2_matiere3_moyenne += evaluation.getNote();
					break;
				case 4:
					promo2_matiere4_moyenne += evaluation.getNote();
					break;

				default:
					break;
				}
			}
		}
		promo2_matiere1_moyenne = promo2_matiere1_moyenne / promotions.get(1).getEleves().size();
		promo2_matiere2_moyenne = promo2_matiere2_moyenne / promotions.get(1).getEleves().size();
		promo2_matiere3_moyenne = promo2_matiere3_moyenne / promotions.get(1).getEleves().size();
		promo2_matiere4_moyenne = promo2_matiere4_moyenne / promotions.get(1).getEleves().size();
		
		double promo3_matiere1_moyenne = 0.0;
		double promo3_matiere2_moyenne = 0.0;
		double promo3_matiere3_moyenne = 0.0;
		double promo3_matiere4_moyenne = 0.0;
		for (Eleve eleve : promotions.get(2).getEleves()) {
			for (Evaluation evaluation : eleve.getEvaluations()) {
				switch (evaluation.getMatiereConcernee()) {
				case 1:
					promo3_matiere1_moyenne += evaluation.getNote();
					break;
				case 2:
					promo3_matiere2_moyenne += evaluation.getNote();
					break;
				case 3:
					promo3_matiere3_moyenne += evaluation.getNote();
					break;
				case 4:
					promo3_matiere4_moyenne += evaluation.getNote();
					break;

				default:
					break;
				}
			}
		}
		promo3_matiere1_moyenne = promo3_matiere1_moyenne / promotions.get(2).getEleves().size();
		promo3_matiere2_moyenne = promo3_matiere2_moyenne / promotions.get(2).getEleves().size();
		promo3_matiere3_moyenne = promo3_matiere3_moyenne / promotions.get(2).getEleves().size();
		promo3_matiere4_moyenne = promo3_matiere4_moyenne / promotions.get(2).getEleves().size();

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.addValue(promo1_matiere1_moyenne, promotions.get(0).getPromotionNom(), "matiere1");
		dataset.addValue(promo1_matiere2_moyenne, promotions.get(0).getPromotionNom(), "matiere2");
		dataset.addValue(promo1_matiere3_moyenne, promotions.get(0).getPromotionNom(), "matiere3");
		dataset.addValue(promo1_matiere4_moyenne, promotions.get(0).getPromotionNom(), "matiere4");
		
		dataset.addValue(promo2_matiere1_moyenne, promotions.get(1).getPromotionNom(), "matiere1");
		dataset.addValue(promo2_matiere2_moyenne, promotions.get(1).getPromotionNom(), "matiere2");
		dataset.addValue(promo2_matiere3_moyenne, promotions.get(1).getPromotionNom(), "matiere3");
		dataset.addValue(promo2_matiere4_moyenne, promotions.get(1).getPromotionNom(), "matiere4");

		dataset.addValue(promo3_matiere1_moyenne, promotions.get(2).getPromotionNom(), "matiere1");
		dataset.addValue(promo3_matiere2_moyenne, promotions.get(2).getPromotionNom(), "matiere2");
		dataset.addValue(promo3_matiere3_moyenne, promotions.get(2).getPromotionNom(), "matiere3");
		dataset.addValue(promo3_matiere4_moyenne, promotions.get(2).getPromotionNom(), "matiere4");

		JFreeChart barChart = ChartFactory.createBarChart("Moyenne", "Matiere", "Note", dataset, PlotOrientation.VERTICAL, true, true, false);
		
		File chartFile = new File("res/jpeg/BarChart.jpeg");
		try {
			ChartUtilities.saveChartAsJPEG(chartFile, barChart, 800, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
