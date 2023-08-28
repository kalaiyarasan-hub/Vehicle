package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Bike;
import com.vehicle.service.Bikesrvice;

@RestController
public class BikeController {

	@Autowired
	Bikesrvice bs;

	@PostMapping(value = "/getBike")
	public String setBike(@RequestBody Bike bike) {

		return bs.setBike(bike);
	}

	@PostMapping(value = "/setAllBike")
	public String setAllBike(@RequestBody List<Bike> bikes) {
		return bs.setAllBike(bikes);
	}

	@GetMapping("/getById/{x}")
	public Bike getById(@PathVariable int x) {
		return bs.getById(x);
	}

	@DeleteMapping(value = "/delete/{r}")

	public String getDelete(@PathVariable int r) {
		return bs.getDelete(r);
	}

	@GetMapping(value = "/getAllBike/{b}")
	public List<Bike> getAllBike(@PathVariable String b) {
		return bs.getAllBike();
	}

	@GetMapping(value = "/getBrand/{s}")
	public List<Bike> getByBrand(@PathVariable String s) {
		return bs.getByBrand(s);
	}

	@GetMapping(value = "/getPrice/{a}/{b}")
	public List<Bike> getByPrice(@PathVariable int a, @PathVariable int b) {
		return bs.getPrice(a, b);

	}

	@GetMapping(value = "/getBrandByColor/{color}")
	public List<String> getBrandByColor(@PathVariable String color) {
		return bs.getBrandByColor(color);
	}
	@GetMapping(value="/getMax")
	public Bike getMax() {
		return bs.getMax();
	}
	@GetMapping(value="/getMin")
	public Bike getMin() {
		return bs.getMin();
	}
	@GetMapping(value="/getReduse/{d}")
	public List<Bike>getReduse(@PathVariable int d){
		return bs.getReduse(d);
	}
	@GetMapping(value="/getPetrolBike/{a}")
	public Long getPetrolBike(@PathVariable String a) {
		return bs.getPetrolBike(a);
		
	}

}
