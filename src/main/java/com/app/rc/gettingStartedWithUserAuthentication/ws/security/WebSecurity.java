package com.app.rc.gettingStartedWithUserAuthentication.ws.security;

import com.app.rc.gettingStartedWithUserAuthentication.ws.service.UserRegistrationService;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity
    extends WebSecurityConfigurerAdapter {

  private final UserRegistrationService userDetailService;

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  /**
   * @param userDetailService
   * @param bCryptPasswordEncoder
   */
  public WebSecurity(UserRegistrationService userDetailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userDetailService = userDetailService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeRequests().
        antMatchers(HttpMethod.POST, "/user/register").
            permitAll()
        .anyRequest().
            authenticated().
            and()
        .addFilter(new AuthenticationFilter(authenticationManager()))
        .addFilter(new AuthorizationFilter(authenticationManager()));

    /* Instruct Spring to not cache the authorization headers & make rest end-points stateless */
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
  }
}