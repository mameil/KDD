package me.kdshim.kdd_j.book;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.book.entity.Book;
import me.kdshim.kdd_j.link.LinkRepositroy;
import me.kdshim.kdd_j.link.entity.Link;
import org.joda.time.IllegalInstantException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final LinkRepositroy linkRepositroy;

    public Book findSingleBookById(String id){
        return bookRepository.findById(id).get();
    }

    public Book createBookWithLink(Link link, Book book){
        linkRepositroy.findById(link.getUrl()).orElseThrow(() -> new IllegalInstantException("링크를 먼저 저장하고 책을 저장해주세요!"));
        book.setLink(link);
        linkRepositroy.notify();
        return bookRepository.save(book);
    }
}
