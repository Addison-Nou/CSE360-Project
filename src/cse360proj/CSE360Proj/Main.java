package cse360proj.CSE360Proj;

import java.awt.EventQueue;

public class Main {
	
    public static void main(String[] args) {
    	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmCseProject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}