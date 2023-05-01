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
 * PostTranRequestDto
 */
@Validated


public class PostTranRequestDto   {
  @JsonProperty("amount")
  private Integer amount = null;

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("registeredAt")
  private String registeredAt = null;

  @JsonProperty("registeredAtYyyymmdd")
  private String registeredAtYyyymmdd = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("tagId")
  private Integer tagId = null;

  /**
   * Gets or Sets moneyType
   */
  public enum MoneyTypeEnum {
    FREE("FREE"),
    
    MINE("MINE");

    private String value;

    MoneyTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MoneyTypeEnum fromValue(String text) {
      for (MoneyTypeEnum b : MoneyTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("moneyType")
  private MoneyTypeEnum moneyType = null;

  public PostTranRequestDto amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * usage amount
   * @return amount
   **/
  @ApiModelProperty(example = "2800", value = "usage amount")
  
    public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public PostTranRequestDto userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * user id
   * @return userId
   **/
  @ApiModelProperty(example = "kdshim", value = "user id")
  
    public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public PostTranRequestDto registeredAt(String registeredAt) {
    this.registeredAt = registeredAt;
    return this;
  }

  /**
   * transaction registered yyyyMMdd HH24:mm:si
   * @return registeredAt
   **/
  @ApiModelProperty(value = "transaction registered yyyyMMdd HH24:mm:si")
  
    public String getRegisteredAt() {
    return registeredAt;
  }

  public void setRegisteredAt(String registeredAt) {
    this.registeredAt = registeredAt;
  }

  public PostTranRequestDto registeredAtYyyymmdd(String registeredAtYyyymmdd) {
    this.registeredAtYyyymmdd = registeredAtYyyymmdd;
    return this;
  }

  /**
   * transaction registered yyyyMMdd
   * @return registeredAtYyyymmdd
   **/
  @ApiModelProperty(value = "transaction registered yyyyMMdd")
  
    public String getRegisteredAtYyyymmdd() {
    return registeredAtYyyymmdd;
  }

  public void setRegisteredAtYyyymmdd(String registeredAtYyyymmdd) {
    this.registeredAtYyyymmdd = registeredAtYyyymmdd;
  }

  public PostTranRequestDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * main purpose for the transaction
   * @return title
   **/
  @ApiModelProperty(value = "main purpose for the transaction")
  
    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public PostTranRequestDto content(String content) {
    this.content = content;
    return this;
  }

  /**
   * additional memo for the transaction
   * @return content
   **/
  @ApiModelProperty(value = "additional memo for the transaction")
  
    public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public PostTranRequestDto tagId(Integer tagId) {
    this.tagId = tagId;
    return this;
  }

  /**
   * tag of the transaction
   * @return tagId
   **/
  @ApiModelProperty(value = "tag of the transaction")
  
    public Integer getTagId() {
    return tagId;
  }

  public void setTagId(Integer tagId) {
    this.tagId = tagId;
  }

  public PostTranRequestDto moneyType(MoneyTypeEnum moneyType) {
    this.moneyType = moneyType;
    return this;
  }

  /**
   * Get moneyType
   * @return moneyType
   **/
  @ApiModelProperty(value = "")
  
    public MoneyTypeEnum getMoneyType() {
    return moneyType;
  }

  public void setMoneyType(MoneyTypeEnum moneyType) {
    this.moneyType = moneyType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostTranRequestDto postTranRequestDto = (PostTranRequestDto) o;
    return Objects.equals(this.amount, postTranRequestDto.amount) &&
        Objects.equals(this.userId, postTranRequestDto.userId) &&
        Objects.equals(this.registeredAt, postTranRequestDto.registeredAt) &&
        Objects.equals(this.registeredAtYyyymmdd, postTranRequestDto.registeredAtYyyymmdd) &&
        Objects.equals(this.title, postTranRequestDto.title) &&
        Objects.equals(this.content, postTranRequestDto.content) &&
        Objects.equals(this.tagId, postTranRequestDto.tagId) &&
        Objects.equals(this.moneyType, postTranRequestDto.moneyType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, userId, registeredAt, registeredAtYyyymmdd, title, content, tagId, moneyType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostTranRequestDto {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    registeredAt: ").append(toIndentedString(registeredAt)).append("\n");
    sb.append("    registeredAtYyyymmdd: ").append(toIndentedString(registeredAtYyyymmdd)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    tagId: ").append(toIndentedString(tagId)).append("\n");
    sb.append("    moneyType: ").append(toIndentedString(moneyType)).append("\n");
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
