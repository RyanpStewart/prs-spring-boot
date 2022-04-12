package com.prs.prsspringboot.ui;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.prs.prsspringboot.business.Vendor;

import com.prs.prsspringboot.data.VendorRepository;

@RestController
@RequestMapping("/vendors")

public class VendorController {

	@Autowired
	private VendorRepository vendorRepo;
	
	
	@GetMapping("/")
	public List<Vendor> getAllvendors() {
		 List<Vendor> vendors = new ArrayList<Vendor>();
		
		try {
			Iterable<Vendor> result = vendorRepo.findAll();
			result.forEach(u -> vendors.add(u));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	
		
		return vendors;
	}
	@CrossOrigin
	@GetMapping("/{id}")
	public List<Vendor> getVendorById(@PathVariable int id) {
		List<Vendor> vendors = new ArrayList<Vendor>();
		
		try {
			Optional<Vendor> result = vendorRepo.findById(id);
			result.ifPresent(u -> vendors.add(u));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return vendors;
	}

	@CrossOrigin
	@PostMapping
	public List<Vendor> createVendor(@RequestBody Vendor Vendor){
		 List<Vendor> vendors = new ArrayList<Vendor>();
		 
		 try {
			 vendors.add(vendorRepo.save(Vendor));
			 
		 } catch (DataIntegrityViolationException dive) {
			 System.out.println(dive.getMessage());
		 }
		 
		 return vendors;
	}
	@CrossOrigin
	@PutMapping("/{id}")
	public List<Vendor> updateVendor(@RequestBody Vendor Vendor, @PathVariable int id){
		List<Vendor> vendors = new ArrayList<Vendor>();
		
		
		if (vendorRepo.existsById(id)) {
			
			try {
				 vendors.add(vendorRepo.save(Vendor));
			 } catch (DataIntegrityViolationException dive) {
				 System.out.println(dive.getMessage());
			 }
		}
		return vendors;
	}
	@CrossOrigin
		@DeleteMapping("/{id}")
		public List<Vendor> deleteVendor(@PathVariable int id){
			List<Vendor> vendors = new ArrayList<Vendor>();
			
			
			if (vendorRepo.existsById(id)) {
				
				try {
					Optional<Vendor> result = vendorRepo.findById(id);
				if(result.isPresent());
					vendors.add(result.get());
					vendorRepo.deleteById(id);
				 } catch (Exception e) {
					 System.out.println(e.getMessage());
				 }
			}
			return vendors;
	}

	
	
	
	
	
}
