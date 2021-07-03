package com.ariftravelagency.status;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StatusRepository {

	@Autowired
	private EntityManager entityManager;

	public List<StatusEntity> list() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StatusEntity> criteria = builder.createQuery(StatusEntity.class);
		Root<StatusEntity> root = criteria.from(StatusEntity.class);
		return entityManager.createQuery(criteria).getResultList();
	}

	public StatusEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StatusEntity> criteria = builder.createQuery(StatusEntity.class);
		Root<StatusEntity> root = criteria.from(StatusEntity.class);
		criteria.select(root).where(builder.equal(root.get("id"), id));
		return entityManager.createQuery(criteria).getSingleResult();
	}

	public StatusEntity findByIdObj(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StatusEntity> criteria = builder.createQuery(StatusEntity.class);
		Root<StatusEntity> root = criteria.from(StatusEntity.class);
		criteria.select(root).where(builder.equal(root.get("id"), id));
		try {
			return entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}



	public Boolean save(StatusEntity obj) {
		try {
			entityManager.persist(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean update(StatusEntity obj) {
		try {
			entityManager.merge(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean delete(StatusEntity obj) {
		try {
			entityManager.remove(obj);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
