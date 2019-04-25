package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class MainFrame extends JFrame {
	
	private JPanel contentPane;
	private JButton btnAddEleve;
//	private JButton btnAddProfesseur;
	
	public MainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout());
		setContentPane(contentPane);
		
		btnAddEleve = new JButton("AddEleve");
		btnAddEleve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddEleveFrame addEleveFrame = new AddEleveFrame();
				addEleveFrame.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnAddEleve);
//		btnAddProfesseur = new JButton("AddProfesseur");
		
	}
	
}
