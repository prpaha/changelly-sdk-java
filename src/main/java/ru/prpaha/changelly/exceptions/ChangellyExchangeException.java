package ru.prpaha.changelly.exceptions;

import java.io.IOException;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class ChangellyExchangeException extends RuntimeException {
    public ChangellyExchangeException(IOException e) {
        super(e);
    }

    public ChangellyExchangeException() {

    }
}
