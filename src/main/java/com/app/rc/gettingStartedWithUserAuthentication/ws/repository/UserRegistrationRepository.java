
package com.app.rc.gettingStartedWithUserAuthentication.ws.repository;

import com.app.rc.gettingStartedWithUserAuthentication.ws.io.entity.UserRegistrationEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends CrudRepository<UserRegistrationEntity, Long> {

  public UserRegistrationEntity findByEmail(String email);
}
