package view_controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//TODO
import model.Directory;
import model.File;
import model.FileSystem;

//TODO
@ManagedBean
@SessionScoped
public class Navigator {

	//TODO
	@EJB
	private FileSystem fileSystem;
	private Directory currentDirectory;
	private File selectedFile;
		
		
	//TODO
	@PostConstruct
	public void init() {
		//TODO 
		selectedFile = null;
		currentDirectory = fileSystem.getRootDirectory();
	}
	
	public Directory getCurrentDirectory(){
		//TODO
		System.out.println(currentDirectory);
		return currentDirectory; //TODO change the return value
	}
	
	public boolean isRootDirectory() {
		//TODO 
		boolean value = false;
		if(currentDirectory == fileSystem.getRootDirectory()) {
			value = true;
		}
		return value; //TODO change the return value
	}

	/**
	 * Sets the currentDirectory.
	 * @param selectedDirectory is the new currentDirectory.
	 */
	public void goIntoDirectory(Directory selectedDirectory){
		//TODO
		currentDirectory = selectedDirectory;
	}

	/**
	 * Goes up one directory level, unless currentDirectory is already
	 * the root directory. File selection is cleared.
	 */
	public void goUpOneLevel() {		
		//TODO
		currentDirectory = currentDirectory.getParent();
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
		//TODO
		
	}
		
	
	public File getSelectedFile() {
		//TODO
		return selectedFile; //TODO change the return value
	}
	
	/**
	 * @return whether the selected file is a text file.
	 */
	public boolean hasTextPreviewToBeRendered() {
		//TODO
		boolean value = false;
		if(selectedFile != null) {
			if(selectedFile.getType() == 1) {
				value = true;
			}
		}
		return value; //TODO change the return value
	}
	
	/**
	 * @return whether the selected file is an image.
	 */
	public boolean hasImagePreviewToBeRendered() {
		//TODO
		boolean value = false;
		if(selectedFile != null) {
			if(selectedFile.getType() == 0) {
				value = true;
			}	
		}

		return value; //TODO change the return value
	}	

	/**
	 * Builds an string with each directory entry in the path separated by an /.
	 * example: /dir1/dir2
	 * Root directory should not have a name.
	 * @return The String representation of the path
	 */
	public String getPathAsString() {
		//TODO
		Directory aux = currentDirectory;
		String s = "/";
		if(aux.getParent() != null) {
			s = "";
			while(aux.getParent() != null) {	
				s ="/" +aux.toString()+s;
				aux = aux.getParent();
			}	
		}

		return s;
	}

}
