package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import utils.Global;

@SuppressWarnings("serial")
public class AddEvaluationFrame extends JFrame {

	private JPanel contentPane;
	private GridBagConstraints gridBagConstraints;
	private JLabel lblTitle;
	private JLabel lblPromotion;
	private JTextField txtPromotion;
	private JLabel lblEleveNumeroID;
	private JTextField txtEleveNumeroID;
	private JLabel lblMatiereConcernee;
	private JTextField txtMatiereConcernee;
	private JLabel lblNote;
	private JTextField txtNote;
	private JLabel lblProfesseurPrenom;
	private JTextField txtProfesseurPrenom;
	private JLabel lblProfesseurNom;
	private JTextField txtProfesseurNom;
	private JButton btnCancel;
	private JButton btnConfirm;

	public AddEvaluationFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		setContentPane(contentPane);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.ipadx = 100;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.insets = new Insets(20, 20, 20, 20);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		
		lblTitle = new JLabel("Evaluation", JLabel.CENTER);
		lblTitle.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblTitle, gridBagConstraints);

		lblPromotion = new JLabel("Promotion");
		lblPromotion.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblPromotion, gridBagConstraints);
		
		txtPromotion = new JTextField();
		txtPromotion.setFont(Global.font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtPromotion, gridBagConstraints);
		
		lblEleveNumeroID = new JLabel("EleveNumeroID");
		lblEleveNumeroID.setFont(Global.font);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblEleveNumeroID, gridBagConstraints);

		txtEleveNumeroID = new JTextField();
		txtEleveNumeroID.setFont(Global.font);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtEleveNumeroID, gridBagConstraints);
		
		lblMatiereConcernee = new JLabel("MatiereConcernee");
		lblMatiereConcernee.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblMatiereConcernee, gridBagConstraints);

		txtMatiereConcernee = new JTextField();
		txtMatiereConcernee.setFont(Global.font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtMatiereConcernee, gridBagConstraints);
		
		lblNote = new JLabel("Note");
		lblNote.setFont(Global.font);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblNote, gridBagConstraints);

		txtNote = new JTextField();
		txtNote.setFont(Global.font);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtNote, gridBagConstraints);
		
		lblProfesseurPrenom = new JLabel("ProfesseurPrenom");
		lblProfesseurPrenom.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblProfesseurPrenom, gridBagConstraints);

		txtProfesseurPrenom = new JTextField();
		txtProfesseurPrenom.setFont(Global.font);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtProfesseurPrenom, gridBagConstraints);
		
		lblProfesseurNom = new JLabel("ProfesseurNom");
		lblProfesseurNom.setFont(Global.font);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(lblProfesseurNom, gridBagConstraints);

		txtProfesseurNom = new JTextField();
		txtProfesseurNom.setFont(Global.font);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		contentPane.add(txtProfesseurNom, gridBagConstraints);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(Global.font);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
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
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
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
