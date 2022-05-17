package me.kdshim.kdd_j.book;

import me.kdshim.kdd_j.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
