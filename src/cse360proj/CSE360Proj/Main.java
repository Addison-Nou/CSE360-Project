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
    			
    			//System.out.println("Names: " + A);
    			//System.out.println("Durations: " + B);
    			Node head = SearchForHead(N);
    			Node inPath = SearchForDependencies(N, head.getName());
    	    	System.out.println("Head: " + head.getName());
    	    	System.out.println("In Path: " + inPath.getName());
    			return;
    		} else s.nextLine();
    		
    	}
    	s.close();
    }
    
    public static Node SearchForHead(ArrayList<Node> list) {
    	
    	Node head = new Node();
    	
    	for(int i=0; i<list.size(); i++) {
    		
    		if(list.get(i).getDependencies().isEmpty()) {
    			head = list.get(i);
    			return head;
    		}
    	}
    	
    	return head;
    }
    
    public static Node SearchForDependencies(ArrayList<Node> list, String dependency) {
    	
    	Node temp = new Node();
    	
		for(int i=0; i<list.size(); i++) {
			
			ArrayList<String> tmp = list.get(i).getDependencies();
		    if(tmp.contains(dependency)) {
		    	temp = list.get(i);
		    }
    	}
		
		return temp;
    }
    
}