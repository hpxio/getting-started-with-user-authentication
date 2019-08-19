package com.app.rc.gettingStartedWithUserAuthentication.ws.ui.controller;

import com.app.rc.gettingStartedWithUserAuthentication.ws.service.UserRegistrationService;
import com.app.rc.gettingStartedWithUserAuthentication.ws.shared.dto.UserRegistrationDTO;
import com.app.rc.gettingStartedWithUserAuthentication.ws.ui.model.request.UserRegistrationRequestModel;
import com.app.rc.gettingStartedWithUserAuthentication.ws.ui.model.response.UserRegistrationResponseModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
   * <p>
   * API to access User Details based on the User ID.<br/>
   * </p>
   * <p><b>NOTE:</b><br/>
   * <ol>
   * <li>Generally this kind of operations of accessing user-data is
   * sensitive and should not be allowed to everyone. One way to avoid this is to keep this API private and not
   * accessible via other paths. Another way is to authorize only those users which have ADMIN role. This can be checked
   * by taking User ID as query parameter and before processing request role should be checked.</li>
   * <li>With the current setup we need to include the <tt>Jackson Data Format XML</tt> as dependency to get
   * response in XML format.</li>
   * </ol>
   * </p>
   *
   * @return User Details in JSON Format
   */
  @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public UserRegistrationResponseModel getUsers(@PathVariable String userId) {

    /* Temporary objects for results */
    final UserRegistrationResponseModel response = new UserRegistrationResponseModel();
    final UserRegistrationDTO result = userRegistrationService.getUserByUserId(userId);

    /* Prepare resultant object */
    BeanUtils.copyProperties(result, response);
    return response;
  }

  /**
   * <p>Create User Profile</p>
   *
   * @return Resultant User Profile
   */
  @PostMapping(
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public UserRegistrationResponseModel createUser(@RequestBody UserRegistrationRequestModel registerRequest) {

    /* Temporary objects */
    final UserRegistrationDTO registerDto = new UserRegistrationDTO();
    final UserRegistrationResponseModel registerRest = new UserRegistrationResponseModel();

    /* prepare data for sharing */
    BeanUtils.copyProperties(registerRequest, registerDto);

    /* Persist to DB and return result */
    final UserRegistrationDTO registerResult = userRegistrationService.registerUser(registerDto);

    /* Prepare resultant object */
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
