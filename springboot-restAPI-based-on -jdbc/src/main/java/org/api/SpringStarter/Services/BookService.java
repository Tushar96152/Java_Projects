package org.api.SpringStarter.Services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.api.SpringStarter.dao.BookRepository;
import org.api.SpringStarter.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BookService {

//	private static List<Book> list = new ArrayList();
//	
//	static {
//		list.add(new Book(12,"java Complete refrence","Tushar"));
//		list.add(new Book(36,"head first to java","saloni"));
//		list.add(new Book(48,"think in java","Tushar verma"));
//		
//	}
	@Autowired
	private BookRepository bookRepository;
	// get all books
	public List<Book> getAllBooks()
	{   
		List<Book>list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	//get single book by id
	public Book getBookById(int id)
	{  Book book = null;
	  try {
//		  book = list.stream().filter(e->e.getId()==id).findFirst().get();
		   book =  this.bookRepository.findById(id);
	  }catch (Exception e) {
		e.printStackTrace();
	}
	  return book;
		
	}
	//adding the book
	
	public Book addBook(Book b)
	{
		Book result = bookRepository.save(b);
		return result;
	}
	
   // delete book
	public void deleteBook(int bid)
	{
//	    list = list.stream().filter(book->book.getId()!= bid).
//	    collect(Collectors.toList());
		this.bookRepository.deleteById(bid);
	}
	
	//update book
	public void updateBook(Book book,int bookId)
	{
//		list = list.stream().map(b->{
//			if(b.getId() == bookId)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);
		this.bookRepository.save(book);
	}
}
