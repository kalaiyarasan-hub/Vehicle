package com.vehicle.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.vehicle.dao.BikeDao;
import com.vehicle.entity.Bike;

@Service
public class Bikesrvice {
	@Autowired
	BikeDao bd;

	public String setBike(Bike bike) {

		return bd.setBike(bike);
	}

	public String setAllBike(List<Bike> bikes) {

		return bd.setAllBike(bikes);

	}

	@GetMapping

	public Bike getById(int x) {

		return bd.getById(x);
	}

	public String getDelete(int r) {

		return bd.getDelete(r);
	}

	public List<Bike> getAllBike() {

		return bd.getAllBike();
	}

	public List<Bike> getByBrand(String s) {
		List<Bike> x = getAllBike();
		List<Bike> j = x.stream().filter(m -> m.getBrand().equalsIgnoreCase(s)).collect(Collectors.toList());
		return j;
	}

	public List<Bike> getPrice(int a, int b) {
		List<Bike> x = getAllBike();
		List<Bike> j = x.stream().filter(k -> k.getPrice() >= 700000 && k.getPrice() <= 750000)
				.collect(Collectors.toList());
		return j;
	}

	public List<String> getBrandByColor(String color) {
		List<Bike> x = getAllBike();
		List<String> z = x.stream().filter(m -> m.getColor().equalsIgnoreCase(color)).map(f -> f.getBrand()).toList();
		return z;
	}

	public Bike getMax() {
		List<Bike> s = getAllBike();
		Bike r = s.stream().max(Comparator.comparing(Bike::getPrice)).get();
		return r;
	}

	public Bike getMin() {
		List<Bike> s = getAllBike();
		Bike r = s.stream().min(Comparator.comparing(Bike::getPrice)).get();

		return r;
	}

	public List<Bike> getReduse(int d) {
		List<Bike> r = getAllBike();
		List<Bike> y = r.stream().peek(w -> w.setPrice(w.getPrice() - w.getPrice() * d / 100))
				.collect(Collectors.toList());
		return y;
	}

	public Long getPetrolBike(String a) {
	//set a teo line  in single line
		
		//List<Bike>s=getAllBike();
	//long l=s.stream().filter(x->x.getFueltype().equals(a)).count();

		//return null;
		
		
		return getAllBike().stream().filter(x->x.getFueltype().equalsIgnoreCase(a)).count();
	}

}
