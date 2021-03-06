package ru.prpaha.changelly.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.prpaha.changelly.dto.Error;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@AllArgsConstructor
@Getter
public class ChangellyHandleException extends Exception{

    private final Error error;

}
