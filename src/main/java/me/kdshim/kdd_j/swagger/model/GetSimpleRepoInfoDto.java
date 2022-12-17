package me.kdshim.kdd_j.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetSimpleRepoInfoDto
 */
@Validated


public class GetSimpleRepoInfoDto   {
  @JsonProperty("repoName")
  private String repoName = null;

  @JsonProperty("repoFullName")
  private String repoFullName = null;

  @JsonProperty("repoUrl")
  private String repoUrl = null;

  @JsonProperty("repoDescription")
  private String repoDescription = null;

  @JsonProperty("repoCreated")
  private LocalDateTime repoCreated = null;

  @JsonProperty("repoUpdated")
  private LocalDateTime repoUpdated = null;

  public GetSimpleRepoInfoDto repoName(String repoName) {
    this.repoName = repoName;
    return this;
  }

  /**
   * 해당 레포 이름
   * @return repoName
   **/
  @ApiModelProperty(example = "My-Library", value = "해당 레포 이름")
  
    public String getRepoName() {
    return repoName;
  }

  public void setRepoName(String repoName) {
    this.repoName = repoName;
  }

  public GetSimpleRepoInfoDto repoFullName(String repoFullName) {
    this.repoFullName = repoFullName;
    return this;
  }

  /**
   * 해당 레포 전체 이름
   * @return repoFullName
   **/
  @ApiModelProperty(example = "kyu9/My-Library", value = "해당 레포 전체 이름")
  
    public String getRepoFullName() {
    return repoFullName;
  }

  public void setRepoFullName(String repoFullName) {
    this.repoFullName = repoFullName;
  }

  public GetSimpleRepoInfoDto repoUrl(String repoUrl) {
    this.repoUrl = repoUrl;
    return this;
  }

  /**
   * 해당 레포 url
   * @return repoUrl
   **/
  @ApiModelProperty(example = "https://github.com/kyu9/My-Library", value = "해당 레포 url")
  
    public String getRepoUrl() {
    return repoUrl;
  }

  public void setRepoUrl(String repoUrl) {
    this.repoUrl = repoUrl;
  }

  public GetSimpleRepoInfoDto repoDescription(String repoDescription) {
    this.repoDescription = repoDescription;
    return this;
  }

  /**
   * 해당 레포 설명
   * @return repoDescription
   **/
  @ApiModelProperty(example = "레포에 적어둔 설명", value = "해당 레포 설명")
  
    public String getRepoDescription() {
    return repoDescription;
  }

  public void setRepoDescription(String repoDescription) {
    this.repoDescription = repoDescription;
  }

  public GetSimpleRepoInfoDto repoCreated(LocalDateTime repoCreated) {
    this.repoCreated = repoCreated;
    return this;
  }

  /**
   * 해당 레포 생성일
   * @return repoCreated
   **/
  @ApiModelProperty(example = "2021-11-19T00:00Z", value = "해당 레포 생성일")
  
    @Valid
    public LocalDateTime getRepoCreated() {
    return repoCreated;
  }

  public void setRepoCreated(LocalDateTime repoCreated) {
    this.repoCreated = repoCreated;
  }

  public GetSimpleRepoInfoDto repoUpdated(LocalDateTime repoUpdated) {
    this.repoUpdated = repoUpdated;
    return this;
  }

  /**
   * 해당 레포 수정일
   * @return repoUpdated
   **/
  @ApiModelProperty(example = "2021-11-19T00:00Z", value = "해당 레포 수정일")
  
    @Valid
    public LocalDateTime getRepoUpdated() {
    return repoUpdated;
  }

  public void setRepoUpdated(LocalDateTime repoUpdated) {
    this.repoUpdated = repoUpdated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetSimpleRepoInfoDto getSimpleRepoInfoDto = (GetSimpleRepoInfoDto) o;
    return Objects.equals(this.repoName, getSimpleRepoInfoDto.repoName) &&
        Objects.equals(this.repoFullName, getSimpleRepoInfoDto.repoFullName) &&
        Objects.equals(this.repoUrl, getSimpleRepoInfoDto.repoUrl) &&
        Objects.equals(this.repoDescription, getSimpleRepoInfoDto.repoDescription) &&
        Objects.equals(this.repoCreated, getSimpleRepoInfoDto.repoCreated) &&
        Objects.equals(this.repoUpdated, getSimpleRepoInfoDto.repoUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(repoName, repoFullName, repoUrl, repoDescription, repoCreated, repoUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSimpleRepoInfoDto {\n");
    
    sb.append("    repoName: ").append(toIndentedString(repoName)).append("\n");
    sb.append("    repoFullName: ").append(toIndentedString(repoFullName)).append("\n");
    sb.append("    repoUrl: ").append(toIndentedString(repoUrl)).append("\n");
    sb.append("    repoDescription: ").append(toIndentedString(repoDescription)).append("\n");
    sb.append("    repoCreated: ").append(toIndentedString(repoCreated)).append("\n");
    sb.append("    repoUpdated: ").append(toIndentedString(repoUpdated)).append("\n");
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
