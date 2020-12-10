package ru.prpaha.changelly.service;

import ru.prpaha.changelly.dto.requests.RPCRequest;
import ru.prpaha.changelly.dto.responses.RPCResponse;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public interface ChangellyClient {
    <REQUEST extends RPCRequest<?>, RESPONSE extends RPCResponse<?>> RESPONSE invoke(REQUEST request,
                                                                                     Class<RESPONSE> clazz) throws ChangellyHandleException;
}
