
package com.app.rc;

import com.app.rc.gettingStartedWithUserAuthentication.ws.config.PropertiesHandler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class GettingStartedWithUserAuthenticationApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(GettingStartedWithUserAuthenticationApplication.class, args);
  }

  /* For encoding password */
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SpringApplicationContext springApplicationContext() {
    return new SpringApplicationContext();
  }
  
  @Override
  public void run(String... args) throws Exception {
    PropertiesHandler propertiesHandler = (PropertiesHandler) SpringApplicationContext.getBean("propertiesHandler");
    log.info("Token -> {}", propertiesHandler.getToken());
  }
}
