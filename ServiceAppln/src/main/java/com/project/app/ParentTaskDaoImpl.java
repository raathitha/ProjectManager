package com.project.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
@Service
@Transactional
public class ParentTaskDaoImpl implements ParentTaskDao{
	@PersistenceContext
    private EntityManager entityManager;
	public void createParentTask(ParentTask ParentTask) {
        entityManager.persist(ParentTask);
		
	}

	public ParentTask getParentTaskById(Integer id) {
		  return entityManager.find(ParentTask.class,id);
	}

	public List<ParentTask> getAllParentTasks() {
		return entityManager.createQuery("select pt from ParentTask pt").getResultList();
	}

	public void updateParentTask(ParentTask ParentTask) {
		entityManager.merge(ParentTask);
		
	}

	public void deleteParentTask(Integer id) {
		ParentTask s = entityManager.find(ParentTask.class,id);
        entityManager.remove(s);
	}

}
