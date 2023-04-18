package id.learn.database.jpa.bootstrap;

import id.learn.database.jpa.model.Book;
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
@Profile({"postgresql", "default"}) // use this to inform the component will be scanned in certain profile
@Component
public class DataInitializr implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializr(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book doraemon = new Book("Doraemon Vol. 01", "123-4321", "PT. Media Elex Komputindo");

        System.out.println("Id : " + doraemon.getId());

        Book savedDoraemon = bookRepository.save(doraemon);
        System.out.println("Id : " + savedDoraemon.getId());

        Book springInAction = new Book("Spring In Action Ed. 5th", "321-1234", "Oriely");
        System.out.println("Id : " + springInAction.getId());

        Book savedSpringInAction = bookRepository.save(springInAction);
        System.out.println("Id : " + savedSpringInAction.getId());

        bookRepository.findAll().forEach(
                book -> {
                    System.out.println("Book Id " + book.getId());
                    System.out.println("Book Title " + book.getTitle());
                }
        );

    }
}
