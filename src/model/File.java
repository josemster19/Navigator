package model;

public class File {
	
	public static final int TYPE_IMAGE = 0;
	public static final int TYPE_TEXT = 1;
	public static final int TYPE_OTHER = 2;
	
	private String name;
	private int type;
	private String content;
	
	public File(String name, int type, String content) {
		this.name = name;
		this.type = type;
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public String getContent() {
		return content;
	}		
	
	public String toString(){
		return this.name;
	}
}
