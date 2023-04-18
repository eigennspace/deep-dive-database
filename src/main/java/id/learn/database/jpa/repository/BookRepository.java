package id.learn.database.jpa.repository;

import id.learn.database.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * @author : github.com/eigennspace
 * @since : Tue 18/04/2023 12:58
 * @Project : deep-dive-database
 * @Created_by : IdeaU
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
