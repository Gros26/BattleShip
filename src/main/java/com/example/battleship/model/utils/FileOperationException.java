package com.example.battleship.model.utils;

/**
 * Custom exception for file operations in FileCRUD.
 * Demonstrates a user-defined checked exception.
 *
 * @author Grosman Garcia
 * @version 1
 */
class FileOperationException extends Exception {
    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
