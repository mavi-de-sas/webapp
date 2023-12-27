package my.training.spring5.webapp.bootstrap;

import my.training.spring5.webapp.domain.Author;
import my.training.spring5.webapp.domain.Book;
import my.training.spring5.webapp.domain.Publisher;
import my.training.spring5.webapp.repository.AuthorRepository;
import my.training.spring5.webapp.repository.BookRepository;
import my.training.spring5.webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    
    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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
        
        Publisher vilnaUkraina = new Publisher(
                "Vilna Ukraina",
                "2 Naukova st.",
                "Lviv",
                "Lviv",
                "79000");
        Publisher ababa = new Publisher(
                "A-BABA-GALA-MAGA",
                "15 Somewhere st.",
                "Kyiv",
                "Kyiv",
                "5100");
        publisherRepository.save(vilnaUkraina);
        publisherRepository.save(ababa);
        
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books : " + bookRepository.count());
        System.out.println("Amount of publishers : " + publisherRepository.count());
    }
}
