package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import utils.Global;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")

public class AddProfesseurFrame extends JFrame {

	private JPanel contentPane;
	private GridBagConstraints gridBagConstraints;
	private JLabel lblTitle;
	private JLabel lblPrenom;
	private JTextField txtPrenom;
	private JLabel lblNom;
	private JTextField txtNom;
	private JButton btnCancel;
	private JButton btnConfirm;

	public AddProfesseurFrame() {

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

		lblTitle = new JLabel("Professeur", JLabel.CENTER);
		lblTitle.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
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
		gridBagConstraints.gridwidth = 1;
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
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtNom, gridBagConstraints);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
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
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame(); 
				mainFrame.setLocation(getLocation());
				mainFrame.setExtendedState(getExtendedState());
				mainFrame.setVisible(true);
				dispose();
				UIManager.put("OptionPane.messageFont", Global.font);
				UIManager.put("OptionPane.buttonFont", Global.font);
				JOptionPane.showMessageDialog(contentPane, "Add success!");
			}
		});
		contentPane.add(btnConfirm, gridBagConstraints);

	}

}
