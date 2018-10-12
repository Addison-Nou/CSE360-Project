package cse360proj.CSE360Proj;

import java.util.ArrayList;

public class Node {

	String name;
	int duration;
	ArrayList<String> dependencies;
	ArrayList<Node> dependents;
	
	public Node() {
		this.name = "";
		this.duration = 0;
		this.dependencies = new ArrayList<String>();
		this.dependents = new ArrayList<Node>();
	}
	
	public Node(String name, int duration, ArrayList<String> dependencies, ArrayList<Node> dependents) {
		this.name = name;
		this.duration = duration;
		this.dependencies = dependencies;
		this.dependents = dependents;
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
	
	public ArrayList<Node> getDependents() {
		return dependents;
	}
	
	//Setters
	public void clearDependencies() {
		this.dependencies.clear();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setDependencies(ArrayList<String> dependencies) {
		this.dependencies.clear();
		for(int i=0; i<dependencies.size(); i++) {
			this.dependencies.add(dependencies.get(i));
		}
	}
	
	public void addDependencies(String dependencies) {
		this.dependencies.add(dependencies);
	}
	
	public void addDependent(Node dependent) {
		this.dependents.add(dependent);
	}
}
