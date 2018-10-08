package cse360proj.CSE360Proj;

import java.util.ArrayList;

public class Node {

	String name;
	int duration;
	ArrayList<String> dependencies = new ArrayList<String>();
	
	public Node(String name, int duration, ArrayList<String> dependencies) {
		this.name = name;
		this.duration = duration;
		this.dependencies = dependencies;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public ArrayList<String> getDependencies() {
		return dependencies;
	}

}
