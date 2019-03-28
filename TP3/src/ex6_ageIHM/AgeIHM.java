package ex6_ageIHM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ex6_calculage.Calculage;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AgeIHM extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldNaissance;
	private JPanel panelVert;
	private JPanel panelNom;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JPanel panelNaissance;
	private JLabel lblNaissance;
	private JPanel panelCyan;
	private JTextField textFieldAge;
	private JPanel panelJaune;
	private JButton btnAge;
	private JButton btnReverse;

	public AgeIHM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));

		panelVert = new JPanel();
		panelVert.setBackground(Color.GREEN);
		contentPane.add(panelVert);
		panelVert.setLayout(new GridLayout(0, 1, 0, 0));

		panelNom = new JPanel();
		panelNom.setBackground(Color.GREEN);
		panelVert.add(panelNom);
		panelNom.setLayout(new GridLayout(2, 2, 0, 0));

		lblNom = new JLabel("Votre nom :");
		lblNom.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelNom.add(lblNom);

		textFieldNom = new JTextField();
		panelNom.add(textFieldNom);
		textFieldNom.setColumns(10);

		lblPrenom = new JLabel("Votre pr¨¦nom :");
		lblPrenom.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelNom.add(lblPrenom);

		textFieldPrenom = new JTextField();
		panelNom.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);

		panelNaissance = new JPanel();
		panelNaissance.setBackground(Color.GREEN);
		panelVert.add(panelNaissance);

		lblNaissance = new JLabel("Votre ann¨¦e de naissance :");
		lblNaissance.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelNaissance.add(lblNaissance);

		textFieldNaissance = new JTextField();
		panelNaissance.add(textFieldNaissance);
		textFieldNaissance.setColumns(10);

		panelCyan = new JPanel();
		panelCyan.setBackground(Color.CYAN);
		contentPane.add(panelCyan);
		panelCyan.setLayout(new GridLayout(1, 1, 0, 0));

		textFieldAge = new JTextField("");
		textFieldAge.setBackground(Color.CYAN);
		textFieldAge.setEditable(false);
		textFieldAge.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelCyan.add(textFieldAge);

		panelJaune = new JPanel();
		panelJaune.setBackground(Color.YELLOW);
		contentPane.add(panelJaune);
		panelJaune.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAge = new JButton("Age?");
		btnAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textFieldNaissance.getText().isEmpty() && textFieldNaissance.getText().matches("[0-9]*")) {
					textFieldAge.setText("En " + Calendar.getInstance().get(Calendar.YEAR) + " vous avez "
							+ Calculage.calculAge(Integer.parseInt(textFieldNaissance.getText())) + " ans.");
				} else {
					textFieldAge.setText("Votre ann¨¦e de naissance ?");
				}
			}
		});
		btnAge.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelJaune.add(btnAge);

		btnReverse = new JButton("Reverse");
		btnReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNom.setText(new StringBuffer(textFieldNom.getText()).reverse().toString());
				textFieldPrenom.setText(new StringBuffer(textFieldPrenom.getText()).reverse().toString());
				textFieldNaissance.setText(new StringBuffer(textFieldNaissance.getText()).reverse().toString());
			}
		});
		btnReverse.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelJaune.add(btnReverse);
	}

}
