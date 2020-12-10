package ru.prpaha.changelly.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.prpaha.changelly.dto.Error;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
@AllArgsConstructor
public class RPCErrorResponse {

    private final String jsonrpc;
    private final String id;
    private final Error error;

}
