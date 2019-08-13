
package com.app.rc.gettingStartedWithUserAuthentication.ws.service;

import com.app.rc.gettingStartedWithUserAuthentication.ws.shared.dto.UserRegistrationDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserRegistrationService extends UserDetailsService {

  public UserRegistrationDto registerUser(UserRegistrationDto registerDto);

  public UserRegistrationDto getUser(String email);
}
