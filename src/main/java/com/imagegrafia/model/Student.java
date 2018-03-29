package com.imagegrafia.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	
	@OneToMany //(by degualt it will fetch student primary key and vehicle primary key for mapping nad we can give new name if we want)
	Collection<Vehicle> listofVehicle =new ArrayList<Vehicle>();
	

	public Collection<Vehicle> getListofVehicle() {
		return listofVehicle;
	}
	public void setListofVehicle(Collection<Vehicle> listofVehicle) {
		this.listofVehicle = listofVehicle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
