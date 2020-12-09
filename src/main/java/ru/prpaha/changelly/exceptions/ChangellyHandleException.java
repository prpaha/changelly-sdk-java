package ru.prpaha.changelly.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@AllArgsConstructor
@Getter
public class ChangellyHandleException extends Exception{

    private int code;
    private String message;

}
