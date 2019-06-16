package com.app.rc.app.ws.ui.model.request;

public class UserRegistrationRequestModel {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    public UserRegistrationRequestModel ( ) {

    }

    /**
     * 
     */
    @Override
    public String toString ( )
    {
        return "UserRegistrationRequestModel [email=" + email + ", password="
                + password + ", firstName=" + firstName + ", lastName="
                + lastName + "]";
    }

    /**
     * @param email
     * @param password
     * @param firstName
     * @param lastName
     */
    public UserRegistrationRequestModel ( String email, String password,
            String firstName, String lastName ) {
        super ( );
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail ( )
    {
        return email;
    }

    /**
     * @param email
     *                  the email to set
     */
    public void setEmail (
            String email )
    {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword ( )
    {
        return password;
    }

    /**
     * @param password
     *                     the password to set
     */
    public void setPassword (
            String password )
    {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName ( )
    {
        return firstName;
    }

    /**
     * @param firstName
     *                      the firstName to set
     */
    public void setFirstName (
            String firstName )
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName ( )
    {
        return lastName;
    }

    /**
     * @param lastName
     *                     the lastName to set
     */
    public void setLastName (
            String lastName )
    {
        this.lastName = lastName;
    }

}