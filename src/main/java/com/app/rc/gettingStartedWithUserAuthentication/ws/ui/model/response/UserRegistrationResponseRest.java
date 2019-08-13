package com.app.rc.gettingStartedWithUserAuthentication.ws.ui.model.response;

public class UserRegistrationResponseRest {

    private String userId;

    private String firstName;

    private String lastName;

    public UserRegistrationResponseRest ( ) {

    }

    /**
     * @param userId
     * @param firstName
     * @param lastName
     * @param status
     */
    public UserRegistrationResponseRest ( String userId, String firstName,
            String lastName ) {
        super ( );
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString ( )
    {
        return "UserRegistrationResponseRest [userId=" + userId + ", firstName="
                + firstName + ", lastName=" + lastName + ", status=" + "]";
    }

}
