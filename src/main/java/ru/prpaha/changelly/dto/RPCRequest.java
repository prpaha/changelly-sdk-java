package ru.prpaha.changelly.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
@AllArgsConstructor
public class RPCRequest<PARAMS> {

    private final String jsonrpc;
    private final String id;
    private final String method;
    private final PARAMS params;

}
