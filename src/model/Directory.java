package model;

import java.util.ArrayList;
import java.util.List;

public class Directory {

	private String name;
	private List<Directory> directories;
	private List<File> files;
	
	private Directory parent;

	public Directory(String name, Directory parent) {
		this.name = name;
		this.directories = new ArrayList<>();
		this.files = new ArrayList<>();
		this.parent = parent;
	}

	public List<Directory> getDirectories() {
		return directories;
	}

	public List<File> getFiles() {
		return files;
	}

	public Directory getParent() {
		return parent;
	}
	
	public String toString(){
		return this.name;
	}	
}
