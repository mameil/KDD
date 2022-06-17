package me.kdshim.kdd_j.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetLinkDto
 */
@Validated


public class GetLinkDto   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("memo")
  private String memo = null;

  /**
   * 글의 타입[JAVA, SPRING, FOOD, WORK]
   */
  public enum CategoryEnum {
    JAVA("JAVA"),
    
    SPRING("SPRING"),
    
    FOOD("FOOD"),
    
    WORK("WORK");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String text) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("category")
  private CategoryEnum category = null;

  @JsonProperty("created")
  private LocalDateTime created = null;

  @JsonProperty("update")
  private LocalDateTime update = null;

  public GetLinkDto id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * 저장된 아이디(AUTO_INCREMENT)
   * @return id
   **/
  @ApiModelProperty(example = "1", value = "저장된 아이디(AUTO_INCREMENT)")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public GetLinkDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 해당 url 이름
   * @return name
   **/
  @ApiModelProperty(example = "Java Stream API는 왜 for-loop보다 느릴까?", value = "해당 url 이름")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetLinkDto url(String url) {
    this.url = url;
    return this;
  }

  /**
   * 링크(raw url)
   * @return url
   **/
  @ApiModelProperty(example = "https://jypthemiracle.medium.com/java-stream-api는-왜-for-loop보다-느릴까-50dec4b9974b", value = "링크(raw url)")
  
    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public GetLinkDto memo(String memo) {
    this.memo = memo;
    return this;
  }

  /**
   * 해당 url 설명
   * @return memo
   **/
  @ApiModelProperty(example = "실제 예시를 통한 비교 해둔 글", value = "해당 url 설명")
  
    public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public GetLinkDto category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * 글의 타입[JAVA, SPRING, FOOD, WORK]
   * @return category
   **/
  @ApiModelProperty(example = "JAVA", value = "글의 타입[JAVA, SPRING, FOOD, WORK]")
  
    public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public GetLinkDto created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * 엔티티 생성시간
   * @return created
   **/
  @ApiModelProperty(value = "엔티티 생성시간")
  
    @Valid
    public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public GetLinkDto update(LocalDateTime update) {
    this.update = update;
    return this;
  }

  /**
   * 엔티티 수정시간
   * @return update
   **/
  @ApiModelProperty(value = "엔티티 수정시간")
  
    @Valid
    public LocalDateTime getUpdate() {
    return update;
  }

  public void setUpdate(LocalDateTime update) {
    this.update = update;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetLinkDto getLinkDto = (GetLinkDto) o;
    return Objects.equals(this.id, getLinkDto.id) &&
        Objects.equals(this.name, getLinkDto.name) &&
        Objects.equals(this.url, getLinkDto.url) &&
        Objects.equals(this.memo, getLinkDto.memo) &&
        Objects.equals(this.category, getLinkDto.category) &&
        Objects.equals(this.created, getLinkDto.created) &&
        Objects.equals(this.update, getLinkDto.update);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, url, memo, category, created, update);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLinkDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    update: ").append(toIndentedString(update)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
