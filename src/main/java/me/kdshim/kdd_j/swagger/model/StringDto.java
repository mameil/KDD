package me.kdshim.kdd_j.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StringDto
 */
@Validated


public class StringDto   {
  @JsonProperty("plainString")
  private String plainString = null;

  public StringDto plainString(String plainString) {
    this.plainString = plainString;
    return this;
  }

  /**
   * 문자열
   * @return plainString
   **/
  @ApiModelProperty(example = "문자열", value = "문자열")
  
    public String getPlainString() {
    return plainString;
  }

  public void setPlainString(String plainString) {
    this.plainString = plainString;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StringDto stringDto = (StringDto) o;
    return Objects.equals(this.plainString, stringDto.plainString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plainString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StringDto {\n");
    
    sb.append("    plainString: ").append(toIndentedString(plainString)).append("\n");
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
