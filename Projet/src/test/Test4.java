package test;

import java.awt.EventQueue;
import java.util.ArrayList;

import notesElevesProfesseurs.Promotion;
import ui.MainFrame;
import utils.DataLoading;
import utils.Global;

public class Test4 {

	public static void main(String[] args) {
		
		Global.eleves = DataLoading.loadEleve("res/csv/eleves.csv");
		Global.promotions  = new ArrayList<Promotion>();
		for (int i = 1; i < 4; ++i) {
			Global.promotions.add(DataLoading.loadPromotion("res/csv/promotion" + i + ".csv", Global.eleves));
		}
		Global.professeurs = DataLoading.loadProfesseurs("res/csv/professeurs.csv");
		DataLoading.loadNotes("res/csv/notes.csv", Global.promotions, Global.professeurs);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainFrame = new MainFrame();
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
