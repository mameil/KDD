package me.kdshim.kdd_j.book;

import me.kdshim.kdd_j.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
