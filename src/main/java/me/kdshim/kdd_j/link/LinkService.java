package me.kdshim.kdd_j.link;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.link.entity.Link;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepositroy linkRepositroy;

    public List<Link> findAllLinks() {
        return linkRepositroy.findAll();
    }

    public Optional<Link> findSingleLink(String url) {
        return linkRepositroy.findById(url);
    }

    public void saveSingleLink(Link link) {
        linkRepositroy.save(link);
    }

    public void saveLinkList(List<Link> list){

        linkRepositroy.saveAll(list);
    }
}
