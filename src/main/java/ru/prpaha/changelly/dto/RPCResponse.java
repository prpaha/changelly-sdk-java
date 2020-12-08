package ru.prpaha.changelly.dto;

import lombok.Getter;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
public class RPCResponse<RESULT> {

    private String jsonrpc;
    private String id;
    private RESULT result;

}
