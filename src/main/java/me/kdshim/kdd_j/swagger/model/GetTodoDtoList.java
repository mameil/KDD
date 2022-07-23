package me.kdshim.kdd_j.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import me.kdshim.kdd_j.swagger.model.GetTODODto;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * todo 리스트 조회
 */
@ApiModel(description = "todo 리스트 조회")
@Validated


public class GetTodoDtoList   {
  @JsonProperty("dtoList")
  @Valid
  private List<GetTODODto> dtoList = null;

  public GetTodoDtoList dtoList(List<GetTODODto> dtoList) {
    this.dtoList = dtoList;
    return this;
  }

  public GetTodoDtoList addDtoListItem(GetTODODto dtoListItem) {
    if (this.dtoList == null) {
      this.dtoList = new ArrayList<>();
    }
    this.dtoList.add(dtoListItem);
    return this;
  }

  /**
   * Get dtoList
   * @return dtoList
   **/
  @ApiModelProperty(value = "")
      @Valid
    public List<GetTODODto> getDtoList() {
    return dtoList;
  }

  public void setDtoList(List<GetTODODto> dtoList) {
    this.dtoList = dtoList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTodoDtoList getTodoDtoList = (GetTodoDtoList) o;
    return Objects.equals(this.dtoList, getTodoDtoList.dtoList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dtoList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTodoDtoList {\n");
    
    sb.append("    dtoList: ").append(toIndentedString(dtoList)).append("\n");
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
