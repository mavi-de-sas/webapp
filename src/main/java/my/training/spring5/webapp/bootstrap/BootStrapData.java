package my.training.spring5.webapp.bootstrap;

import my.training.spring5.webapp.domain.Author;
import my.training.spring5.webapp.domain.Book;
import my.training.spring5.webapp.repository.AuthorRepository;
import my.training.spring5.webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        Author shevchenko = new Author("Taras", "Shevchenko");
        Book kobzar = new Book("Kobzar", "000001");
        shevchenko.getBooks().add(kobzar);
        kobzar.getAuthors().add(shevchenko);
        
        authorRepository.save(shevchenko);
        bookRepository.save(kobzar);
        
        Author franko = new Author("Ivan", "Franko");
        Book boryslav = new Book("Boryslav is laughing", "000002");
        franko.getBooks().add(boryslav);
        boryslav.getAuthors().add(franko);
        
        authorRepository.save(franko);
        bookRepository.save(boryslav);
        
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books : " + bookRepository.count());
    }
}
