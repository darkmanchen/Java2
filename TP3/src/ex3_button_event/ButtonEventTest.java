package ex3_button_event;

import java.awt.EventQueue;

public class ButtonEventTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonEventView frame = new ButtonEventView("ButtonEvent");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
