
package com.app.rc.app.ws.service;


import org.springframework.security.core.userdetails.UserDetailsService;


import com.app.rc.app.ws.shared.dto.UserRegistrationDto;


public interface UserRegistrationService
        extends
            UserDetailsService {

    public UserRegistrationDto registerUser (
            UserRegistrationDto registerDto );

    public UserRegistrationDto getUser ( String email );
}
