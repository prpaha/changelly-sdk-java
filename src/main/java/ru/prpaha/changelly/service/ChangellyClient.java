package ru.prpaha.changelly.service;

import ru.prpaha.changelly.dto.RPCRequest;
import ru.prpaha.changelly.dto.RPCResponse;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public interface ChangellyClient {
    <REQUEST, RESPONSE> RPCRequest<REQUEST> invoke(RPCResponse<RESPONSE> response);
}
