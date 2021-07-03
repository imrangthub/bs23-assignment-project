package com.ariftravelagency.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
	private LocationRepository repository;

	public List<LocationEntity> list() {
		return repository.list();
	}
	
	

}
