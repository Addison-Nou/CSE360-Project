import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class GUI {

	private JFrame frmCseProject;
	private JTextField PredecessorField;
	private JTextField ActivityField;
	private JTextField DurationField;

	/**
	 * Launch the application.
	 */
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
		frmCseProject = new JFrame();
		frmCseProject.setTitle("CSE 360 Project");
		frmCseProject.setBounds(100, 100, 722, 480);
		frmCseProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmCseProject.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Input", null, panel, null);
		panel.setLayout(null);
		
		JButton HelpInput = new JButton("Help");
		HelpInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {         	//this is the button(action) that corresponds with the "Help" Button 
				JOptionPane.showMessageDialog(null, 
						"\t\tHELP\t\t\n"
						+ "The Application can be exited by the red X in the upper right corner\n"
						+ "The \"Add Node\" button  takes the Activity Name and Duration and Creates a new node\n"
						+ "The \"Process\" button creates paths based on existing nodes\n"
						+ "The \"Add Predecessor\" button adds a predecessor to the current node\n"
						+ "The \"Restart\" button resets the application to a blank slate");    	//help copy pasta
			}                                                    	//TODO add filler text to the Pop-up as the button action
		});
		HelpInput.setFont(new Font("Tahoma", Font.ITALIC, 12));
		HelpInput.setBounds(564, 1, 62, 23);
		panel.add(HelpInput);
		
		JButton AboutInput = new JButton("About");
		AboutInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {         	//this is the button(action) that corresponds with the "About" Button
				JOptionPane.showMessageDialog(null, 
						"Authors: Addison Nou, Connor Weese, Muhammed Kilig, Zachary Somers\n"
						+ "This program analyzes a given network diagram and determines all paths within the network.\n"
						+ "It recieves input of Activity Name, Duration and List of Predecessors with no limit to activities or predecessors.\n"
						+ "It ouputs a list of activity paths and durations listed in descending order according to the value durations.\n"
						+ "CSE 360 Fall 2018");    	//about copy pasta
			}                                                		//TODO add filler text to the Pop-up as the button action
		});
		AboutInput.setFont(new Font("Tahoma", Font.ITALIC, 12));
		AboutInput.setBounds(627, 1, 72, 23);
		panel.add(AboutInput);
		
		JLabel lblActivityName = new JLabel("Activity Name");
		lblActivityName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblActivityName.setBounds(80, 40, 200, 25);
		panel.add(lblActivityName);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDuration.setBounds(80, 120, 200, 25);
		panel.add(lblDuration);
		
		JButton btnProcess = new JButton("PROCESS");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			//this is the button(action) that corresponds with the "PROCESS" Button 
			}
		});
		btnProcess.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProcess.setBounds(200, 325, 150, 35);
		panel.add(btnProcess);
		
		JButton btnAddNewPredecessors = new JButton("Add Predecessor");
		btnAddNewPredecessors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//this is the button(action) that corresponds with the "Add Predecessor" Button
			}
		});
		btnAddNewPredecessors.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddNewPredecessors.setBounds(420, 150, 170, 25);
		panel.add(btnAddNewPredecessors);
		
		JLabel lblPredecessorList = new JLabel("Predecessor");
		lblPredecessorList.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPredecessorList.setBounds(420, 70, 200, 25);
		panel.add(lblPredecessorList);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			//this is the button(action) that corresponds with the "RESTART" Button 
			}
		});
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRestart.setBounds(400, 325, 150, 35);
		panel.add(btnRestart);
		
		PredecessorField = new JTextField();
		PredecessorField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			// listener for event(Predecessor field)
			}
		});
		PredecessorField.setBounds(420, 100, 200, 25);
		panel.add(PredecessorField);
		PredecessorField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Node");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			//this is the button(action) that corresponds with the "Add Node" Button
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(80, 200, 150, 25);
		panel.add(btnNewButton_1);
		
		ActivityField = new JTextField();
		ActivityField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			// listener for event(Activity field)
			}
		});
		ActivityField.setBounds(80, 70, 150, 25);
		panel.add(ActivityField);
		ActivityField.setColumns(10);
		
		DurationField = new JTextField();
		DurationField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			// listener for event(Duration field)
			}
		});
		DurationField.setBounds(80, 150, 150, 25);
		panel.add(DurationField);
		DurationField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Output", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblActivityList = new JLabel("Activity List");
		lblActivityList.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblActivityList.setBounds(80, 75, 100, 25);
		panel_1.add(lblActivityList);
		
		JButton HelpOutput = new JButton("Help");
		HelpOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {         	//this is the button(action) that corresponds with the "Help" Button
				JOptionPane.showMessageDialog(null, 
						"\t\tHELP\t\t\n"
						+ "The Application can be exited by the red X in the upper right corner\n"
						+ "The \"Add Node\" button  takes the Activity Name and Duration and Creates a new node\n"
						+ "The \"Process\" button creates paths based on existing nodes\n"
						+ "The \"Add Predecessor\" button adds a predecessor to the current node\n"
						+ "The \"Restart\" button resets the application to a blank slate");    	//help copy pasta
			}                                                    	//TODO add filler text to the Pop-up as the button action
		});
		HelpOutput.setFont(new Font("Tahoma", Font.ITALIC, 12));
		HelpOutput.setBounds(565, -1, 62, 23);
		panel_1.add(HelpOutput);
		
		JButton AboutOutput = new JButton("About");
		AboutOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {         	//this is the button(action) that corresponds with the "About" Button
				JOptionPane.showMessageDialog(null, 
						"Authors: Addison Nou, Connor Weese, Muhammed Kilig, Zachary Somers\n"
						+ "This program analyzes a given network diagram and determines all paths within the network.\n"
						+ "It recieves input of Activity Name, Duration and List of Predecessors with no limit to activities or predecessors.\n"
						+ "It ouputs a list of activity paths and durations listed in descending order according to the value durations.\n"
						+ "CSE 360 Fall 2018");    	//about copy pasta
			}                                                    	//TODO add filler text to the Pop-up as the button action
		});
		AboutOutput.setFont(new Font("Tahoma", Font.ITALIC, 12));
		AboutOutput.setBounds(627, -1, 72, 23);
		panel_1.add(AboutOutput);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 100, 520, 240);
		panel_1.add(scrollPane);
		
		JTextArea ListArea = new JTextArea();
		scrollPane.setViewportView(ListArea);
		ListArea.setEditable(false);
		ListArea.append(null); 										//This line is for outputtin to the ListArea
	}
}
