package cse360proj.CSE360Proj;

import java.util.ArrayList;

public class Path {
	
	ArrayList<String> Path = new ArrayList<String>();
	int PathDuration;
	
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
}
