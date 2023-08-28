package com.vehicle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Bike;
import com.vehicle.jparepository.BikeRepository;

@Repository
public class BikeDao {
	@Autowired

	BikeRepository br;

	public String setBike(Bike bike) {
		br.save(bike);
		return "Saved";
	}

	public String setAllBike(List<Bike> bikes) {
		br.saveAll(bikes);
		return "saved";

	}

	public Bike getById(int x) {

		return br.findById(x).get();
	}

	public String getDelete(int r) {

		br.deleteById(r);
		return "successfully";
	}

	public List<Bike> getAllBike() {
		return br.findAll();

	}

	

}
