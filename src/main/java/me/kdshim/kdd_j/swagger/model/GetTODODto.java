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
 * GetTODODto
 */
@Validated


public class GetTODODto   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("todo")
  private String todo = null;

  /**
   * TODO 상태 [DONE, TODO, DOING]
   */
  public enum StatusEnum {
    DONE("DONE"),
    
    TODO("TODO"),
    
    DOING("DOING");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("endDate")
  private String endDate = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("updated")
  private String updated = null;

  public GetTODODto id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * TODO ID
   * @return id
   **/
  @ApiModelProperty(example = "1", value = "TODO ID")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public GetTODODto todo(String todo) {
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

  public GetTODODto status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * TODO 상태 [DONE, TODO, DOING]
   * @return status
   **/
  @ApiModelProperty(example = "TODO", value = "TODO 상태 [DONE, TODO, DOING]")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public GetTODODto endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * TODO 끝낸 시간
   * @return endDate
   **/
  @ApiModelProperty(example = "20220721120908", value = "TODO 끝낸 시간")
  
    public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public GetTODODto created(String created) {
    this.created = created;
    return this;
  }

  /**
   * TODO 생성날짜
   * @return created
   **/
  @ApiModelProperty(example = "20220721200908", value = "TODO 생성날짜")
  
    public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public GetTODODto updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * TODO 변경날짜
   * @return updated
   **/
  @ApiModelProperty(example = "20220721200908", value = "TODO 변경날짜")
  
    public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTODODto getTODODto = (GetTODODto) o;
    return Objects.equals(this.id, getTODODto.id) &&
        Objects.equals(this.todo, getTODODto.todo) &&
        Objects.equals(this.status, getTODODto.status) &&
        Objects.equals(this.endDate, getTODODto.endDate) &&
        Objects.equals(this.created, getTODODto.created) &&
        Objects.equals(this.updated, getTODODto.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, todo, status, endDate, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTODODto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    todo: ").append(toIndentedString(todo)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
