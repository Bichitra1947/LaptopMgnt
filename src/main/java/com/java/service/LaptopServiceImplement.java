package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.entity.Laptop;
import com.java.repository.LaptopRepository;

@Service
public class LaptopServiceImplement implements LaptopService {

	private LaptopRepository repository;
	
	@Autowired
	public void setRepository(LaptopRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Laptop> getAllData() {
		
		List<Laptop> list = repository.activeStatus();
		
//		List<Laptop> list = repository.findAll();
//		list.forEach(System.out::println);
		return list;
	}

	@Override
	public Boolean saveRecords(Laptop laptop) {
		laptop.setActiveStatus("Yes");
		Laptop laptop2 = repository.save(laptop);
		if(laptop2!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public void deleteData(Integer id) {
		//hard delete
//		repository.deleteById(id);
		
		//soft delete
		
		Optional<Laptop> optional = repository.findById(id);
		if(optional.isPresent()) {
		Laptop laptop = optional.get();
		laptop.setActiveStatus("No");
		repository.save(laptop);
		}
	}

	@Override
	public Laptop editData(Integer id) {

		Optional<Laptop> optional = repository.findById(id);
		Laptop laptop = optional.get();
		 return laptop;
	}

}
