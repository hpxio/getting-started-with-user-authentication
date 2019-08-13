package com.app.rc.gettingStartedWithUserAuthentication.ws.shared.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegistrationDTO implements Serializable {

    private static final long serialVersionUID = -1138556971719309915L;

    /* UUID of thr User Record*/
    private int id;

    /* Public User ID used for authentication */
    private String userId;

    /* Email ID for Login */
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    /* Encrypted value stored to the DB */
    private String encryptedPassword;

    /* Email validity & first-time setup token */
    private String emailVerificationToken;

    /* Current status of the User Record */
    private boolean emailVerificationStatus;
}
