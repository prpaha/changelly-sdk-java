package ru.prpaha.changelly.exceptions;

import java.security.GeneralSecurityException;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class SignNotCompiled extends RuntimeException{
    public SignNotCompiled(GeneralSecurityException e) {
        super(e);
    }
}
