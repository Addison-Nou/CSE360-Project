package cse360proj.CSE360Proj;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class GUI {

	JFrame frmCseProject;
	private JTextField PredecessorField;
	private JTextField ActivityField;
	private JTextField DurationField;
	ArrayList<Node> Nodelist = new ArrayList<Node>();
	ArrayList<ArrayList<Path>> finalPaths = new ArrayList<ArrayList<Path>>();

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
		
		Node holder = new Node();
		
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
		
		JLabel error = new JLabel("");
		error.setFont(new Font("Tahoma", Font.BOLD, 13));
		error.setForeground(Color.RED);
		error.setBounds(250, 300, 400, 20);
		panel.add(error);
		
		JLabel lblActivityName = new JLabel("Activity Name");
		lblActivityName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblActivityName.setBounds(80, 40, 200, 25);
		panel.add(lblActivityName);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDuration.setBounds(80, 120, 200, 25);
		panel.add(lblDuration);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Output", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 100, 520, 240);
		panel_1.add(scrollPane);
		
		JTextArea ListArea = new JTextArea();
		scrollPane.setViewportView(ListArea);
		ListArea.setEditable(false);
		ListArea.append(null); 										//This line is for outputting to the ListArea
		
		//----------Process Button------------\\
		
		JButton btnProcess = new JButton("PROCESS");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			//this is the button(action) that corresponds with the "PROCESS" Button 
				
    			//Give dependents to all nodes in nodelist
    			for (int i = 0; i < Nodelist.size(); i++) {
    				Node node = Nodelist.get(i);
    				for (int j = 0; j < Nodelist.size(); j++) {
    					//If the node's dependencies contains 
    					if (node.getDependencies().contains(Nodelist.get(j).getName())) {
    						System.out.println("Node dependency added to " + Nodelist.get(j).getName());
    						Nodelist.get(j).addDependent(node);
    						//System.out.println("Node " + N.get(j).getName() + "'s new dependent list: " + N.get(j).getDependents());
    					}
    				}
    			}
    			
    			//Checking for loops
    			//Check the entire nodelist
    			for (int i = 0; i < Nodelist.size(); i++) {
    				
    				Node node = Nodelist.get(i);
    				
    				for (int j = i+1; j < Nodelist.size(); j++) {
    					if (node.getDependencies().contains(Nodelist.get(j).getName())) {
    						
    						if (Nodelist.get(j).getDependencies().contains(node.getName())) {
    							error.setText("Error: Loop occured at nodes " + node.getName() + " and " + Nodelist.get(j).getName());
    							System.out.println("Error: Loop occured at nodes " + node.getName() + " and " + Nodelist.get(j).getName());
    						}
    						
    					}
    				}
    			}
    			//If two nodes have dependencies of each other
    			//print out error
    			
    			//Search for head nodes
    			ArrayList<Node> heads = SearchForHeads(Nodelist);
    			boolean noFloatingNodes = true;
    			
    			for (Node headCheck : heads) {
    				if (headCheck.getDependents().isEmpty())
    					noFloatingNodes = false;
    			}
    			
    			if (noFloatingNodes) {
	    			for (Node head : heads) {
	    				System.out.println("Looking at head: " + head.getName());
	    				
	    				Path visitedNodes = new Path();
	    				
	    				visitedNodes.addPath(head);
	    				
	    				ArrayList<Path> finalPath = new ArrayList<Path>();
	    				
	    				FindPaths(head, visitedNodes, finalPath);
	    				
	    				for (int i = 0; i < finalPath.size(); i++) {
	    					finalPath.get(i).calcDuration();
	    				}
	    				
	    				finalPaths.add(finalPath);
	    			}
    				
	    			//Creating new list of paths to sort
	    			ArrayList<Path> sortedPath = new ArrayList<Path>();
	    			
        			//Organizing the paths based on duration
        			for (ArrayList<Path> finalPathArray : finalPaths) {
						System.out.println("Checking ArrayList of paths");
						
        				for (int i = 0; i < finalPathArray.size(); i++) {
        					System.out.println("Checking Path: finalPathArraySize = " + finalPathArray.size());
        					System.out.println("finalPaths = " + finalPaths.size());
        					sortedPath.add(finalPathArray.get(i));
        					/*for (int j = i+1; j < finalPathArray.size(); j++) {
        						
        						System.out.println("finalPathArray[i] = " + finalPathArray.get(i).getDuration());
        						System.out.println("finalPathArray[j] = " + finalPathArray.get(j).getDuration());
        						
        						if (finalPathArray.get(i).getDuration() < finalPathArray.get(j).getDuration()) {
        							Path temp = new Path();
        							temp.setDuration(finalPathArray.get(i).getDuration());
        							temp.setPath(finalPathArray.get(i).getPath());
        							
        							finalPathArray.get(i).setPath(finalPathArray.get(j).getPath());
        							finalPathArray.get(i).setDuration(finalPathArray.get(j).getDuration());
        							
        							finalPathArray.get(j).setPath(temp.getPath());
        							finalPathArray.get(j).setDuration(temp.getDuration());
        						}
        						
        					}*/
        				}
        			}
        			
        			for (int i = 0; i < sortedPath.size(); i++) {
        				for (int j = i+1; j < sortedPath.size(); j++) {
    						if (sortedPath.get(i).getDuration() < sortedPath.get(j).getDuration()) {
            					System.out.println("Path " + sortedPath.get(i) + " (duration = " + sortedPath.get(i).getDuration() + ") is less than path " + sortedPath.get(j) + " (duration = " + sortedPath.get(j).getDuration() + ")");
    							
            					Path temp = new Path();
    							temp.setDuration(sortedPath.get(i).getDuration());
    							temp.setPath(sortedPath.get(i).getPath());
    							
    							sortedPath.get(i).setPath(sortedPath.get(j).getPath());
    							sortedPath.get(i).setDuration(sortedPath.get(j).getDuration());
    							
    							sortedPath.get(j).setPath(temp.getPath());
    							sortedPath.get(j).setDuration(temp.getDuration());
    						} else {
            					System.out.println("Path " + sortedPath.get(i) + " (duration = " + sortedPath.get(i).getDuration() + ") is more than path " + sortedPath.get(j) + " (duration = " + sortedPath.get(j).getDuration() + ")");
    						}
        				}
        			}
        			
        			//Outputting paths to console
        			System.out.println("Paths: ");
        			/*
        			for (ArrayList<Path> finalPathArray : finalPaths) {
        				for (Path finalPath : finalPathArray) {
        					System.out.println(finalPath.getPath());
        					System.out.println("Duration: " + finalPath.getDuration());
        				}
        			}*/
        			System.out.println("Paths: ");
        			for (Path path : sortedPath) {
        				System.out.println(path.getDuration());
        			}
        			
        			//Clear output before writing to it
        			ListArea.setText("");
        			
        			/*
        			//Outputting paths to Output
        			for (ArrayList<Path> finalPathArray : finalPaths) {
        				for (Path finalPath : finalPathArray) {
        					ListArea.append("[");
        					for (int i = 0; i < finalPath.getPath().size(); i++) {
        						ListArea.append(finalPath.getPath().get(i).getName());
        						if (!(i == finalPath.getPath().size()-1))
        							ListArea.append(", ");
        					}
        					ListArea.append("]");
        					ListArea.append("\tDuration: " + finalPath.getDuration() + "\n");
        				}
        			}*/
        			
        			for (Path finalPath : sortedPath) {
    					ListArea.append("[");
    					for (int i = 0; i < finalPath.getPath().size(); i++) {
    						ListArea.append(finalPath.getPath().get(i).getName());
    						if (!(i == finalPath.getPath().size()-1))
    							ListArea.append(", ");
    					}
    					ListArea.append("]");
    					ListArea.append("\tDuration: " + finalPath.getDuration() + "\n");
    				}
        			
    				Nodelist.clear();
    				PredecessorField.setText("");
    				ActivityField.setText("");
    				DurationField.setText("");
    				for(int i = 0; i < finalPaths.size(); i++) {
    					finalPaths.get(i).clear();
    				}
    				finalPaths.clear();
    			} else {
    				error.setText("Error: You have detached nodes!");
    				Nodelist.clear();
    				PredecessorField.setText("");
    				ActivityField.setText("");
    				DurationField.setText("");
    				ListArea.setText("");
    				for(int i = 0; i < finalPaths.size(); i++) {
    					finalPaths.get(i).clear();
    				}
    				finalPaths.clear();
    				noFloatingNodes = true;
    			}
			}
		});
		btnProcess.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProcess.setBounds(200, 325, 150, 35);
		panel.add(btnProcess);
		
		JButton btnAddNewPredecessors = new JButton("Add Predecessor");
		btnAddNewPredecessors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//this is the button(action) that corresponds with the "Add Predecessor" Button
				
				holder.addDependencies(PredecessorField.getText());
				PredecessorField.setText("");
				
			}
		});
		btnAddNewPredecessors.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddNewPredecessors.setBounds(420, 150, 200, 25);
		panel.add(btnAddNewPredecessors);
		
		JLabel lblPredecessorList = new JLabel("Predecessor");
		lblPredecessorList.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPredecessorList.setBounds(420, 70, 200, 25);
		panel.add(lblPredecessorList);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			//this is the button(action) that corresponds with the "RESTART" Button 
				Nodelist.clear();
				ListArea.setText("");
				PredecessorField.setText("");
				ActivityField.setText("");
				DurationField.setText("");
				error.setText("");
				for(int i = 0; i < finalPaths.size(); i++) {
					finalPaths.get(i).clear();
				}
				finalPaths.clear();
			}
		});
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRestart.setBounds(400, 325, 150, 35);
		panel.add(btnRestart);
		
		PredecessorField = new JTextField();
		PredecessorField.setBounds(420, 100, 200, 25);
		panel.add(PredecessorField);
		PredecessorField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Node");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			//this is the button(action) that corresponds with the "Add Node" Button
				
				if (isInteger(DurationField.getText())) {	//Check if text in DurationField is an integer
					if (!ActivityField.getText().isEmpty()) {	//Checks to see if name field is empty
						Node clone = new Node();
						clone.setName(ActivityField.getText());
						clone.setDuration(Integer.parseInt(DurationField.getText()));
						clone.setDependencies(holder.getDependencies());
						System.out.println("Clone dependencies: " + clone.getDependencies());
						ActivityField.setText("");
						DurationField.setText("");
						Nodelist.add(clone);
						System.out.println(Nodelist.get(Nodelist.size()-1).getDependencies());
						holder.clearDependencies();
						holder.setDuration(0);
						holder.setName(null);
						error.setText("");
					} else {
						error.setText("Error: Please input a name for the node");
					}
				} else {
					error.setText("Error: Duration is not an integer");
					System.out.println("Error: Duration is not an integer");
				}
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
						+ "The \"Add Predecessor\" button adds a predecessor to the current node\n"
						+ "The \"Add Node\" button  takes the Activity Name and Duration and creates a new node\n"
						+ "The \"Process\" button creates paths based on existing nodes\n"
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
		
		
	}
	
    public static void FindPaths(Node nodeDependents, Path visitedNodes, ArrayList<Path> finalPaths) {
    	
    	//System.out.println("Running FindPaths");
    	//Look at the node's dependents
    	ArrayList<Node> dependents = nodeDependents.getDependents();
    	//System.out.println("Dependents of nodeDependent: " + nodeDependents.getDependents());
    	
    	//Check each dependent in the dependents nodelist and see if it matches our visited Nodes
    	
    	//For each 'dependent' node in 'dependents' nodelist
    	for (Node dependent : dependents) {
    		//System.out.println("Looking at: " + nodeDependents.getName() + "'s dependent" + dependent.getName());
    		
    		//Get the dependencies of the 'dependent' node
    		ArrayList<String> dependencies = dependent.getDependencies();
    		
    		//For each dependency, check to see if it's contained in the dependency string list
    		for (String d : dependencies) {
    			
        		//If one of the node's dependencies don't match our previously visited nodes, then continue checking the dependents for their dependencies
        		if (!visitedNodes.getPath().contains(d)) {
        			continue;
        		}
    		}
    		
    		//If all the nodes match, then clone the path and insert the node into the visitedNodes for recursive use
    		ArrayList<Node> clone = (ArrayList<Node>) visitedNodes.getPath().clone();	//cloning the path
    		clone.add(dependent);	//adding the path to the clone
    		Path newPath = new Path(clone, 0);	//Creating new path to use for recursion
    		
    		//Recursively call the function to check the added node's dependents against the new visitedNodes' path
    		FindPaths(dependent, newPath, finalPaths);
    		
    	}
    	
    	//If there are no dependents, then the path has ended. Add the path to the final Path list
    	if (dependents.size() == 0) {
    		finalPaths.add(visitedNodes);
    	}
    }
    
    public static ArrayList<Node> SearchForHeads(ArrayList<Node> list) {
    	
    	ArrayList<Node> heads = new ArrayList<Node>();
    	
    	//Iterate through the ArrayList of all nodes
    	for(int i=0; i<list.size(); i++) {
    		
    		//If the dependency of the node is empty (the node is a head), then add the node to the return arraylist
    		if(list.get(i).getDependencies().isEmpty()) {
    			heads.add(list.get(i));
    		}
    	}
    	
    	return heads;
    }
    
	public boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
