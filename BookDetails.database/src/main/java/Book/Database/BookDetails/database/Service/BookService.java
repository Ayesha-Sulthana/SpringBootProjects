package Book.Database.BookDetails.database.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Book.Database.BookDetails.database.DTO.BookDTO;
import Book.Database.BookDetails.database.Model.Book;
import Book.Database.BookDetails.database.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;

	public boolean addBook(BookDTO bookDTO)
	{
		Book b = convertDTOtoEntity(bookDTO);
		Optional<Book> book= repository.findById(b.getId());
		if(book.isPresent())
			return false;
		else
		{
			repository.save(b);
			return true;
		}
	}

	public List<BookDTO> getAllBooks() {
		List<Book> books = repository.findAll();
		List<BookDTO> bookDTOs = new ArrayList<>();
		for(Book b : books)
		{
			BookDTO bt = convertEntityToDTO(b);
			bookDTOs.add(bt);
		}
		return bookDTOs;
	}

	public BookDTO getBookById(int id) 
	{
		Optional<Book> book = repository.findById(id);
		if(book.isPresent())
		{
			Book b = book.get();
			return convertEntityToDTO(b);
		}
		else
			return null;
	}
	
	private Book convertDTOtoEntity(BookDTO bookDTO) {
        return new Book(bookDTO.getId(), bookDTO.getName(), bookDTO.getCost());
    }
	private BookDTO convertEntityToDTO(Book book) {
        return new BookDTO(book.getId(), book.getName(), book.getCost());
    }
}
