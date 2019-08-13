package com.app.rc.gettingStartedWithUserAuthentication.ws.ui.controller;

import com.app.rc.gettingStartedWithUserAuthentication.ws.service.UserRegistrationService;
import com.app.rc.gettingStartedWithUserAuthentication.ws.shared.dto.UserRegistrationDTO;
import com.app.rc.gettingStartedWithUserAuthentication.ws.ui.model.request.UserRegistrationRequestModel;
import com.app.rc.gettingStartedWithUserAuthentication.ws.ui.model.response.UserRegistrationResponseModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/user")
public class UserRegistrationController {

  private final
  UserRegistrationService userRegistrationService;

  @Autowired
  public UserRegistrationController(
      UserRegistrationService userRegistrationService) {this.userRegistrationService = userRegistrationService;}

  /**
   * Simple API for status check.
   *
   * @return
   */
  @GetMapping
  public String user() {
    return "User Method Called";
  }

  /**
   * @return Response of newly saved data and some additional info which can be used in further requests
   */
  @PostMapping
  public UserRegistrationResponseModel createUser(@RequestBody UserRegistrationRequestModel registerRequest) {

    /* Temporary objects */
    UserRegistrationDTO registerDto = new UserRegistrationDTO();
    UserRegistrationResponseModel registerRest = new UserRegistrationResponseModel();

    /* prepare data for sharing */
    BeanUtils.copyProperties(registerRequest, registerDto);

    /* Persist to DB and return result */
    UserRegistrationDTO registerResult = userRegistrationService
        .registerUser(registerDto);

    /* Prepare result object */
    BeanUtils.copyProperties(registerResult, registerRest);

    /* Return result */
    return registerRest;
  }

  /**
   * @param request
   * @return
   */
  @PutMapping
  public UserRegistrationResponseModel updateUser(@RequestBody UserRegistrationRequestModel request) {

    /* Temporary objects */
    UserRegistrationDTO updateDTO = new UserRegistrationDTO();
    UserRegistrationResponseModel response = new UserRegistrationResponseModel();

    /* prepare data for sharing */
    BeanUtils.copyProperties(request, updateDTO);

    /* Persist to DB and return result */
    final UserRegistrationDTO result = userRegistrationService.updateUser(updateDTO);

    /* Prepare result object */
    BeanUtils.copyProperties(result, response);

    /* Return result */
    return response;
  }
}
