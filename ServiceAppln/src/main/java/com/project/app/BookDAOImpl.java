package com.project.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
@Service
@Transactional
public class BookDAOImpl implements BookDAO{
	@PersistenceContext
    private EntityManager entityManager;
	public void createBook(Book book) {
        entityManager.persist(book);
		
	}

	public Book getBookById(long id) {
		  return entityManager.find(Book.class,id);
	}

	public List<Book> getAllBooks() {
		return entityManager.createQuery("select boo from Book boo").getResultList();
	}

	public void updateBook(Book book) {
		entityManager.merge(book);
		
	}

	public void deleteBook(long id) {
		Book s = entityManager.find(Book.class,id);
        entityManager.remove(s);
	}

}
