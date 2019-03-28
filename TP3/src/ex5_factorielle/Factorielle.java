package ex5_factorielle;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Factorielle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btn;
	private JLabel lbl;

	public Factorielle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (textField.getText().isEmpty()) {
					textField.setForeground(Color.LIGHT_GRAY);
					textField.setText("Num : ___");
				} else {
					if (textField.getText().matches("[0-9]*")) {
						int num = Integer.parseInt(textField.getText());
						if (btn != null && num >= 1) {
							if (num < 17) {
								btn.setText(num + "!");
								btn.repaint();
							}
						}
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				textField.setForeground(Color.BLACK);
				if (textField.getText().equals("Num : ___")) {
					textField.setText("");
				}
			}
		});
		contentPane.add(textField, BorderLayout.WEST);
		textField.setColumns(10);

		btn = new JButton("num!");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().matches("[0-9]*")) {
					int num = Integer.parseInt(textField.getText());
					if (num < 17) {
						btn.setText(num + "!");
						btn.repaint();
					}
					if (btn != null && num >= 1) {
						if (num < 17) {
							int result=1;
							for (int i = 1; i <= num; i++) {
								result *= i;
							}
							lbl.setText(num+"! = "+result);
						} else {
							textField.setText(JOptionPane.showInputDialog("num (num < 17) : "));
							if (num < 17) {
								btn.setText(num + "!");
								btn.repaint();
							}
						}
					}
				}
			}
		});
		contentPane.add(btn, BorderLayout.CENTER);

		lbl = new JLabel("");
		contentPane.add(lbl, BorderLayout.EAST);
	}

}
