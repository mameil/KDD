package me.kdshim.kdd_j.book;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.book.entity.Book;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book findSingleBookById(String id){
        return bookRepository.findById(id).get();
    }
}
