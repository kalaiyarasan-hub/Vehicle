package com.vehicle.globalhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicle.customexception.BrandNotFoundException;
import com.vehicle.customexception.InvalidBoardException;
import com.vehicle.idnotexception.IdNotFoundException;

@RestControllerAdvice
public class GlobalHandling {
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> brandHandler() {
		return new ResponseEntity<Object>("brand does not exc", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidBoardException.class)
	public ResponseEntity<Object> invalidBrand() {
		return new ResponseEntity<Object>("brand not ava", HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> IdNotFoundException() {
		return new ResponseEntity<Object>("Id not available", HttpStatus.BAD_REQUEST);

	}

}
