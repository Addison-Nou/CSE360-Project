package cse360proj.CSE360Proj;

import java.util.ArrayList;

public class Path {
	
	ArrayList<Node> Path;
	int PathDuration;
	
	public Path() {
		Path = new ArrayList<Node>();
		PathDuration = 0;
	}
	
	public Path(ArrayList<Node> Path, int PathDuration) {
		this.Path = Path;
		this.PathDuration = PathDuration;
	}
	
	//Getters
	public ArrayList<Node> getPath(){
		return Path;
	}
	
	public int getDuration() {
		return PathDuration;
	}
	
	public int getSize() {
		return this.Path.size();
	}
	
	//Setters
	public void addPath(Node name) {
		this.Path.add(name);
	}
	
	public void calcDuration() {
		for (int i = 0; i < this.Path.size(); i++) {
			this.PathDuration += this.Path.get(i).getDuration();	
		}
	}
	
	public void setPath(ArrayList<Node> Path){
		this.Path = Path;
	}
	
	public void setDuration(int PathDuration) {
		this.PathDuration = PathDuration;
	}
}
