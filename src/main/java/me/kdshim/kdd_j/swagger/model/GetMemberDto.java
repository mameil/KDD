package me.kdshim.kdd_j.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetMemberDto
 */
@Validated


public class GetMemberDto   {
  @JsonProperty("loginId")
  private String loginId = null;

  @JsonProperty("password")
  private String password = null;

  /**
   * 사용자의 타입
   */
  public enum RoleEnum {
    ADMIN("ADMIN"),
    
    USER("USER");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String text) {
      for (RoleEnum b : RoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("role")
  private RoleEnum role = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("birthDateYYYYMMDD")
  private String birthDateYYYYMMDD = null;

  @JsonProperty("married")
  private Boolean married = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("oldAddr")
  private String oldAddr = null;

  @JsonProperty("addr")
  private String addr = null;

  @JsonProperty("addrDetail")
  private String addrDetail = null;

  @JsonProperty("zipCode")
  private Integer zipCode = null;

  @JsonProperty("created")
  private LocalDateTime created = null;

  @JsonProperty("update")
  private LocalDateTime update = null;

  public GetMemberDto loginId(String loginId) {
    this.loginId = loginId;
    return this;
  }

  /**
   * 로그인시 받는 아이디
   * @return loginId
   **/
  @ApiModelProperty(example = "playggg", value = "로그인시 받는 아이디")
  
    public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public GetMemberDto password(String password) {
    this.password = password;
    return this;
  }

  /**
   * 로그인시 저장되는 아이디
   * @return password
   **/
  @ApiModelProperty(example = "rbeh!234", value = "로그인시 저장되는 아이디")
  
    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public GetMemberDto role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * 사용자의 타입
   * @return role
   **/
  @ApiModelProperty(example = "USER", value = "사용자의 타입")
  
    public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public GetMemberDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 이름
   * @return name
   **/
  @ApiModelProperty(example = "kdshim", value = "이름")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetMemberDto birthDateYYYYMMDD(String birthDateYYYYMMDD) {
    this.birthDateYYYYMMDD = birthDateYYYYMMDD;
    return this;
  }

  /**
   * 생년월일
   * @return birthDateYYYYMMDD
   **/
  @ApiModelProperty(example = "19970329", value = "생년월일")
  
    public String getBirthDateYYYYMMDD() {
    return birthDateYYYYMMDD;
  }

  public void setBirthDateYYYYMMDD(String birthDateYYYYMMDD) {
    this.birthDateYYYYMMDD = birthDateYYYYMMDD;
  }

  public GetMemberDto married(Boolean married) {
    this.married = married;
    return this;
  }

  /**
   * 결혼 여부
   * @return married
   **/
  @ApiModelProperty(example = "false", value = "결혼 여부")
  
    public Boolean isMarried() {
    return married;
  }

  public void setMarried(Boolean married) {
    this.married = married;
  }

  public GetMemberDto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * 이메일
   * @return email
   **/
  @ApiModelProperty(example = "kyudo97@naver.com", value = "이메일")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public GetMemberDto oldAddr(String oldAddr) {
    this.oldAddr = oldAddr;
    return this;
  }

  /**
   * 지번주소
   * @return oldAddr
   **/
  @ApiModelProperty(example = "경기도 고양시 일산서구 주엽동 84", value = "지번주소")
  
    public String getOldAddr() {
    return oldAddr;
  }

  public void setOldAddr(String oldAddr) {
    this.oldAddr = oldAddr;
  }

  public GetMemberDto addr(String addr) {
    this.addr = addr;
    return this;
  }

  /**
   * 도로명주소
   * @return addr
   **/
  @ApiModelProperty(example = "경기도 고양시 일산서구 강선로 30", value = "도로명주소")
  
    public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public GetMemberDto addrDetail(String addrDetail) {
    this.addrDetail = addrDetail;
    return this;
  }

  /**
   * 상세주소
   * @return addrDetail
   **/
  @ApiModelProperty(example = "1504동 1501호", value = "상세주소")
  
    public String getAddrDetail() {
    return addrDetail;
  }

  public void setAddrDetail(String addrDetail) {
    this.addrDetail = addrDetail;
  }

  public GetMemberDto zipCode(Integer zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  /**
   * 우편번호
   * @return zipCode
   **/
  @ApiModelProperty(example = "10365", value = "우편번호")
  
    public Integer getZipCode() {
    return zipCode;
  }

  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }

  public GetMemberDto created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * 엔티티 생성시간
   * @return created
   **/
  @ApiModelProperty(value = "엔티티 생성시간")
  
    @Valid
    public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public GetMemberDto update(LocalDateTime update) {
    this.update = update;
    return this;
  }

  /**
   * 엔티티 수정시간
   * @return update
   **/
  @ApiModelProperty(value = "엔티티 수정시간")
  
    @Valid
    public LocalDateTime getUpdate() {
    return update;
  }

  public void setUpdate(LocalDateTime update) {
    this.update = update;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetMemberDto getMemberDto = (GetMemberDto) o;
    return Objects.equals(this.loginId, getMemberDto.loginId) &&
        Objects.equals(this.password, getMemberDto.password) &&
        Objects.equals(this.role, getMemberDto.role) &&
        Objects.equals(this.name, getMemberDto.name) &&
        Objects.equals(this.birthDateYYYYMMDD, getMemberDto.birthDateYYYYMMDD) &&
        Objects.equals(this.married, getMemberDto.married) &&
        Objects.equals(this.email, getMemberDto.email) &&
        Objects.equals(this.oldAddr, getMemberDto.oldAddr) &&
        Objects.equals(this.addr, getMemberDto.addr) &&
        Objects.equals(this.addrDetail, getMemberDto.addrDetail) &&
        Objects.equals(this.zipCode, getMemberDto.zipCode) &&
        Objects.equals(this.created, getMemberDto.created) &&
        Objects.equals(this.update, getMemberDto.update);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loginId, password, role, name, birthDateYYYYMMDD, married, email, oldAddr, addr, addrDetail, zipCode, created, update);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetMemberDto {\n");
    
    sb.append("    loginId: ").append(toIndentedString(loginId)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    birthDateYYYYMMDD: ").append(toIndentedString(birthDateYYYYMMDD)).append("\n");
    sb.append("    married: ").append(toIndentedString(married)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    oldAddr: ").append(toIndentedString(oldAddr)).append("\n");
    sb.append("    addr: ").append(toIndentedString(addr)).append("\n");
    sb.append("    addrDetail: ").append(toIndentedString(addrDetail)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    update: ").append(toIndentedString(update)).append("\n");
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
