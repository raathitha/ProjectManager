package com.project.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceContext
    private EntityManager entityManager;
	public void createProject(Project project) {
        entityManager.persist(project);
		
	}

	public Project getProjectById(Integer id) {
		  return entityManager.find(Project.class,id);
	}

	public List<Project> getAllProjects() {
		return entityManager.createQuery("select prj from Project prj").getResultList();
	}

	public void updateProject(Project project) {
		entityManager.merge(project);
		
	}

	public void deleteProject(Integer id) {
		Project s = entityManager.find(Project.class,id);
        entityManager.remove(s);
	}
	
}
