package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import utils.DataLoading;
import utils.DataSaving;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")

public class AddProfesseurFrame extends JFrame {

	private JPanel contentPane;
	private GridBagConstraints gridBagConstraints;
	private Font font;
	private JLabel lblTitle;
	private JLabel lblPrenom;
	private JTextField txtPrenom;
	private JLabel lblNom;
	private JTextField txtNom;
	private JButton btnCancel;
	private JButton btnConfirm;

	public AddProfesseurFrame() {

		ArrayList<Eleve> eleves = DataLoading.loadEleve("res/csv/eleves.csv");
		ArrayList<Promotion> promotions = new ArrayList<Promotion>();
		for (int i = 1; i < 4; ++i) {
			promotions.add(DataLoading.loadPromotion("res/csv/promotion" + i + ".csv", eleves));
		}
		ArrayList<Professeur> professeurs = DataLoading.loadProfesseurs("res/csv/professeurs.csv");
		DataLoading.loadNotes("res/csv/notes.csv", promotions, professeurs);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		setContentPane(contentPane);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.ipadx = 300;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.insets = new Insets(20, 20, 20, 20);
		gridBagConstraints.fill = GridBagConstraints.BOTH;

		font = new Font("TimesRoman", Font.PLAIN, 40);

		lblTitle = new JLabel("Professeur", JLabel.CENTER);
		lblTitle.setFont(font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblTitle, gridBagConstraints);

		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblPrenom, gridBagConstraints);

		txtPrenom = new JTextField();
		txtPrenom.setFont(font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtPrenom, gridBagConstraints);

		lblNom = new JLabel("Nom");
		lblNom.setFont(font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblNom, gridBagConstraints);

		txtNom = new JTextField();
		txtNom.setFont(font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtNom, gridBagConstraints);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtPrenom.setText("");
				txtNom.setText("");
			}
		});
		contentPane.add(btnCancel, gridBagConstraints);

		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String prenom = txtPrenom.getText();
				String nom = txtNom.getText();
				if (!prenom.equals("") && !nom.equals("")) {
					professeurs.add(new Professeur(prenom, nom));
					DataSaving.saveProfesseur("res/csv/professeurs.csv", professeurs);
				}
			}
		});
		contentPane.add(btnConfirm, gridBagConstraints);

	}

}
