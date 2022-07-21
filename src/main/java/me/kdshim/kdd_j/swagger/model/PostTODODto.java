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
 * PostTODODto
 */
@Validated


public class PostTODODto   {
  @JsonProperty("todo")
  private String todo = null;

  @JsonProperty("endDate")
  private String endDate = null;

  public PostTODODto todo(String todo) {
    this.todo = todo;
    return this;
  }

  /**
   * TODO 내용
   * @return todo
   **/
  @ApiModelProperty(example = "DO SOMETHING!", value = "TODO 내용")
  
    public String getTodo() {
    return todo;
  }

  public void setTodo(String todo) {
    this.todo = todo;
  }

  public PostTODODto endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * TODO's endDate(yyyymmddHH24MISS)
   * @return endDate
   **/
  @ApiModelProperty(example = "2022072100908", value = "TODO's endDate(yyyymmddHH24MISS)")
  
    public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostTODODto postTODODto = (PostTODODto) o;
    return Objects.equals(this.todo, postTODODto.todo) &&
        Objects.equals(this.endDate, postTODODto.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(todo, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostTODODto {\n");
    
    sb.append("    todo: ").append(toIndentedString(todo)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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
