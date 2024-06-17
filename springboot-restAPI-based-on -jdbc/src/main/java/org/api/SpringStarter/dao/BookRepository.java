package org.api.SpringStarter.dao;

import org.api.SpringStarter.model.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);

}
