package com.app.rc.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.rc.app.ws.service.UserRegistrationService;
import com.app.rc.app.ws.shared.dto.UserRegistrationDto;
import com.app.rc.app.ws.ui.model.request.UserRegistrationRequestModel;
import com.app.rc.app.ws.ui.model.response.UserRegistrationResponseRest;

@RestController
@RequestMapping ( "user" )
public class UserRegistrationConrtoller {

    @Autowired
    UserRegistrationService userRegistrationService;

    /**
     * Simple API for status check.
     * 
     * @return
     */
    @GetMapping
    public String user ( )
    {
        return "User Method Called";
    }

    /**
     * @return
     */
    @RequestMapping ( path = "/register", method = RequestMethod.POST )
    public UserRegistrationResponseRest createUser (
            @RequestBody UserRegistrationRequestModel registerRequest )
    {

        // Temporary objects //
        UserRegistrationDto registerDto = new UserRegistrationDto ( );
        UserRegistrationResponseRest registerRest = new UserRegistrationResponseRest ( );

        // prepare data for sharing //
        BeanUtils.copyProperties (
                registerRequest,
                registerDto );

        // Persist to DB and return result
        UserRegistrationDto registerResult = userRegistrationService
                .registerUser (
                        registerDto );

        // Prepare result object
        BeanUtils.copyProperties (
                registerResult,
                registerRest );

        // Return result
        return registerRest;
    }

}
