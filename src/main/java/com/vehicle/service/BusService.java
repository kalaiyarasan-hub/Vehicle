package com.vehicle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.customexception.BrandNotFoundException;
import com.vehicle.customexception.InvalidBoardException;
import com.vehicle.dao.BusDao;
import com.vehicle.entity.Bus;
import com.vehicle.idnotexception.IdNotFoundException;

@Service
public class BusService {
	@Autowired
	BusDao bd;

	public String setBus(Bus bus) throws InvalidBoardException {
		try {
			if (bus.getBoard().equalsIgnoreCase("white")) {

				return bd.setBus(bus);
			}

			else {
				throw new InvalidBoardException("Invalid");
			}
		}

		catch (InvalidBoardException s) {

			throw new InvalidBoardException("Invalid");
		}
	}

	public String setAllBus(List<Bus> bus) throws InvalidBoardException {
		List<Bus> s = bus.stream().filter(x -> x.getBoard().equalsIgnoreCase("white")).collect(Collectors.toList());
		if (s.isEmpty()) {
			throw new InvalidBoardException("Invalid");
		} else {

			return bd.setAllBus(s);
		}

	}

	public List<Bus> getAllBus() {

		return bd.getAllBus();
	}

	public Bus getById(int x) throws IdNotFoundException {

		return bd.getById(x);
		}

	public List<Bus> getByBrand(String y) throws BrandNotFoundException {

		List<Bus> x = bd.getByBrand(y);
		if (x.isEmpty()) {
			throw new BrandNotFoundException("Board not list");
		} else {
			return x;
		}

	}

	public String update(int id, Bus b) throws InvalidBoardException {
	 Bus x = getById(id);
	 Bus y = b;
	 x.setId(id);
	 x.setBoard(y.getBoard());
	 x.setColor(y.getColor());
	 x.setName(y.getName());
	
	
		bd.setBus(x);
		return "successfull update";
	}
	
	
	
	
	
	




	
}
