package ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Promotion;
import utils.DataSaving;
import utils.Global;

@SuppressWarnings("serial")

public class RechercherEleveFrame extends JFrame {

	private JPanel contentPane;
	private GridBagConstraints gridBagConstraints;
	private JLabel lblTitle;
	private JLabel lblNumeroID;
	private JTextField txtNumeroID;
	private JButton btnRechercherButton;
	private JTable table;
	private JScrollPane scrollPane;

	public RechercherEleveFrame() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DataSaving.saveEleve("res/csv/eleves.csv", Global.eleves);
				for (int i = 1; i < 4; ++i) {
					DataSaving.savePromotion("res/csv/promotion" + i + ".csv", Global.promotions.get(i - 1));
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
		gridBagConstraints.ipadx = 0;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.insets = new Insets(20, 20, 20, 20);
		gridBagConstraints.fill = GridBagConstraints.BOTH;

		lblTitle = new JLabel("Rechercher par numero id", JLabel.CENTER);
		lblTitle.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblTitle, gridBagConstraints);

		lblNumeroID = new JLabel("NumeroID");
		lblNumeroID.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblNumeroID, gridBagConstraints);

		txtNumeroID = new JTextField();
		txtNumeroID.setFont(Global.font);
		gridBagConstraints.ipadx = 300;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtNumeroID, gridBagConstraints);

		btnRechercherButton = new JButton("Rechercher");
		btnRechercherButton.setFont(Global.font);
		gridBagConstraints.ipadx = 0;
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		btnRechercherButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Promotion promotion : Global.promotions) {
					for (Eleve eleve : promotion.getEleves()) {
						if (eleve.getNumeroID() == Integer.parseInt(txtNumeroID.getText())) {

							String prenom = eleve.getPrenom();
							String nom = eleve.getNom();
							String moyenne = Integer.toString(eleve.moyenne());
							String mediane = Float.toString(eleve.mediane());
							table.getModel().setValueAt(prenom, 0, 0);
							table.getModel().setValueAt(nom, 0, 1);
							table.getModel().setValueAt(moyenne, 0, 2);
							table.getModel().setValueAt(mediane, 0, 3);
						}
					}
				}

			}
		});
		contentPane.add(btnRechercherButton, gridBagConstraints);

		Object[] columnNames = { "Prenom", "Nom", "moyenne", "mediane" };
		table = new JTable(new DefaultTableModel(columnNames, 1));
		table.getTableHeader().setFont(Global.font);
		table.setFont(Global.font);
		table.setRowHeight(80);
		table.setPreferredScrollableViewportSize(new Dimension(0, 200));
		scrollPane = new JScrollPane(table);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.gridheight = 1;
		contentPane.add(scrollPane, gridBagConstraints);
		table.updateUI();
	}
}
