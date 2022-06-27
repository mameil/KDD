package me.kdshim.kdd_j.link.entity;

import lombok.*;
import me.kdshim.kdd_j.common.BaseEntity;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Link extends BaseEntity {
    @Id
    private String url;

    @Enumerated(EnumType.STRING)
    private CATEGORY category;

    private String name;

    private String memo;

    public Link(String url, String memo, String name, CATEGORY category){
        this.url = url;
        this.memo = memo;
        this.name = name;
        this.category = category;
    }

    public boolean checkCoke(String name){
        if(name.equals("나는콜라가좋아"))
            throw new IllegalArgumentException("콜라는 안돼요!");
        return true;
    }

    //static으로 빼긴 뺐는데... 생성자도 한꺼번에 처리해버리고 싶지만 dto같은 경우에는 generator를 사용하기 때문에 이거쓰면 엔티티 전용으로밖애 못만들구나
    public static GetLinkDto toGetDto(Link link){
        GetLinkDto dto = new GetLinkDto();
        dto.setUrl(link.getUrl());
        dto.setCategory(GetLinkDto.CategoryEnum.valueOf(link.getCategory().toString()));
        dto.setName(link.getName());
        dto.setMemo(link.getMemo());
        dto.setCreated(link.getCreated());
        dto.setUpdate(link.getUpdated());

        return dto;
    }

    public static PostLinkDto toPostDto(Link link){
        PostLinkDto dto = new PostLinkDto();
        dto.setUrl(link.getUrl());
        dto.setMemo(link.getMemo());
        dto.setName(link.getName());
        dto.setCategory(PostLinkDto.CategoryEnum.valueOf(link.getCategory().toString()));

        return dto;
    }

    public static Link from(PostLinkDto dto){
        return new Link(dto.getUrl(), dto.getMemo(), dto.getName(), CATEGORY.valueOf(dto.getCategory().toString()));
    }
}
