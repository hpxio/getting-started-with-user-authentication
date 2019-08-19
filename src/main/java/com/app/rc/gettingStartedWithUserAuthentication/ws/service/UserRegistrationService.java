
package com.app.rc.gettingStartedWithUserAuthentication.ws.service;

import com.app.rc.gettingStartedWithUserAuthentication.ws.shared.dto.UserRegistrationDTO;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserRegistrationService extends UserDetailsService {

  public UserRegistrationDTO registerUser(UserRegistrationDTO registerDto);

  public UserRegistrationDTO updateUser(UserRegistrationDTO updateDTO);

  public UserRegistrationDTO getUser(String email);

  public UserRegistrationDTO getUserByUserId(String userId);
}
