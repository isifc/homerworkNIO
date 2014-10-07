package org.java.facundo.serializacion;

import java.io.Serializable;

public class Pet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String clase;
	
	public Pet(String name,int age,String clase){
		setName(name);
		setAge(age);
		setClase(clase);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
	
	

}
