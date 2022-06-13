package me.kdshim.kdd_j.link.entity;

import lombok.*;
import me.kdshim.kdd_j.common.BaseEntity;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Link extends BaseEntity {
    private String url;

    @Enumerated(EnumType.STRING)
    private CATEGORY category;

    private String name;

    private String memo;

    public boolean checkCoke(String name){
        if(name.equals("나는콜라가좋아"))
            throw new IllegalArgumentException("콜라는 안돼요!");
        return true;
    }

    public GetLinkDto toGetDto(Link link){
        GetLinkDto dto = new GetLinkDto();
        dto.setId(link.getId().intValue());
        dto.setCategory(GetLinkDto.CategoryEnum.valueOf(link.getCategory().toString()));
        dto.setUrl(link.getUrl());
        dto.setName(link.getName());
        dto.setMemo(link.getMemo());
        dto.setCreated(link.getCreated());
        dto.setUpdate(link.getUpdated());

        return dto;
    }

    public PostLinkDto toPostDto(Link link){
        PostLinkDto dto = new PostLinkDto();
        dto.setMemo(link.getMemo());
        dto.setUrl(link.getUrl());
        dto.setName(link.getName());
        dto.setCategory(PostLinkDto.CategoryEnum.valueOf(link.getCategory().toString()));

        return dto;
    }

    public Link fromPostDto(PostLinkDto dto){
        Link link = new Link();
        link.setMemo(dto.getMemo());
        link.setUrl(dto.getUrl());
        link.setName(dto.getName());
        link.setCategory(CATEGORY.valueOf(dto.getCategory().toString()));

        return link;
    }
}
