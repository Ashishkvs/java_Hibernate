package com.imagegrafia.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USER_DETAILS")
public class UserDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="user_id")
	int id;
	@Column(name="user_name")
	String name;
	@Embedded
	Address homeAddress;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="city",
	column=@Column(name="OFFICE_CITY_NAME")),
	@AttributeOverride(name="state",
	column=@Column(name="OFFICE_STATE_NAME"))})
	
	Address officeAddress;
	

	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	@Temporal(TemporalType.TIME)
	Date joinedDate;
	@Lob
	String description;
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
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", name=" + name + ", homeAddress=" + homeAddress + ", officeAddress="
				+ officeAddress + ", joinedDate=" + joinedDate + ", description=" + description + "]";
	}
	
	
	}
	
	

