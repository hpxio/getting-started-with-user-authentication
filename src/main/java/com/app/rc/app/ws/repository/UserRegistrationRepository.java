
package com.app.rc.app.ws.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.app.rc.app.ws.io.entity.UserRegistrationEntity;


@Repository
public interface UserRegistrationRepository
        extends
            CrudRepository< UserRegistrationEntity, Long > {

    public UserRegistrationEntity findByEmail (
            String email );

}
