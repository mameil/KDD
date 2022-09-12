package me.kdshim.kdd_j.link.impl;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.link.LinkService;
import me.kdshim.kdd_j.link.entity.Link;
import me.kdshim.kdd_j.sender.GithubSender;
import me.kdshim.kdd_j.swagger.api.LinkApiDelegate;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkApiControllerImpl implements LinkApiDelegate {
    private final LinkService linkService;

    @Override
    public ResponseEntity<GetLinkDto> saveSingleLink(PostLinkDto body) {
        Link link = linkService.saveSingleLinkFromDto(body);

        return ResponseEntity.ok(link.toGetDto(link));
    }

    @Override
    public ResponseEntity<List<GetLinkDto>> findLinksLikeUrl(String keyword) {
        List<Link> linkList = linkService.findAllLinksLikeKeyword(keyword);
        List<GetLinkDto> dtoList = new ArrayList<>();
        linkList.forEach(link -> dtoList.add(link.toGetDto(link)));

        return ResponseEntity.ok(dtoList);
    }

    @Override
    public ResponseEntity<GetLinkDto> findSingleLink(String url) {
        Link link = linkService.findSingleLink(url);
        return ResponseEntity.ok(link.toGetDto(link));
    }
}
