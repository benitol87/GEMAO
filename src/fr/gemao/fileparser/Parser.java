package fr.gemao.fileparser;

import java.util.Map;

public abstract class Parser {
	protected String filename;
	
	public Parser(String filename){
		this.filename = filename;
	}
	
	/**
	 * Lecture un fichier et renvoi des informations
	 * qu'il contient sous forme de {@link Map}
	 */
	public abstract Map<String, Object> read();
	
	/**
	 * Ecriture dans un fichier à partir d'informations
	 * sous forme de {@link Map}
	 */
	public abstract boolean write(Map<String, Object> data);

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
