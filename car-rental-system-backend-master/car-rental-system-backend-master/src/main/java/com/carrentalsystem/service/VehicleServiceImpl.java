package com.carrentalsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.VehicleDao;
import com.carrentalsystem.entity.Variant;
import com.carrentalsystem.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;
	
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}
	
	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}
	
	@Override
	public Vehicle getById(int vehicleId) {
		Optional<Vehicle> optional=this.vehicleDao.findById(vehicleId);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	@Override
	public List<Vehicle> getByVariantAndStatus(Variant variant,String status) {
		return vehicleDao.findByVariantAndStatus(variant,status);
	}
	
	@Override
	public List<Vehicle> getByStatus(String status) {
		return vehicleDao.findByStatus(status);
	}
}
