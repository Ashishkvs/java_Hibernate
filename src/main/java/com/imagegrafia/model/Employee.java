package com.imagegrafia.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	
	@ElementCollection //in order to generate unique id for EMBEDDED collection object we use all this hibernated based annotation 
	@JoinTable(name="EMPLOYEE_ADDRESS",
			joinColumns=@JoinColumn(name="USER_ID")
			) //to override auto-gen default table name
	/*
	 * generic generatior is used to cretae unique key by hibernate
	 * */
	@GenericGenerator(name="increment",strategy="increment")
	@CollectionId(columns= {@Column(name="ADDRESS_ID")},generator="increment",type=@Type(type="long"))
	Collection<Address> listOfAddress=new ArrayList<Address>();

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


	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", listOfAddress=" + listOfAddress + "]";
	}
	
	

}
