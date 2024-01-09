package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
	
//	public List<Laptop> findByActiveStatus(String activeStatus);
	
	@Query(value = "SELECT * FROM LAPTOPS WHERE ACTIVE_STATUS='YES'" ,nativeQuery =true)
	public List<Laptop> activeStatus();

}
