package com.app.rc.app.ws.shared.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author Harsh
 */
@Component
public class GenerateRandomUserId {

    private final Random RANDOM = new SecureRandom ( );

    private final int ITERATIONS = 10000;

    private final int KEY_LENGTH = 256;

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * @param length
     * @return
     */
    public String getRandomUserId (
            int length )
    {
        return this.generateRandomUserIdLocal (
                length );
    }

    /**
     * @param length
     * @return
     */
    private String generateRandomUserIdLocal (
            int length )
    {

        StringBuilder id = new StringBuilder ( );
        for ( int i = 0; i < length; i++ ) {
            id.append (
                    ALPHABET.charAt (
                            RANDOM.nextInt (
                                    ALPHABET.length ( ) ) ) );
        }
        return id.toString ( );
    }

}
