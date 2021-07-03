package com.ariftravelagency.statusView;

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
public class StatusViewRepository {

	@Autowired
	private EntityManager entityManager;
	
	public List<StatusViewEntity> getPublicStatusList() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StatusViewEntity> criteria = builder.createQuery(StatusViewEntity.class);
		Root<StatusViewEntity> root = criteria.from(StatusViewEntity.class);
		criteria.select(root).where(builder.equal(root.get("privacyType"), 0));
		return entityManager.createQuery(criteria).getResultList();
	}

	public List<StatusViewEntity> getStatusListByUserId(Long userId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StatusViewEntity> criteria = builder.createQuery(StatusViewEntity.class);
		Root<StatusViewEntity> root = criteria.from(StatusViewEntity.class);
		criteria.select(root).where(builder.equal(root.get("userId"), userId));
		return entityManager.createQuery(criteria).getResultList();
	}

	public StatusViewEntity findById(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StatusViewEntity> criteria = builder.createQuery(StatusViewEntity.class);
		Root<StatusViewEntity> root = criteria.from(StatusViewEntity.class);
		criteria.select(root).where(builder.equal(root.get("id"), id));
		return entityManager.createQuery(criteria).getSingleResult();
	}

}
