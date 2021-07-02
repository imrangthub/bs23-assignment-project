package com.ariftravelagency.userRole;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRolesService {

	@Autowired
	private UserRolesRepository repository;

	public String roleSave(UserRoleEntity obj) {
		try {
			repository.save(obj);
			return "Role save successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}

}
