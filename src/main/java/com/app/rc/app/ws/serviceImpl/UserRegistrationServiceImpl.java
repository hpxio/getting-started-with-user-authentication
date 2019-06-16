
package com.app.rc.app.ws.serviceImpl;


import java.util.ArrayList;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.app.rc.app.ws.io.entity.UserRegistrationEntity;
import com.app.rc.app.ws.repository.UserRegistrationRepository;
import com.app.rc.app.ws.service.UserRegistrationService;
import com.app.rc.app.ws.shared.dto.UserRegistrationDto;
import com.app.rc.app.ws.shared.utils.GenerateRandomUserId;


/**
 * @author Harsh
 */
@Service
public class UserRegistrationServiceImpl
        implements
            UserRegistrationService {

    @Autowired
    UserRegistrationRepository repository;

    @Autowired
    GenerateRandomUserId generateUid;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordeEncoder;

    /**
     * 
     */
    @Override
    public UserRegistrationDto registerUser (
            UserRegistrationDto registerDto ) {

        /* General Validation */
        /*
         * if
         * (repository.findByEmail(registerDto.getEmail())
         * != null) { throw new
         * RuntimeException(); }
         */

        UserRegistrationEntity entity = new UserRegistrationEntity ( );
        UserRegistrationEntity resEntity = new UserRegistrationEntity ( );
        UserRegistrationDto res = new UserRegistrationDto ( );

        // Prepare internal data //
        registerDto.setEmailVerificationStatus ( true );
        registerDto.setEmailVerificationToken (
                generateUid.getRandomUserId ( 24 ) );
        registerDto.setEncryptedPassword (
                bCryptPasswordeEncoder.encode (
                        registerDto.getPassword ( ) ) );
        registerDto.setUserId (
                generateUid.getRandomUserId ( 16 ) );

        // Prepare data to push into DB //
        BeanUtils.copyProperties ( registerDto, entity );

        // Get the saved data state //
        resEntity = repository.save ( entity );

        // Prepare resultant DTO for controller //
        BeanUtils.copyProperties ( resEntity, res );

        return res;
    }

    @Override
    public UserDetails loadUserByUsername ( String email )
            throws UsernameNotFoundException {
        UserRegistrationEntity entity = repository
                .findByEmail ( email );

        if ( entity == null ) {
            throw new UsernameNotFoundException ( email );
        }

        return new User ( entity.getEmail ( ),
                entity.getEncryptedPassword ( ),
                new ArrayList<> ( ) );
    }

}
