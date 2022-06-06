package me.kdshim.kdd_j.link;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.book.BookRepository;
import me.kdshim.kdd_j.link.entity.Link;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepositroy linkRepositroy;
    private final BookRepository bookRepository;

    public List<Link> findAllLinks() {
        return linkRepositroy.findAll();
    }

    public Optional<Link> findSingleLink(String url) {
        return linkRepositroy.findById(url);
    }

    public Link saveSingleLinkFromDto(PostLinkDto body) {
        Link link = new Link();
        link = link.fromPostDto(body);
        linkRepositroy.save(link);
        return link;
    }

    public void saveLinkList(List<Link> list){

        linkRepositroy.saveAll(list);
    }

    public void deleteAll(){
        linkRepositroy.deleteAll();
    }

    public void testSave(){
        System.out.println("CHECK THIS OUT");
    }
}
