package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.DataSaving;
import utils.Global;

@SuppressWarnings("serial")

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private GridBagConstraints gridBagConstraints;
	private JButton btnAddEleve;
	private JButton btnAddProfesseur;
	private JButton btnAddNote;
	private JButton btnRechercherEleve;

	public MainFrame() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {		
				DataSaving.saveEleve("res/csv/eleves.csv", Global.eleves);
				for (int i = 1; i < 4; ++i) {
					DataSaving.savePromotion("res/csv/promotion" + i + ".csv", Global.promotions.get(i-1));
				}
				DataSaving.saveProfesseur("res/csv/professeurs.csv", Global.professeurs);
				DataSaving.saveNotes("res/csv/notes.csv", Global.promotions);
				
				super.windowClosing(e);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		setContentPane(contentPane);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.ipadx = 200;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.insets = new Insets(20, 20, 20, 20);
		gridBagConstraints.fill = GridBagConstraints.BOTH;

		btnAddEleve = new JButton("   AddEleve  ");
		btnAddEleve.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		btnAddEleve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				AddEleveFrame addEleveFrame = new AddEleveFrame();
				addEleveFrame.setLocation(getLocation());
				addEleveFrame.setExtendedState(getExtendedState());
				addEleveFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAddEleve, gridBagConstraints);

		btnAddProfesseur = new JButton("AddProfesseur");
		btnAddProfesseur.setFont(Global.font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		btnAddProfesseur.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				AddProfesseurFrame addProfesseurFrame = new AddProfesseurFrame();
				addProfesseurFrame.setLocation(getLocation());
				addProfesseurFrame.setExtendedState(getExtendedState());
				addProfesseurFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAddProfesseur, gridBagConstraints);
		
		btnAddNote = new JButton("AddEvaluation");
		btnAddNote.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		btnAddNote.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AddEvaluationFrame addNoteFrame = new AddEvaluationFrame();
				addNoteFrame.setLocation(getLocation());
				addNoteFrame.setExtendedState(getExtendedState());
				addNoteFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAddNote, gridBagConstraints);  
		
		btnRechercherEleve = new JButton("RechercherEleve");
		btnRechercherEleve.setFont(Global.font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		btnRechercherEleve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RechercherEleveFrame rechercherEleveFrame = new RechercherEleveFrame();
				rechercherEleveFrame.setLocation(getLocation());
				rechercherEleveFrame.setExtendedState(getExtendedState());
				rechercherEleveFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnRechercherEleve, gridBagConstraints);  

	}
}
