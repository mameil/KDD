package me.kdshim.kdd_j.link;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.config.KDDError;
import me.kdshim.kdd_j.link.entity.Link;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;

    public List<Link> findAllLinks() {
        return linkRepository.findAll();
    }

    public Link findSingleLink(Long id) {
        return linkRepository.findById(id).orElseThrow(KDDError.LINK_NOT_FOUND::doThrow);
    }

    public Link saveSingleLinkFromDto(PostLinkDto body) {
        Link link = new Link();
        link = link.fromPostDto(body);
        log.info(link.toString());
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
