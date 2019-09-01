package model;

import javax.ejb.Singleton;

@Singleton
public class FileSystem {

	private Directory rootDirectory;

	public FileSystem() {
		// Lets populate a little bit the file system... 
		rootDirectory = new Directory("Root Folder, Rhea (do not render this!)", null);
		
		rootDirectory.getFiles().add(new File("file1.txt", File.TYPE_TEXT, "Content of file1"));
		rootDirectory.getFiles().add(new File("Rhea.jpeg", File.TYPE_IMAGE, "Rhea.jpeg"));
		rootDirectory.getFiles().add(new File("test.other", File.TYPE_OTHER, "Rhea.jpeg"));
		
		Directory zeus = new Directory("Zeus son of Rhea", rootDirectory);	
		Directory hera = new Directory("Hera daughter of Rhea", rootDirectory);
		Directory poseidon = new Directory("Poseidon son of Rhea", rootDirectory);
		
		Directory athena = new Directory("Athena daughter of Zeus son of Rhea", zeus);
		Directory apollo = new Directory("Apollo son of Zeus son of Rhea", zeus);
		Directory artemis = new Directory("Artemis daughter of Zeus son of Rhea", zeus);
		
		Directory ares = new Directory("Ares son of Hera daughter of Rhea", hera);
		Directory hephaestus = new Directory("Hephaestus son of Hera daughter of Rhea", hera);
		
		rootDirectory.getDirectories().add(zeus);
		rootDirectory.getDirectories().add(hera);
		rootDirectory.getDirectories().add(poseidon);
		
		zeus.getDirectories().add(athena);
		zeus.getDirectories().add(apollo);
		zeus.getDirectories().add(artemis);
		
		hera.getDirectories().add(ares);
		hera.getDirectories().add(hephaestus);
		
		thisGodHadA(zeus, "thunder");
		thisGodHadA(hera, "peacock feather");
		thisGodHadA(poseidon, "trident");
		thisGodHadA(poseidon, "fish");
		thisGodHadA(poseidon, "dolphin");
		thisGodHadA(athena, "spear");
		thisGodHadA(apollo, "rocket?");
		thisGodHadA(artemis, "bow");
		thisGodHadA(artemis, "bunch of arrows");
		thisGodHadA(ares, "sword");
		thisGodHadA(ares, "shield");
		thisGodHadA(hephaestus, "hammer");
		thisGodHadA(hephaestus, "anvil");
		
		zeus.getFiles().add(new File("Zeus.jpg", File.TYPE_IMAGE, "Zeus.jpg"));
		ares.getFiles().add(new File("Ares.jpg", File.TYPE_IMAGE, "Ares.jpg"));
	}
	
	private void thisGodHadA(Directory greekGod, String thingSheOrHeHad) {
		greekGod.getFiles().add(new File(thingSheOrHeHad + ".had", File.TYPE_TEXT,
				"" + greekGod + " had a " + thingSheOrHeHad));
	}
	
	public Directory getRootDirectory() {
		return rootDirectory;
	}
}
