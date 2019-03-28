package ex4_auditeurs;

import java.awt.EventQueue;

public class AuditeursTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auditeurs frame = new Auditeurs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
