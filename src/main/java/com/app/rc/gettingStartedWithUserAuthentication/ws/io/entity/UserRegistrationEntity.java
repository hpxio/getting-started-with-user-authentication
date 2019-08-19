
package com.app.rc.gettingStartedWithUserAuthentication.ws.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class UserRegistrationEntity
    implements
    Serializable {

  private static final long serialVersionUID = 1934184818795458734L;

  @Id
  @GeneratedValue
  private int id;

  @NotNull
  private String userId;

  @NotNull
  @Column(unique = true, length = 50)
  private String email;

  @NotNull
  @Column(length = 20)
  private String firstName;

  @NotNull
  @Column(length = 20)
  private String lastName;

  @NotNull
  @Column(length = 20)
  private String password;

  @NotNull
  private String encryptedPassword;

  @NotNull
  private String emailVerificationToken;

  @NotNull
  private boolean emailVerificationStatus;

  public UserRegistrationEntity() {
  }

  /**
   * Ïß@param id
   *
   * @param userId
   * @param email
   * @param firstName
   * @param lastName
   * @param password
   * @param encryptedPassword
   * @param emailVerificationToken
   * @param emailVerificationStatus
   */
  public UserRegistrationEntity(
      int id,
      @NotNull String userId, @NotNull String email,
      @NotNull String firstName,
      @NotNull String lastName,
      @NotNull String password,
      @NotNull String encryptedPassword,
      @NotNull String emailVerificationToken,
      @NotNull boolean emailVerificationStatus) {
    super();
    this.id = id;
    this.userId = userId;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.encryptedPassword = encryptedPassword;
    this.emailVerificationToken = emailVerificationToken;
    this.emailVerificationStatus = emailVerificationStatus;
  }

  /**
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "UserRegistrationEntity [id=" + id
           + ", userId=" + userId + ", email=" + email
           + ", firstName=" + firstName + ", lastName="
           + lastName + ", password=" + password
           + ", encryptedPassword=" + encryptedPassword
           + ", emailVerificationToken="
           + emailVerificationToken
           + ", emailVerificationStatus="
           + emailVerificationStatus + "]";
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the encryptedPassword
   */
  public String getEncryptedPassword() {
    return encryptedPassword;
  }

  /**
   * @param encryptedPassword the encryptedPassword to set
   */
  public void setEncryptedPassword(
      String encryptedPassword) {
    this.encryptedPassword = encryptedPassword;
  }

  /**
   * @return the emailVerificationToken
   */
  public String getEmailVerificationToken() {
    return emailVerificationToken;
  }

  /**
   * @param emailVerificationToken the emailVerificationToken to set
   */
  public void setEmailVerificationToken(
      String emailVerificationToken) {
    this.emailVerificationToken = emailVerificationToken;
  }

  /**
   * @return the emailVerificationStatus
   */
  public boolean isEmailVerificationStatus() {
    return emailVerificationStatus;
  }

  /**
   * @param emailVerificationStatus the emailVerificationStatus to set
   */
  public void setEmailVerificationStatus(
      boolean emailVerificationStatus) {
    this.emailVerificationStatus = emailVerificationStatus;
  }
}
