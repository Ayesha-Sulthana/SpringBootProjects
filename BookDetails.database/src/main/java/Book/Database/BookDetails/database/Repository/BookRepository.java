package Book.Database.BookDetails.database.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Book.Database.BookDetails.database.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
