package com.ariftravelagency.status;

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



	public String statusSave(StatusEntity obj) {
		try {
			obj.setUserId(1l);
			statusRepository.save(obj);
			return "User save successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}

	public String statusUpdate(StatusEntity reqObj) {
		StatusEntity obj = null;
		System.out.println(reqObj);
		obj = statusRepository.findByIdObj(reqObj.getId());
		if (obj == null) {
			return "Data not found !";
		}
		try {
			obj.setLocationId(reqObj.getLocationId());
			obj.setPrivacyType(reqObj.getPrivacyType());
			obj.setStatusBody(reqObj.getStatusBody());
			statusRepository.update(obj);
			return "Status update successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}

	public String delete(Long id) {
		StatusEntity obj = null;
		obj = statusRepository.findByIdObj(id);
		if (obj == null) {
			return "Data not found !";
		}
		try {
			statusRepository.delete(obj);
			return "Status delete successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}



}
