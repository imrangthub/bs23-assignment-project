package com.ariftravelagency.userStatus;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	public List<StatusEntity> list() {
		return statusRepository.list();
	}

	public StatusEntity findById(Long id) {
		return statusRepository.findById(id);
	}

	public String saveOrUpdate(StatusEntity obj) {
		try {
			if (obj.getId() == null) {
				statusRepository.save(obj);
				return "User save successfully done !";
			}
			statusRepository.update(obj);
			return "User update successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}

	public String userSave(StatusEntity obj) {
		try {
			statusRepository.save(obj);
			return "User save successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}



}
