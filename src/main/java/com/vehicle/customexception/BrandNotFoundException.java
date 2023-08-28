package com.vehicle.customexception;

public class BrandNotFoundException extends Exception {
	public BrandNotFoundException(String sms) {
		super(sms);
	}

}
