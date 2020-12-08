package ru.prpaha.changelly.dto;

import lombok.Getter;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
public class RPCRequest<PARAMS> {

    private String jsonrpc;
    private String id;
    private String method;
    private PARAMS params;

}
