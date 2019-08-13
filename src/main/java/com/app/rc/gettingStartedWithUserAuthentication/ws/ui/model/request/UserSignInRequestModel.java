
package com.app.rc.gettingStartedWithUserAuthentication.ws.ui.model.request;

/**
 * @author iHSPA
 */
public class UserSignInRequestModel {

    private String email;

    private String password;

    public UserSignInRequestModel ( ) {
    }

    /**
     * @param email
     * @param password
     */
    public UserSignInRequestModel ( String email,
            String password ) {
        super ( );
        this.email = email;
        this.password = password;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    @Override
    public String toString ( ) {
        return "UserSignInRequestModel [email=" + email
                + ", password=" + password + "]";
    }

}
