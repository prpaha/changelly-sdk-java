package ru.prpaha.changelly.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RPCResponse<RESULT> {

    private String jsonrpc;
    private String id;
    private RESULT result;

}
