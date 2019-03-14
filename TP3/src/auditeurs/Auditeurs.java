package auditeurs;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class Auditeurs extends JFrame {

	private JPanel contentPane;
	private JPanel btnsPanel;

	public Auditeurs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = new JButton("BTN");
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						btnsPanel.remove(button);
						btnsPanel.revalidate();
						contentPane.repaint();
					}
				});
				btnsPanel.add(button);
				btnsPanel.revalidate();
				contentPane.repaint();
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnsPanel.removeAll();
				btnsPanel.revalidate();
			}
		});
		contentPane.add(btnReset, BorderLayout.WEST);
		contentPane.add(btnAdd, BorderLayout.EAST);
		

		btnsPanel = new JPanel();
		contentPane.add(btnsPanel, BorderLayout.SOUTH);
	}

}
