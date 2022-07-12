package ru.javarush.operation.exception;

public class HackerException  extends RuntimeException{
    public HackerException() {}

    public HackerException(String message) {
        super(message);
    }

    public HackerException(String message, Throwable cause) {
        super(message, cause);
    }
}
