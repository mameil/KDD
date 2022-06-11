package me.kdshim.kdd_j.link;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.link.entity.Link;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;

    public List<Link> findAllLinks() {
        return linkRepository.findAll();
    }

    public Optional<Link> findSingleLink(String url) {
        return linkRepository.findById(url);
    }

    public Link saveSingleLinkFromDto(PostLinkDto body) {
        Link link = new Link();
        link = link.fromPostDto(body);
        linkRepository.save(link);
        return link;
    }

    public void saveLinkList(List<Link> list){

        linkRepository.saveAll(list);
    }

    public void deleteAll(){
        linkRepository.deleteAll();
    }

    public void testSave(){
        System.out.println("CHECK THIS OUT");
    }
}
