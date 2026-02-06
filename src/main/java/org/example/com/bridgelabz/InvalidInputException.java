package org.example.com.bridgelabz;
/**
 * Custom exception used when
 * user input fails validation.
 */
class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(message);
    }
}
