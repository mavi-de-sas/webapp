package my.training.spring5.webapp.repository;

import my.training.spring5.webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
