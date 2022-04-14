package com.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Data;

@Entity
@Data
public class Coder {
	
	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	private String tech;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="aid")
	private Address address;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Coder [cid=" + cid + ", cname=" + cname + ", tech=" + tech + ", address=" + address + "]";
	}	
		
}
	

