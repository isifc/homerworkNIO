package org.java.facundo.nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Homerwork {

	
	
	
	public static void createFileNIO() {
		// TODO Auto-generated method stub
		Path path = Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/directorio.txt");
	    
		try {
			// creating the file from the path
			path = Files.createFile(path);
			System.out.println("The file has been created successfully : "+ path.getFileName());	
			//(path.toFile());		
			
		} catch (FileAlreadyExistsException e) {
			System.out.println(String.format("the file %1$30s already exits", e.getFile()));
			/*try {
			//	showFileInfo(path.toFile());
			} catch (IOException e1) {				
				e1.printStackTrace();
			}*/
		} catch (IOException e){
			e.printStackTrace();			
		}
	}

	
	
	
	public static void deleteFileNIO() {
		// TODO Auto-generated method stub
		Path path = Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/directorio.txt");
		try {
			boolean flag=Files.deleteIfExists(path);
			if (flag==true){
				System.out.println("Se ah eliminado correctamente el archivo: "+path.getFileName());
			}else{
				System.out.println("El archivo no existe, no se realizo la operación");
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	
	public static void copyFileNIO() {
		// TODO Auto-generated method stub
		Path path = Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/directorio.txt");
		Path path2= Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/copies/directorio.txt");
		try {
			Files.copy(path, path2);
		} catch(NoSuchFileException e){
			System.out.println("No se pudo realizar la operacion porque el archivo en el destino ya existe");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static void moveFileNIO() {
		// TODO Auto-generated method stub
		Path path = Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/directorio.txt");
		Path path2= Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/moves/directorio.txt");
		try {
			Files.move(path, path2);
			System.out.println("el archivo se movio correctamente");
		} catch(NoSuchFileException e){
			System.out.println("No se pudo realizar la operacion porque el archivo en el destino ya existe");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo realizar la operacion");
			e.printStackTrace();
		}
	}


	public void readFileNIO() {
		// TODO Auto-generated method stub
		
	}

	
	public void whiteFileNIO() {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void readAndWriteFileWithNio(){
		// create a specific path 
		Path path  = Paths.get("writeAndRead.d");
		// we ask if this file already exist
	    boolean fileExist = Files.exists(path);	
	    if(!fileExist){
	    	// if not exits we have to create it 
	    	try {
				Files.createFile(path);
			} catch (IOException e) {				
				e.printStackTrace();
				return;
			}	    	
	    }
	     // we have to create a buffer to handle strings 
	    StringBuffer stb = new StringBuffer("Those who dream by day are cognizant of many things that escape those who dream only at night.").append("\n this is another lines");
	    
		try {
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		    //writing bytes into the file
			System.out.println("writing files ...........");
			Files.write(path, stb.toString().getBytes());
		
			//reading file
			System.out.println("reading files ..........");
			System.out.println("the file size is >>>"+ Files.size(path));			
			byte[] fileContent = Files.readAllBytes(path);
			System.out.println(new String(fileContent));
			
			System.out.println("----------------------------------------------------------------------------------------------------------------");
			
			System.out.println("writing  with  StandardOpenOption.APPEND appending more bytes to the current file ");
			// StandardOpenOption.APPEND appending more bytes to the current file
			Files.write(path, stb.reverse().toString().getBytes(),StandardOpenOption.APPEND);
			
			System.out.println("Reading file again .....");			
			fileContent = Files.readAllBytes(path);
			System.out.println(new String(fileContent));
			
			System.out.println("----------------------------------------------------------------------------------------------------------------");
			System.out.println("writing  with  StandardOpenOption.WRITE ");
			// StandardOpenOption.APPEND appending more bytes to the current file
			Files.write(path, stb.replace(0,10,"tttttttttt").toString().getBytes(),StandardOpenOption.WRITE);
			
			System.out.println("Reading file again .....");			
			fileContent = Files.readAllBytes(path);
			System.out.println(new String(fileContent));
			
			System.out.println("----------------------------------------------------------------------------------------------------------------");
			System.out.println("writing  with  StandardOpenOption.TRUNCATE_EXISTING");
			// StandardOpenOption.APPEND appending more bytes to the current file
			Files.write(path, stb.reverse().toString().getBytes(),StandardOpenOption.TRUNCATE_EXISTING);			
			
			System.out.println("Reading file again .....");			
			fileContent = Files.readAllBytes(path);
			System.out.println(new String(fileContent));
			
			
			System.out.println("Reading file again ..... but with lines --------------------------------------------------------------------");			
			List<String> lines = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
			System.out.println(lines);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	public static void createDirectoryNIO() {
		// TODO Auto-generated method stub
		Path path = Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/directory");
		try {
			path= Files.createDirectory(path);
			System.out.println("La carpeta se creo satisfactoriamente");
		} catch (FileAlreadyExistsException e) {
			// TODO Auto-generated catch block
			System.out.println(String.format("ya existe un archivo y/o directorio con ese nombre", e.getFile()));
		}catch(IOException e2){
			e2.getStackTrace();
		}
	}

	
	public static void deleteDirectoryNIO() {
		// TODO Auto-generated method stub
		Path path = Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/directory");
		try {
			boolean flag= Files.deleteIfExists(path);
			if (flag== true){
				System.out.println("la carpeta se ah eliminado correctamente: "+path.getFileName());
			}else{
				System.out.println("El archivo no existe, no se realizo la operación");
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public static void copyDirectoryNIO() {
		// TODO Auto-generated method stub
		
		Path path = Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/directory");
		Path path2= Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/copies/directory");
		try {
			Files.copy(path, path2);
			System.out.println("la carpeta se copio correctamente");
		} catch(NoSuchFileException e){
			System.out.println("No se pudo realizar la operacion porque la carpeta en el destino ya existe");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo realizar la operacion");
			e.printStackTrace();
		}
		
	}


	public static void MoveDirectoryNIO() {
		// TODO Auto-generated method stub
		Path path = Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/directory");
		Path path2= Paths.get("/media/pandorga/DATA/facu/TrabajosJava/homerWorkNIO/moves/directory");
		try {
			Files.move(path, path2);
			System.out.println("la carpeta se movio correctamente");
		} catch(NoSuchFileException e){
			System.out.println("No se pudo realizar la operacion porque la carpeta en el destino ya existe");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo realizar la operacion");
			e.printStackTrace();
		}
	}

}
