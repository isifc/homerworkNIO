package org.java.facundo.serializacion;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class Serializacion {

	public static void writeObjects(){
	
		System.out.println("Empezando a escribir objetos en el archivo");
		File file = new File("directorio.txt");
		ArrayList<Pet> pets= new ArrayList<Pet>();
		pets.add(new Pet("Puqui",6,"Perro"));
		pets.add(new Pet("Pepi",4,"Loro"));
		pets.add(new Pet("Titi",10,"Mono"));
		pets.add(new Pet("Pepe",3,"Sapo"));
		pets.add(new Pet("tronco",6,"Oso"));
		
		try(FileOutputStream fout = new FileOutputStream(file);
				ObjectOutputStream ofout = new ObjectOutputStream(fout)) {
			
				ofout.writeObject(pets);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
	
	
	public static void readObjects(){
		System.out.println("leyendo objetos en el archivo");
		File file = new File("directorio.txt");
		try(FileInputStream fin = new FileInputStream(file);
				ObjectInputStream oins = new ObjectInputStream(fin)){
			ArrayList<Pet> readPets = (ArrayList<Pet>)oins.readObject();
			for(Pet pet : readPets){
				System.out.println("Name: "+pet.getName());
				System.out.println("Age: "+pet.getAge());
				System.out.println("Clase: "+pet.getClase());
				System.out.println("-------------------------------");
			}						
		}catch(FileNotFoundException e){
			System.out.println("no existe el archivo");
			e.printStackTrace();		
		}catch( IOException e){
			e.printStackTrace();			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
