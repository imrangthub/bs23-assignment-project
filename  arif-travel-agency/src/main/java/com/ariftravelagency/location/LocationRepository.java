package com.ariftravelagency.location;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LocationRepository {

	@Autowired
	private EntityManager entityManager;

	public List<LocationEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LocationEntity> criteria = builder.createQuery(LocationEntity.class);
		Root<LocationEntity> root = criteria.from(LocationEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

}
