package me.kdshim.kdd_j.link;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.link.entity.Link;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepositroy repositroy;

    public Optional<Link> findSingleLink(String url){
        return repositroy.findById(url);
    }


}
