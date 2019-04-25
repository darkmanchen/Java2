package ui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

@SuppressWarnings("serial")

public class AddEleveFrame extends JFrame {

	private JPanel contentPane;
	private GridBagConstraints gridBagConstraints;
	private Font font;
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

		font = new Font("TimesRoman", Font.PLAIN, 40);

		lblTitle = new JLabel("Eleve", JLabel.CENTER);
		lblTitle.setFont(font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 4;
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
		gridBagConstraints.gridwidth = 3;
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
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtNom, gridBagConstraints);

		lblNaissance = new JLabel("Naissance (jj/mm/aaaa)");
		lblNaissance.setFont(font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblNaissance, gridBagConstraints);

		cmbNaissanceJour = new JComboBox<Integer>();
		for (int i = 1; i <= 31; ++i) {
			cmbNaissanceJour.addItem(i);
		}
		cmbNaissanceJour.setFont(font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(cmbNaissanceJour, gridBagConstraints);

		cmbNaissanceMois = new JComboBox<Integer>();
		for (int i = 1; i <= 12; ++i) {
			cmbNaissanceMois.addItem(i);
		}
		cmbNaissanceMois.setFont(font);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(cmbNaissanceMois, gridBagConstraints);

		cmbNaissanceAnnee = new JComboBox<Integer>();
		for (int i = 2019; i > 1920; --i) {
			cmbNaissanceAnnee.addItem(i);
		}
		cmbNaissanceAnnee.setFont(font);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(cmbNaissanceAnnee, gridBagConstraints);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
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
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.gridheight = 1;
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println();
				if (!txtNom.getText().equals(txtNom.getText().toUpperCase())) {
					txtNom.setText(txtNom.getText().toUpperCase());
				}
								
				MainFrame mainFrame = new MainFrame(); 
				mainFrame.setVisible(true);
				dispose();
				UIManager.put("OptionPane.messageFont", font);
				UIManager.put("OptionPane.buttonFont", font);
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
