package ru.prpaha.changelly.dto.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
@RequiredArgsConstructor
public class RPCRequest<PARAMS> {

    private static final String DEFAULT_JSONRPC = "2.0";

    private String jsonrpc = DEFAULT_JSONRPC;
    private final String id;
    private final String method;
    private final PARAMS params;

}
