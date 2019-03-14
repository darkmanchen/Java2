package decouverte;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;

@SuppressWarnings("serial")
public class Decouverte extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtTextfield;

	public Decouverte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Button");
		btnNewButton.setToolTipText("BUTTON!!!");
		btnNewButton.setEnabled(false);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.CYAN);
		contentPane.add(btnNewButton, BorderLayout.NORTH);
		
		txtTextfield = new JTextField();
		txtTextfield.setText("TextField");
		txtTextfield.setEditable(false);
		txtTextfield.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		contentPane.add(txtTextfield, BorderLayout.CENTER);
		txtTextfield.setColumns(10);
		
		JTextArea txtrTextarea = new JTextArea();
		txtrTextarea.setText("TextArea");
		contentPane.add(txtrTextarea, BorderLayout.SOUTH);
	}

}
