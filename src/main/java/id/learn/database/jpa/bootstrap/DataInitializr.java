package id.learn.database.jpa.bootstrap;

import id.learn.database.jpa.model.Author;
import id.learn.database.jpa.model.Book;
import id.learn.database.jpa.repository.AuthorRepository;
import id.learn.database.jpa.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/***
 * @author : github.com/eigennspace
 * @since : Tue 18/04/2023 13:05
 * @Project : deep-dive-database
 * @Created_by : IdeaU
 */
@Profile({"dev", "default"}) // use this to inform the component will be scanned in certain profile
@Component
public class DataInitializr implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public DataInitializr(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book doraemon = new Book("Doraemon Vol. 01", "123-4321", "PT. Media Elex Komputindo",null);

        System.out.println("Id : " + doraemon.getId());

        Book savedDoraemon = bookRepository.save(doraemon);
        System.out.println("Id : " + savedDoraemon.getId());

        Book springInAction = new Book("Spring In Action Ed. 5th", "321-1234", "Oriely",null);
        System.out.println("Id : " + springInAction.getId());

        Book savedSpringInAction = bookRepository.save(springInAction);
        System.out.println("Id : " + savedSpringInAction.getId());

        bookRepository.findAll().forEach(
                book -> {
                    System.out.println("Book Id " + book.getId());
                    System.out.println("Book Title " + book.getTitle());
                }
        );

        Author fujiko = new Author("Fujiko F.", "Fujio");
        authorRepository.save(fujiko);
    }
}
