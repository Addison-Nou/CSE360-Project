package cse360proj.CSE360Proj;

import java.util.ArrayList;

public class Path {
	
	ArrayList<String> Path;
	int PathDuration;
	
	public Path() {
		Path = new ArrayList<String>();
		PathDuration = 0;
	}
	
	public Path(ArrayList<String> Path, int PathDuration) {
		this.Path = Path;
		this.PathDuration = PathDuration;
	}
	
	//Getters
	public ArrayList<String> getPath(){
		return Path;
	}
	
	public int getDuration() {
		return PathDuration;
	}
	
	//Setters
	public void addPath(String name) {
		this.Path.add(name);
	}
}
