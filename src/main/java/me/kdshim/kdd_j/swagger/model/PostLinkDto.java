package me.kdshim.kdd_j.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PostLinkDto
 */
@Validated


public class PostLinkDto   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("desc")
  private String desc = null;

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

  public PostLinkDto name(String name) {
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

  public PostLinkDto url(String url) {
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

  public PostLinkDto desc(String desc) {
    this.desc = desc;
    return this;
  }

  /**
   * 해당 url 설명
   * @return desc
   **/
  @ApiModelProperty(example = "실제 예시를 통한 비교 해둔 글", value = "해당 url 설명")
  
    public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public PostLinkDto category(CategoryEnum category) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostLinkDto postLinkDto = (PostLinkDto) o;
    return Objects.equals(this.name, postLinkDto.name) &&
        Objects.equals(this.url, postLinkDto.url) &&
        Objects.equals(this.desc, postLinkDto.desc) &&
        Objects.equals(this.category, postLinkDto.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, url, desc, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostLinkDto {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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
