package com.project.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
@Service
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
    private EntityManager entityManager;
	public void createUser(User user) {
        entityManager.persist(user);
		
	}

	public User getUserById(Integer id) {
		  return entityManager.find(User.class,id);
	}

	public List<User> getAllUsers() {
		return entityManager.createQuery("select usr from User usr").getResultList();
	}

	public void updateUser(User user) {
		entityManager.merge(user);
		
	}

	public void deleteUser(Integer id) {
		User s = entityManager.find(User.class,id);
        entityManager.remove(s);
	}


}
