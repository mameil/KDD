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
 * GetSimpleCommitDto
 */
@Validated


public class GetSimpleCommitDto   {
  @JsonProperty("author")
  private String author = null;

  @JsonProperty("commitMsg")
  private String commitMsg = null;

  @JsonProperty("commitYYYYMMDD")
  private String commitYYYYMMDD = null;

  public GetSimpleCommitDto author(String author) {
    this.author = author;
    return this;
  }

  /**
   * 커밋한 닉네임
   * @return author
   **/
  @ApiModelProperty(example = "kyu9", value = "커밋한 닉네임")
  
    public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public GetSimpleCommitDto commitMsg(String commitMsg) {
    this.commitMsg = commitMsg;
    return this;
  }

  /**
   * 커밋 메세지 내용
   * @return commitMsg
   **/
  @ApiModelProperty(example = "아무튼 커밋 메세지입니다", value = "커밋 메세지 내용")
  
    public String getCommitMsg() {
    return commitMsg;
  }

  public void setCommitMsg(String commitMsg) {
    this.commitMsg = commitMsg;
  }

  public GetSimpleCommitDto commitYYYYMMDD(String commitYYYYMMDD) {
    this.commitYYYYMMDD = commitYYYYMMDD;
    return this;
  }

  /**
   * 해당 커밋 YYYY-MM-DD
   * @return commitYYYYMMDD
   **/
  @ApiModelProperty(example = "2022-11-19", value = "해당 커밋 YYYY-MM-DD")
  
    public String getCommitYYYYMMDD() {
    return commitYYYYMMDD;
  }

  public void setCommitYYYYMMDD(String commitYYYYMMDD) {
    this.commitYYYYMMDD = commitYYYYMMDD;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetSimpleCommitDto getSimpleCommitDto = (GetSimpleCommitDto) o;
    return Objects.equals(this.author, getSimpleCommitDto.author) &&
        Objects.equals(this.commitMsg, getSimpleCommitDto.commitMsg) &&
        Objects.equals(this.commitYYYYMMDD, getSimpleCommitDto.commitYYYYMMDD);
  }

  @Override
  public int hashCode() {
    return Objects.hash(author, commitMsg, commitYYYYMMDD);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSimpleCommitDto {\n");
    
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    commitMsg: ").append(toIndentedString(commitMsg)).append("\n");
    sb.append("    commitYYYYMMDD: ").append(toIndentedString(commitYYYYMMDD)).append("\n");
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
