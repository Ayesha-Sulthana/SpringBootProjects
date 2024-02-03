package Book.Database.BookDetails.database.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import Book.Database.BookDetails.database.Service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/Book/add", method = RequestMethod.POST)
	public boolean addBook(@RequestBody BookDTO bookDTO)
	{
		return bookService.addBook(bookDTO);
	}
	
	@GetMapping("/Book/getAllBooks")
	public List<BookDTO> getAllBooks()
	{
		return bookService.getAllBooks();
	}
	
	@GetMapping("/Book/get/{id}")
	public BookDTO getBookById(@PathVariable int id)
	{
		return bookService.getBookById(id);	
	}
	
}
