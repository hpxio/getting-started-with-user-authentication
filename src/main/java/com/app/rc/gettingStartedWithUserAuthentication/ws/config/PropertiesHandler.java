package com.app.rc.gettingStartedWithUserAuthentication.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Read property values from properties file(s)
 */
@Component
public class PropertiesHandler {

  private final Environment environment;

  @Autowired
  public PropertiesHandler(Environment environment) {
    this.environment = environment;
  }

  /**
   * Read property 'token' from application.properties
   *
   * @return Value of token property
   */
  public String getToken() {
    return environment.getProperty("token");
  }
}
