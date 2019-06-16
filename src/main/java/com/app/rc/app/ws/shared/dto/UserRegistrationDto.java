package com.app.rc.app.ws.shared.dto;

import java.io.Serializable;

public class UserRegistrationDto implements Serializable {

    private static final long serialVersionUID = -1138556971719309915L;

    private int id;

    private String userId;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String encryptedPassword;

    private String emailVerificationToken;

    private boolean emailVerificationStatus;

    public UserRegistrationDto ( ) {

    }

    /**
     * @param id
     * @param userId
     * @param email
     * @param firstName
     * @param lastName
     * @param password
     * @param encryptedPassword
     * @param emailVerificationToken
     * @param emailVerificationStatus
     */
    public UserRegistrationDto ( int id, String userId, String email,
            String firstName, String lastName, String password,
            String encryptedPassword, String emailVerificationToken,
            boolean emailVerificationStatus ) {
        super ( );
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.encryptedPassword = encryptedPassword;
        this.emailVerificationToken = emailVerificationToken;
        this.emailVerificationStatus = emailVerificationStatus;
    }

    /**
     * @return the userId
     */
    public String getUserId ( )
    {
        return userId;
    }

    /**
     * @param userId
     *                   the userId to set
     */
    public void setUserId (
            String userId )
    {
        this.userId = userId;
    }

    /**
     * @return the id
     */
    public int getId ( )
    {
        return id;
    }

    /**
     * @param id
     *               the id to set
     */
    public void setId (
            int id )
    {
        this.id = id;
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
     * @return the encryptedPassword
     */
    public String getEncryptedPassword ( )
    {
        return encryptedPassword;
    }

    /**
     * @param encryptedPassword
     *                              the encryptedPassword to set
     */
    public void setEncryptedPassword (
            String encryptedPassword )
    {
        this.encryptedPassword = encryptedPassword;
    }

    /**
     * @return the emailVerificationToken
     */
    public String getEmailVerificationToken ( )
    {
        return emailVerificationToken;
    }

    /**
     * @param emailVerificationToken
     *                                   the emailVerificationToken to set
     */
    public void setEmailVerificationToken (
            String emailVerificationToken )
    {
        this.emailVerificationToken = emailVerificationToken;
    }

    /**
     * @return the emailVerificationStatus
     */
    public boolean isEmailVerificationStatus ( )
    {
        return emailVerificationStatus;
    }

    /**
     * @param emailVerificationStatus
     *                                    the emailVerificationStatus to set
     */
    public void setEmailVerificationStatus (
            boolean emailVerificationStatus )
    {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    @Override
    public String toString ( )
    {
        return "UserRegistrationDto [id=" + id + ", userId=" + userId
                + ", email=" + email + ", firstName=" + firstName
                + ", lastName=" + lastName + ", password=" + password
                + ", encryptedPassword=" + encryptedPassword
                + ", emailVerificationToken=" + emailVerificationToken
                + ", emailVerificationStatus=" + emailVerificationStatus + "]";
    }

}
