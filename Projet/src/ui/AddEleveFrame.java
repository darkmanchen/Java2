package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import notesElevesProfesseurs.Eleve;
import utils.DataSaving;
import utils.Global;

@SuppressWarnings("serial")

public class AddEleveFrame extends JFrame {

	private JPanel contentPane;
	private GridBagConstraints gridBagConstraints;
	private JLabel lblTitle;
	private JLabel lblPrenom;
	private JTextField txtPrenom;
	private JLabel lblNom;
	private JTextField txtNom;
	private JLabel lblNaissance;
	private JComboBox<Integer> cmbNaissanceJour;
	private JComboBox<Integer> cmbNaissanceMois;
	private JComboBox<Integer> cmbNaissanceAnnee;
	private JButton btnCancel;
	private JButton btnConfirm;

	public AddEleveFrame() {

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
		gridBagConstraints.ipadx = 40;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.insets = new Insets(20, 20, 20, 20);
		gridBagConstraints.fill = GridBagConstraints.BOTH;

		lblTitle = new JLabel("Eleve", JLabel.CENTER);
		lblTitle.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblTitle, gridBagConstraints);

		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblPrenom, gridBagConstraints);

		txtPrenom = new JTextField();
		txtPrenom.setFont(Global.font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtPrenom, gridBagConstraints);

		lblNom = new JLabel("Nom");
		lblNom.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblNom, gridBagConstraints);

		txtNom = new JTextField();
		txtNom.setFont(Global.font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtNom, gridBagConstraints);

		lblNaissance = new JLabel("Naissance (jj/mm/aaaa)");
		lblNaissance.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblNaissance, gridBagConstraints);

		cmbNaissanceJour = new JComboBox<Integer>();
		for (int i = 1; i <= 31; ++i) {
			cmbNaissanceJour.addItem(i);
		}
		cmbNaissanceJour.setFont(Global.font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(cmbNaissanceJour, gridBagConstraints);

		cmbNaissanceMois = new JComboBox<Integer>();
		for (int i = 1; i <= 12; ++i) {
			cmbNaissanceMois.addItem(i);
		}
		cmbNaissanceMois.setFont(Global.font);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(cmbNaissanceMois, gridBagConstraints);

		cmbNaissanceAnnee = new JComboBox<Integer>();
		for (int i = 2019; i > 1920; --i) {
			cmbNaissanceAnnee.addItem(i);
		}
		cmbNaissanceAnnee.setFont(Global.font);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(cmbNaissanceAnnee, gridBagConstraints);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.setLocation(getLocation());
				mainFrame.setExtendedState(getExtendedState());
				mainFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnCancel, gridBagConstraints);

		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(Global.font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.gridheight = 1;
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtNom.getText().equals(txtNom.getText().toUpperCase())) {
					txtNom.setText(txtNom.getText().toUpperCase());
				}
				Eleve eleve = new Eleve(txtPrenom.getText(), txtNom.getText(), (int) cmbNaissanceJour.getSelectedItem(),
						(int) cmbNaissanceMois.getSelectedItem(), (int) cmbNaissanceAnnee.getSelectedItem());
				Global.eleves.add(eleve);
				MainFrame mainFrame = new MainFrame();
				mainFrame.setLocation(getLocation());
				mainFrame.setExtendedState(getExtendedState());
				mainFrame.setVisible(true);
				dispose();
				UIManager.put("OptionPane.messageFont", Global.font);
				UIManager.put("OptionPane.buttonFont", Global.font);
				JOptionPane.showMessageDialog(contentPane, "Add success!");
//				String prenom = txtPrenom.getText();
//				String nom = txtNom.getText();
//				if (!prenom.equals("") && !nom.equals("")) {
//					professeurs.add(new Professeur(prenom, nom));
//					DataSaving.saveProfesseur("res/csv/professeurs.csv", professeurs);
//				}
			}
		});
		contentPane.add(btnConfirm, gridBagConstraints);

	}
}
