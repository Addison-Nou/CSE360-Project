package cse360proj.CSE360Proj;

//import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	
    	Scanner s = new Scanner(System.in);
    	
    	//Console console = System.console();
    	//String input = console.readLine("");
    	
    	String name;
    	int duration;
    	
    	String temp = "";
    	
    	boolean cont = true;
    	
    	ArrayList<String> A = new ArrayList<String>();
    	ArrayList<Integer> B = new ArrayList<Integer>();
    	ArrayList<Node> N = new ArrayList<Node>();
    	
    	//1 to continue, 2 to exit
    	
    	while (cont) {
    		Node holder = new Node();
    		
    		System.out.print("Please enter a name: ");
    		name = s.nextLine();
    		holder.setName(name);

    		System.out.print("Please enter a duration: ");
    		duration = s.nextInt();
    		holder.setDuration(duration);
    		
    		System.out.print("Please enter any dependencies ('e' to quit): ");
    		temp = s.next();
    		
    		while (!temp.equals("e")) {
    			holder.addDependencies(temp);
    			System.out.println("Current dependencies: " + holder.getDependencies());
        		temp = s.next();
    		}
    		
    		System.out.println("\nName: " + name);
    		System.out.println("Duration: " + duration);
    		System.out.println("Dependencies: " + holder.getDependencies());
    		
    		//Add data to array
    		A.add(name);
    		B.add(duration);
    		
    		//Add data to node and add new node to ArrayList
    		N.add(holder);
    		
    		//Check for continue
    		System.out.println("Do you wish to continue? 1 for yes 2 for no");
    		if (s.nextInt() == 2) {
    			
    			//Give dependents to all nodes in nodelist
    			for (int i = 0; i < N.size(); i++) {
    				Node node = N.get(i);
    				for (int j = 0; j < N.size(); j++) {
    					//If the node's dependencies contains 
    					if (node.getDependencies().contains(N.get(j).getName())) {
    						System.out.println("Node dependency added to " + N.get(j).getName());
    						N.get(j).addDependent(node);
    						//System.out.println("Node " + N.get(j).getName() + "'s new dependent list: " + N.get(j).getDependents());
    					}
    				}
    			}
    			
    			//Search for head nodes
    			ArrayList<Node> heads = SearchForHeads(N);
    			
    			//If not continuing, then search for head node
    			//Node head = SearchForHead(N);
    			
    			//ArrayList<String> init = new ArrayList<String>();
    			
    			//Node inPath = SearchForDependencies(N, head.getName());
    			
    			//testPath = FindPath(N, head.getDependencies(), testPath, 0);
    			
				//testPathArray = FindPath(N, testPathArray, init, testPath, 1, testPathArray.size());
				
    	    	//System.out.println("Head: " + head.getName());
    	    	//System.out.println("In Path: " + inPath.getName());
    	    	
    			//System.out.println("Path: " + testPath.getPath());
    			
    			ArrayList<ArrayList<Path>> finalPaths = new ArrayList<ArrayList<Path>>();
    			
    			for (Node head : heads) {
    				System.out.println("Looking at head: " + head.getName());
    				
    				Path visitedNodes = new Path();
    				
    				visitedNodes.addPath(head.getName());
    				
    				ArrayList<Path> finalPath = new ArrayList<Path>();
    				
    				FindPaths(head, visitedNodes, finalPath);
    				
    				finalPaths.add(finalPath);
    			}
    			
    			System.out.println("Paths: ");
    			for (ArrayList<Path> finalPathArray : finalPaths) {
    				for (Path finalPath : finalPathArray) {
    					System.out.println(finalPath.getPath());
    					System.out.println("Duration: " + finalPath.getDuration());
    				}
    			}
    			
    			return;
    		} else s.nextLine();
    		
    	}
    	//Close the scanner
    	s.close();
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
    		ArrayList<String> clone = (ArrayList<String>) visitedNodes.getPath().clone();	//cloning the path
    		clone.add(dependent.getName());	//adding the path to the clone
    		Path newPath = new Path(clone, visitedNodes.getDuration() + dependent.getDuration());	//Creating new path to use for recursion
    		
    		//Recursively call the function to check the added node's dependents against the new visitedNodes' path
    		FindPaths(dependent, newPath, finalPaths);
    		
    	}
    	
    	//If there are no dependents, then the path has ended. Add the path to the final Path list
    	if (dependents.size() == 0) {
    		finalPaths.add(visitedNodes);
    	}
    }
    
    
    //------ Test functio for multi-path functions; uses ArrayList of paths as return value ------\\
    
    /*
    public static ArrayList<Path> FindPath(ArrayList<Node> list, ArrayList<Path> pathList, ArrayList<String> dependencies, Path path, int current, int pathListSize) {
		//list == the list of nodes
    	//dependencies == the dependencies we're  looking for
    	
    	//In the ArrayList of nodes, check all dependency names to see if it matches the given dependency list
    	if (current < list.size()) {
    		System.out.println("Times recursed: " + current);
    		System.out.println("Checking for dependencies: " + dependencies);
    		System.out.println("Current node dependencies: " + list.get(current).getDependencies());
    		
			if (list.get(current).getDependencies().equals(dependencies)) {	//If the current node's dependency list is equal to the given dependency list, and we haven't iterated through the entirety of the nodelist yet
				System.out.println("Dependency found: " + list.get(current).getName() + " has dependencies " + dependencies);
				//Check to see if there are multiple in the list with the same dependencies
				
				for (int i = current+1; i < list.size(); i++) {	//Iterate through the list of nodes starting from the next node
					if (list.get(i).getDependencies().equals(list.get(current).getDependencies())) {	//If there are two nodes with the same dependency
						System.out.println("Clone detected: " + list.get(i).getName() + " has the same dependencies as " + list.get(current).getName());
						Path tempPath = path;	//Clone the current path
						//tempPath.addPath(list.get(current).getName());	//Add the node name to the path
						System.out.println("Cloned Path: " + tempPath.getPath());
				    	pathList.add(tempPath);	//Add the new path to the path list
						return FindPath(list, pathList, list.get(current).getDependencies(), tempPath, current+1, pathList.size()-1);	//Call FindPath on this new path
					}
				}
				
				//dependencies.add(list.get(current).getName());	//Add the node name to the dependencies list to check
				path.addPath(list.get(current).getName());	//Add the node name to the the path
				System.out.println("Added new path node: " + list.get(current).getName());
				pathList.set(pathList.size()-1, path);	//Update the path list
				if (current+1 < list.size())
					return FindPath(list, pathList, list.get(current+1).getDependencies(), path, current+1, pathList.size()-1);	//Call it again with the current node's dependencies
			} else return FindPath(list, pathList, dependencies, path, current+1, pathList.size()-1);	//If the current node does NOT equal the dependency list, keep going
    	}
    	
		return pathList;
    }
    */
    
    /*
    //Search for the last dependency in the ArrayList of Nodes
    public static Node SearchForDependencies(ArrayList<Node> list, String dependency) {
    	
    	Node temp = new Node();
    	
    	//Iterate through the ArrayList of all nodes
		for(int i=0; i<list.size(); i++) {
			
			//Create an ArrayList of strings containing all node dependencies
			ArrayList<String> tmp = list.get(i).getDependencies();
			
			//If the ArrayList contains the dependency, then set temp equal to that node
		    if(tmp.contains(dependency)) {
		    	temp = list.get(i);
		    }
    	}
		
		return temp;
    }*/
}