package me.kdshim.kdd_j.swagger.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.link.LinkService;
import me.kdshim.kdd_j.link.entity.CATEGORY;
import me.kdshim.kdd_j.link.entity.Link;
import me.kdshim.kdd_j.swagger.api.LinksApiDelegate;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkApiControllerImpl implements LinksApiDelegate {
    private final LinkService linkService;

    @Override
    public ResponseEntity<List<GetLinkDto>> getAllLinks() {
        List<GetLinkDto> list = new ArrayList<>();
        linkService.findAllLinks().forEach(link -> {
            list.add(link.toGetDto(link));
        });

        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<GetLinkDto> saveSingleLink(PostLinkDto body) {
        Link link = linkService.saveSingleLinkFromDto(body);

        return ResponseEntity.ok(link.toGetDto(link));
    }
}
