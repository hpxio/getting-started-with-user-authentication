package com.app.rc.app.ws.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    UserRegistrationRepository repository;

    @Autowired
    GenerateRandomUserId generateUid;

    @Override
    public UserRegistrationDto registerUser (
            UserRegistrationDto registerDto )
    {

        UserRegistrationEntity entity = new UserRegistrationEntity ( );
        UserRegistrationEntity resEntity = new UserRegistrationEntity ( );
        UserRegistrationDto res = new UserRegistrationDto ( );

        // Prepare internal data //
        registerDto.setEmailVerificationStatus (
                true );
        registerDto.setEmailVerificationToken (
                "s34hdk48d3l" );
        registerDto.setEncryptedPassword (
                "3iureyrimcn3k3" );
        registerDto.setUserId (
                generateUid.getRandomUserId (
                        16 ) );

        // Prepare data to push into DB //
        BeanUtils.copyProperties (
                registerDto,
                entity );

        // Get the saved data state //
        resEntity = repository.save (
                entity );

        // Prepare resultant DTO for controller //
        BeanUtils.copyProperties (
                resEntity,
                res );

        return res;
    }

}
