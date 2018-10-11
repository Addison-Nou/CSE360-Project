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

public class GUI {

	private JFrame frmCseProject;
	private JTextField textField;

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
		
		JButton button = new JButton("Help");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {         //this is the button(action) that corresponds with the "Help" Button 
				JOptionPane.showMessageDialog(null, "Popup");    //Creates Pop-up with text
			}                                                    //TODO add filler text to the Pop-up as the button action
		});
		button.setFont(new Font("Tahoma", Font.ITALIC, 12));
		button.setBounds(564, 1, 62, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("About");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {         //this is the button(action) that corresponds with the "About" Button
				JOptionPane.showMessageDialog(null, "Popup");    //Creates Pop-up with text
			}                                                    //TODO add filler text to the Pop-up as the button action
		});
		button_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		button_1.setBounds(627, 1, 72, 23);
		panel.add(button_1);
		
		JLabel lblActivityName = new JLabel("Activity Name");
		lblActivityName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblActivityName.setBounds(80, 40, 100, 25);
		panel.add(lblActivityName);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(80, 70, 150, 25);
		panel.add(textArea_3);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDuration.setBounds(80, 120, 100, 25);
		panel.add(lblDuration);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(80, 150, 150, 25);
		panel.add(textArea_4);
		
		JButton btnProcess = new JButton("PROCESS");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {    //this is the button(action) that corresponds with the "PROCESS" Button 
			}
		});
		btnProcess.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProcess.setBounds(220, 325, 110, 35);
		panel.add(btnProcess);
		
		JButton btnAddNewPredecessors = new JButton("Add Predecessor");
		btnAddNewPredecessors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {      //this is the button(action) that corresponds with the "Add Predecessor" Button
			}
		});
		btnAddNewPredecessors.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddNewPredecessors.setBounds(420, 150, 170, 25);
		panel.add(btnAddNewPredecessors);
		
		JLabel lblPredecessorList = new JLabel("Predecessor");
		lblPredecessorList.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPredecessorList.setBounds(420, 70, 120, 25);
		panel.add(lblPredecessorList);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {     //this is the button(action) that corresponds with the "RESTART" Button 
			}
		});
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRestart.setBounds(400, 325, 110, 35);
		panel.add(btnRestart);
		
		textField = new JTextField();
		textField.setBounds(420, 100, 200, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Node");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {      //this is the button(action) that corresponds with the "Add Node" Button
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(80, 200, 150, 25);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Output", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(80, 100, 480, 240);
		panel_1.add(scrollPane);
		
		JLabel lblActivityList = new JLabel("Activity List");
		lblActivityList.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblActivityList.setBounds(80, 75, 100, 25);
		panel_1.add(lblActivityList);
		
		JButton btnNewButton = new JButton("Help");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {         //this is the button(action) that corresponds with the "Help" Button
				JOptionPane.showMessageDialog(null, "Popup");    //Creates Pop-up with text
			}                                                    //TODO add filler text to the Pop-up as the button action
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnNewButton.setBounds(565, -1, 62, 23);
		panel_1.add(btnNewButton);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {         //this is the button(action) that corresponds with the "About" Button
				JOptionPane.showMessageDialog(null, "Popup");    //Creates Pop-up with text
			}                                                    //TODO add filler text to the Pop-up as the button action
		});
		btnAbout.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnAbout.setBounds(627, -1, 72, 23);
		panel_1.add(btnAbout);
	}
}
