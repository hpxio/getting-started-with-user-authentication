package com.app.rc.gettingStartedWithUserAuthentication.ws.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegistrationResponseModel {

  private String userId;

  private String firstName;

  private String lastName;

  /* Email ID for Login */
  private String email;
}
