package com.service;

import java.util.List;

import com.models.Coder;
public interface CoderService {
	
	public List<Coder> getCoders();
	
	public Coder getCoderById(int id);
	
	public Coder addCoder(Coder coder);

}
