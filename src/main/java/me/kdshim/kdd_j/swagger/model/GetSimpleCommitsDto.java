package me.kdshim.kdd_j.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import me.kdshim.kdd_j.swagger.model.GetSimpleCommitDto;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 간단한 커밋 조회
 */
@ApiModel(description = "간단한 커밋 조회")
@Validated


public class GetSimpleCommitsDto   {
  @JsonProperty("commitList")
  @Valid
  private List<GetSimpleCommitDto> commitList = null;

  public GetSimpleCommitsDto commitList(List<GetSimpleCommitDto> commitList) {
    this.commitList = commitList;
    return this;
  }

  public GetSimpleCommitsDto addCommitListItem(GetSimpleCommitDto commitListItem) {
    if (this.commitList == null) {
      this.commitList = new ArrayList<>();
    }
    this.commitList.add(commitListItem);
    return this;
  }

  /**
   * Get commitList
   * @return commitList
   **/
  @ApiModelProperty(value = "")
      @Valid
    public List<GetSimpleCommitDto> getCommitList() {
    return commitList;
  }

  public void setCommitList(List<GetSimpleCommitDto> commitList) {
    this.commitList = commitList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetSimpleCommitsDto getSimpleCommitsDto = (GetSimpleCommitsDto) o;
    return Objects.equals(this.commitList, getSimpleCommitsDto.commitList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commitList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSimpleCommitsDto {\n");
    
    sb.append("    commitList: ").append(toIndentedString(commitList)).append("\n");
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
