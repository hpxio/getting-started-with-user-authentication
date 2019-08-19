package com.app.rc.gettingStartedWithUserAuthentication.ws.ui.model.request;

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
public class UserRegistrationRequestModel {

  private String email;

  private String password;

  private String firstName;

  private String lastName;
}