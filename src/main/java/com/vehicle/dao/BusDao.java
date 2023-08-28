package com.vehicle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Bus;
import com.vehicle.idnotexception.IdNotFoundException;
import com.vehicle.jparepository.BusRepository;

@Repository
public class BusDao {
	@Autowired
	BusRepository br;

	public String setBus(Bus bus) {
		br.save(bus);
		return "saved";

	}

	public String setAllBus(List<Bus> bus) {
		br.saveAll(bus);
		return "sucessful";
	}

	public List<Bus> getAllBus() {

		return br.findAll();
	}

	public List<Bus> getByBrand(String y) {

		return br.getByBrand(y);
	}

	public Bus getById(int x) throws IdNotFoundException {
		return br.findById(x).orElseThrow(() -> new IdNotFoundException("ID NOT FOUNd"));

	}

}
