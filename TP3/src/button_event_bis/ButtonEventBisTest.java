package button_event_bis;

import java.awt.EventQueue;

public class ButtonEventBisTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonEventBisView frame = new ButtonEventBisView("ButtonEvent");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
