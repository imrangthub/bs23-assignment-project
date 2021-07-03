package com.ariftravelagency.statusView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ariftravelagency.user.UserEntity;

@Service
public class StatusViewService {

	@Autowired
	private StatusViewRepository repository;

	public List<StatusViewEntity> getPublicStatusList() {
		return repository.getPublicStatusList();
	}
	
	
	public List<StatusViewEntity> statusListByUserId(Long id) {
		return repository.getStatusListByUserId(id);
	}
	
	
	public StatusViewEntity findById(Long id) {
		return repository.findById(id);
	}
	
	
	

}
