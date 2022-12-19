package me.kdshim.kdd_j.link;

import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.common.KDDError;
import me.kdshim.kdd_j.link.entity.Link;
import me.kdshim.kdd_j.link.entity.QLink;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkService {
    //TODO Strict하게 Repository에서만 무조건 DB에 접근해야한다 하고 일부러 로직이 없는데도 굳이굳이 service를 거치려고하지말고 바로 사용할 수 있는건 바로 사용하자
    private final LinkRepository linkRepository;
    private final EntityManager entityManager;

    public Link findSingleLink(String url) {
        return linkRepository.findByUrl(url).orElseThrow(KDDError.LINK_NOT_FOUND::doThrow);
    }

    public List<Link> findAllLinksLikeKeyword(String keyword){
        return linkRepository.findByUrlContaining(keyword);
    }

    public Link saveSingleLinkFromDto(PostLinkDto body) {
        Link link = Link.from(body);
        log.info(link.toString());
        link = linkRepository.save(link);
        return link;
    }

    public void testSave(){
        System.out.println("CHECK THIS OUT");
    }

    public void getQLink(){
        JPAQuery<Link> link = new JPAQuery<>(entityManager);
        link.select(QLink.link).from(QLink.link).where(QLink.link.url.eq("testURL"));
        System.out.println("==============================================");
        System.out.println(link.fetch());
        System.out.println("==============================================");
    }
}
