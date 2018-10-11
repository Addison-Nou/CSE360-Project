import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Input", null, panel, null);
		panel.setLayout(null);
		
		JButton button = new JButton("Help");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    //this is the button(action) that corresponds with the "Help" Button 
			}                                                 //TODO add page for help section as the button action
		});
		button.setFont(new Font("Tahoma", Font.ITALIC, 12));
		button.setBounds(295, 1, 62, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("About");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    //this is the button(action) that corresponds with the "About" Button 
			}                                                 //TODO add page for about section as the button action
		});
		button_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		button_1.setBounds(357, 1, 72, 23);
		panel.add(button_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(203, 51, 170, 136);
		panel.add(textArea_2);
		
		JScrollBar scrollBar_3 = new JScrollBar();
		scrollBar_3.setBounds(375, 51, 17, 136);
		panel.add(scrollBar_3);
		
		JLabel lblActivityName = new JLabel("Activity Name");
		lblActivityName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblActivityName.setBounds(10, 28, 98, 14);
		panel.add(lblActivityName);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(10, 51, 158, 22);
		panel.add(textArea_3);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDuration.setBounds(10, 84, 98, 14);
		panel.add(lblDuration);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(10, 108, 158, 22);
		panel.add(textArea_4);
		
		JButton btnProcess = new JButton("PROCESS");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {    //this is the button(action) that corresponds with the "PROCESS" Button 
			}
		});
		btnProcess.setHorizontalAlignment(SwingConstants.LEFT);
		btnProcess.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcess.setBounds(10, 154, 95, 23);
		panel.add(btnProcess);
		
		JButton btnAddNewPredecessors = new JButton("Add New Predecessors");
		btnAddNewPredecessors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {      //this is the button(action) that corresponds with the "Add new Predecessor" Button
			}
		});
		btnAddNewPredecessors.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddNewPredecessors.setBounds(203, 199, 170, 23);
		panel.add(btnAddNewPredecessors);
		
		JLabel lblPredecessorList = new JLabel("Predecessor List");
		lblPredecessorList.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPredecessorList.setBounds(204, 35, 114, 14);
		panel.add(lblPredecessorList);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {     //this is the button(action) that corresponds with the "RESTART" Button 
			}
		});
		btnRestart.setHorizontalAlignment(SwingConstants.LEFT);
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRestart.setBounds(10, 187, 97, 23);
		panel.add(btnRestart);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Output", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblActivityList = new JLabel("Activity List");
		lblActivityList.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblActivityList.setBounds(10, 36, 108, 24);
		panel_1.add(lblActivityList);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 61, 178, 146);
		panel_1.add(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(188, 61, 17, 153);
		panel_1.add(scrollBar);
		
		JLabel lblAc = new JLabel("Activity Diagram");
		lblAc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAc.setBounds(226, 36, 125, 22);
		panel_1.add(lblAc);
		
		JButton btnNewButton = new JButton("Help");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {      //this is the button(action) that corresponds with the "Help" Button
			}                                                 //TODO add page for help section as the button action
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnNewButton.setBounds(295, -1, 62, 23);
		panel_1.add(btnNewButton);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {      //this is the button(action) that corresponds with the "About" Button
			}                                                 //TODO add page for about section as the button action
		});
		btnAbout.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnAbout.setBounds(357, -1, 72, 23);
		panel_1.add(btnAbout);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(215, 61, 178, 146);
		panel_1.add(textArea_1);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(391, 61, 17, 153);
		panel_1.add(scrollBar_1);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_2.setBounds(215, 208, 178, 14);
		panel_1.add(scrollBar_2);
	}
}
