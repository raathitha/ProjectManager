package com.project.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskDaoImpl implements TaskDao {

	@PersistenceContext
    private EntityManager entityManager;
	public void createTask(Task task) {
        entityManager.persist(task);
		
	}

	public Task getTaskById(Integer id) {
		  return entityManager.find(Task.class,id);
	}

	public List<Task> getAllTasks() {
		return entityManager.createQuery("select tk from Task tk").getResultList();
	}

	public void updateTask(Task task) {
		entityManager.merge(task);
		
	}

	public void deleteTask(Integer id) {
		Task s = entityManager.find(Task.class,id);
        entityManager.remove(s);
	}


}
