package com.jbk.springback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="students")
public class Students {

@Id

 private long id;

@Column(name="name",nullable=false)
 private String name;

@Column(name="lastName")
 private String lastName;

@Column(name="address")
 private String address;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "Students [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address + "]";
}
 
 

}
