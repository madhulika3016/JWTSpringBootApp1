package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.Coder;
import com.service.CoderServiceImpl;

@RestController
@RequestMapping("/api")
public class CoderController {
	
	@Autowired
	CoderServiceImpl coderservice;
	
	@RequestMapping("/helloRest")
	public String hello()
	{
		System.out.println("Welcome to Spring Rest Controller");
		
		return "Welcome to Spring Rest Controller";
	}
	
	@GetMapping("/getCoder1")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<Coder>> getCoder()
	{
		List<Coder> lc1=coderservice.getCoders();
		ResponseEntity re=new ResponseEntity<List<Coder>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCoder1/{cid}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Coder> getCoderById(@PathVariable int cid)
	{
	 Coder c1=coderservice.getCoderById(cid);
	 ResponseEntity re=new ResponseEntity<Coder>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addCoder1")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Coder> addCoder(@RequestBody  Coder coder)
	{
		Coder c1=coderservice.addCoder(coder);
		ResponseEntity re=new ResponseEntity<Coder>(c1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateCoder1")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Coder> updateCoder(@RequestBody  Coder coder) throws Exception
	{
		Coder c1=coderservice.updateCoder(coder);
		ResponseEntity<Coder> re=new ResponseEntity<Coder>(c1,HttpStatus.OK);
		return re;
	}
	
	
	@DeleteMapping(path="/deleteCoder1")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteCoder(@RequestBody  Coder coder)
	{
		String msg=coderservice.deleteCoder(coder);
		ResponseEntity re=new ResponseEntity<String>(msg,HttpStatus.OK);
		return re;
	}	
	
	@DeleteMapping(path="/deleteCoder1/{cid}")
	@PreAuthorize("hasRole('ADMIN')")
	public  ResponseEntity<String> deleteCoderById(@PathVariable  int cid)
	{
		String msg=coderservice.deleteCoderById(cid);
		ResponseEntity re=new ResponseEntity<String>(msg,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCoder/{cname}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Coder> getCoderByCname(@PathVariable String cname) 
	{
		Coder c=coderservice.getCoderByCname(cname);
		ResponseEntity re=new ResponseEntity<Coder>(c,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCoders/{tech}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<Coder>> findByTechSorted(String tech) 
	{
		List<Coder> lc=coderservice.findByTechSorted(tech);
		ResponseEntity re=new ResponseEntity<List<Coder>>(lc,HttpStatus.OK);
		return re;
	}
}
