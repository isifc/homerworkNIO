package org.java.facundo.nio;

public interface IOperations {
	
	public  void createFileNIO();
	public void deleteFileNIO();
	public void copyFileNIO();
	public void moveFileNIO();
	public void readFileNIO();
	public void whiteFileNIO();
	
	//-------aca arrancan las operaciones sobre directorios.
	
	public void createDirectoryNIO();
	public void deleteDirectoryNIO();
	public void copyDirectoryNIO();
	public void MoveDirectoryNIO();

}
