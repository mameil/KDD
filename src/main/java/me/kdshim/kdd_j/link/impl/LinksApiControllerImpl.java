package me.kdshim.kdd_j.link.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.link.LinkRepository;
import me.kdshim.kdd_j.link.LinkService;
import me.kdshim.kdd_j.link.entity.Link;
import me.kdshim.kdd_j.swagger.api.LinksApiDelegate;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinksApiControllerImpl implements LinksApiDelegate {
    private final LinkService linkService;
    private final LinkRepository linkRepository;

    @Override
    public ResponseEntity<List<GetLinkDto>> getAllLinks() {
        List<GetLinkDto> list = new ArrayList<>();
        linkRepository.findAll().forEach(link -> {
            list.add(Link.toGetDto(link));
        });

        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<List<GetLinkDto>> saveLinkList(List<PostLinkDto> body) {
        body.forEach(linkService::saveSingleLinkFromDto);
        List<GetLinkDto> list = new ArrayList<>();
        body.forEach(postLinkDto -> {
            Link link = Link.from(postLinkDto);
            list.add(link.toGetDto(link));
        });
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<Void> deleteAllLinks() {
        linkRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
