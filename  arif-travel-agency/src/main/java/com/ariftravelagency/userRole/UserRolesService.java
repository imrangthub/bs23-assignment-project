package com.ariftravelagency.userRole;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ariftravelagency.user.UserEntity;
import com.ariftravelagency.user.UserService;

@Service
public class UserRolesService {

	@Autowired
	private UserRolesRepository repository;


	public String addUserRole(Long userId ) {
		UserRoleEntity userRoleObj = new UserRoleEntity();
		userRoleObj.setUserId(userId);
		userRoleObj.setRoleId(99999990l);
		userRoleObj.setDeleted(false);
		try {
			repository.save(userRoleObj);
			return "Role save successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}

}
