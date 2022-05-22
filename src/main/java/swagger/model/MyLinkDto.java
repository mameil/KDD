package swagger.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * MyLinkDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class MyLinkDto   {

  @JsonProperty("name")
  private String name;

  @JsonProperty("url")
  private String url;

  @JsonProperty("desc")
  private String desc;

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

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String value) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("category")
  private CategoryEnum category;

  public MyLinkDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 해당 url 이름
   * @return name
  */
  
  @Schema(name = "name", example = "Java Stream API는 왜 for-loop보다 느릴까?", description = "해당 url 이름", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MyLinkDto url(String url) {
    this.url = url;
    return this;
  }

  /**
   * 링크(raw url)
   * @return url
  */
  
  @Schema(name = "url", example = "https://jypthemiracle.medium.com/java-stream-api는-왜-for-loop보다-느릴까-50dec4b9974b", description = "링크(raw url)", required = false)
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public MyLinkDto desc(String desc) {
    this.desc = desc;
    return this;
  }

  /**
   * 해당 url 설명
   * @return desc
  */
  
  @Schema(name = "desc", example = "실제 예시를 통한 비교 해둔 글", description = "해당 url 설명", required = false)
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public MyLinkDto category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * 글의 타입[JAVA, SPRING, FOOD, WORK]
   * @return category
  */
  
  @Schema(name = "category", example = "JAVA", description = "글의 타입[JAVA, SPRING, FOOD, WORK]", required = false)
  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyLinkDto myLinkDto = (MyLinkDto) o;
    return Objects.equals(this.name, myLinkDto.name) &&
        Objects.equals(this.url, myLinkDto.url) &&
        Objects.equals(this.desc, myLinkDto.desc) &&
        Objects.equals(this.category, myLinkDto.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, url, desc, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MyLinkDto {\n");
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

