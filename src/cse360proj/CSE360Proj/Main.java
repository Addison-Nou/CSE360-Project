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
    	
    	String output;
    	boolean cont = true;
    	
    	ArrayList<String> A = new ArrayList<String>();
    	ArrayList<Integer> B = new ArrayList<Integer>();
    	
    	ArrayList<Node> N = new ArrayList<Node>();
    	ArrayList<String> dependencies = new ArrayList<String>();
    	
    	//1 to continue, 2 to exit
        
    	while (cont) {
    		if (!dependencies.isEmpty()) dependencies.clear();
    		
    		System.out.print("Please enter a name: ");
    		name = s.nextLine();

    		System.out.print("Please enter a duration: ");
    		duration = s.nextInt();
    		
    		System.out.print("Please enter any dependencies ('e' to quit): ");
    		temp = s.next();
    		
    		while (!temp.equals("potato")) {
    			dependencies.add(temp);
    			System.out.println("Current dependencies: " + dependencies);
        		temp = s.next();
    		}
    		
    		System.out.println("\nName: " + name);
    		System.out.println("Duration: " + duration);
    		System.out.println("Dependencies: " + dependencies);
    		
    		//Add data to array
    		A.add(name);
    		B.add(duration);
    		
    		//Add data to node and add new node to ArrayList
    		N.add(new Node(name, duration, dependencies));
    		
    		//Check for continue
    		System.out.println("Do you wish to continue? 1 for yes 2 for no");
    		if (s.nextInt() == 2) {
    			
    			//System.out.println("Names: " + A);
    			//System.out.println("Durations: " + B);
    			
    			return;
    		} else s.nextLine();
    	}
    }
    
}