package me.kdshim.kdd_j.link.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.link.LinkService;
import me.kdshim.kdd_j.link.entity.Link;
import me.kdshim.kdd_j.swagger.api.LinkApiDelegate;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkApiControllerImpl implements LinkApiDelegate {
    private final ObjectMapper objectMapper;
    private final LinkService linkService;

    @Override
    public ResponseEntity<GetLinkDto> saveSingleLink(PostLinkDto body) {
        Link link = linkService.saveSingleLinkFromDto(body);

        return ResponseEntity.ok(link.toGetDto(link));
    }

    @Override
    public ResponseEntity<GetLinkDto> findSingleLinkById(Integer id) {
        Link singleLink = linkService.findSingleLink(id.longValue());

        return ResponseEntity.ok(singleLink.toGetDto(singleLink));
    }
}
