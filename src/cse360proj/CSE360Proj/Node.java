package cse360proj.CSE360Proj;

import java.util.ArrayList;

public class Node {

	String name;
	int duration;
	ArrayList<String> dependencies = new ArrayList<String>();
	
	public Node() {
		this.name = "";
		this.duration = 0;
		this.dependencies = new ArrayList<String>();
	}
	
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
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setDependencies(ArrayList<String> dependencies) {
		this.dependencies = dependencies;
	}
	
	public void addDependencies(String dependency) {
		this.dependencies.add(dependency);
	}

}
