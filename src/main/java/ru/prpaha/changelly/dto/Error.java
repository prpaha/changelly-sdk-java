package ru.prpaha.changelly.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
@AllArgsConstructor
public class Error {

    private final int code;
    private final String message;

}
