package com.app.rc.gettingStartedWithUserAuthentication.ws.security;

import com.app.rc.SpringApplicationContext;
import com.app.rc.gettingStartedWithUserAuthentication.ws.service.UserRegistrationService;
import com.app.rc.gettingStartedWithUserAuthentication.ws.shared.dto.UserRegistrationDTO;
import com.app.rc.gettingStartedWithUserAuthentication.ws.ui.model.request.UserSignInRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;

  /**
   * @param authenticationManager
   */
  public AuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {
    try {
      /* Map incoming request to sign-in model */
      UserSignInRequestModel userSignInRequestModel = new ObjectMapper().readValue(request.getInputStream(),
          UserSignInRequestModel.class);

      /* Authenticate User Credentials */
      return authenticationManager.authenticate(new
          UsernamePasswordAuthenticationToken(
          userSignInRequestModel.getEmail(),
          userSignInRequestModel.getPassword(),
          new ArrayList<>()));
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  /**
   *
   */
  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult) throws IOException, ServletException {

    String userName = ((User) authResult.getPrincipal()).getUsername();

    String token = Jwts.builder().setSubject(userName)
                       .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                       .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET).compact();

    /* Return authorization token on successful login attempt */
    response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);

    /* Return UserID for session identification after successful login attempt */
    UserRegistrationService userService =
        (UserRegistrationService) SpringApplicationContext.getBean("userRegistrationServiceImpl");

    UserRegistrationDTO dto = userService.getUser(userName);
    response.addHeader("UserID", dto.getUserId());
  }
}
